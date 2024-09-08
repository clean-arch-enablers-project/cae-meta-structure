package com.cae.meta_structure.core.entities;


import com.cae.mapped_exceptions.specifics.InternalMappedException;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.providers.JavaWorldTemplateProvider;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

@Getter
@Setter
public abstract class FileMetaStructure extends MetaStructure{

    protected final String location;
    protected final FolderMetaStructure parent;
    protected final String name;
    protected final TextCase nameTextCase;
    protected final String extension;
    protected final String template;
    protected final Map<String, String> placeholdersAndTheirValues = new HashMap<>();
    protected String processedTemplate;

    private static String getTemplateFor(Class<? extends FileMetaStructure> metaFileClass){
        return JavaWorldTemplateProvider.SINGLETON.getTemplateFor(metaFileClass)
                .orElseThrow(() -> new InternalMappedException(
                        "No template provided for " + metaFileClass.getSimpleName(),
                        "Provide a template in the " + JavaWorldTemplateProvider.class.getSimpleName())
                );
    }

    protected FileMetaStructure(
            String location,
            String name,
            TextCase nameTextCase,
            String extension) {
        this.location = location;
        this.parent = null;
        this.name = name;
        this.nameTextCase = nameTextCase;
        this.extension = extension;
        this.template = FileMetaStructure.getTemplateFor(this.getClass());
        this.processedTemplate = this.template;
    }

    protected FileMetaStructure(
            FolderMetaStructure parent,
            String name,
            TextCase nameTextCase,
            String extension) {
        this.location = parent.getFullQualifiedPath();
        this.parent = parent;
        this.name = name;
        this.nameTextCase = nameTextCase;
        this.extension = extension;
        this.template = FileMetaStructure.getTemplateFor(this.getClass());
        this.processedTemplate = this.template;
    }

    private String getQualifiedName(){
        return this.nameTextCase.getTransformer().transform(this.name)
                .concat(".")
                .concat(this.extension);
    }

    private String getFullPath(){
        return this.location.concat(File.separator)
                .concat(this.getQualifiedName());
    }

    @Override
    public void create() {
        try(var fileWriter = new BufferedWriter(new FileWriter(this.getFullPath()))){
            fileWriter.append(this.processPlaceholdersInTemplate());
        } catch (Exception someProblem) {
            throw new InternalMappedException(
                    "Something went wrong while creating '" + this.getQualifiedName() + "'",
                    "More details: " + someProblem
            );
        }
    }

    protected void registerPlaceholder(String placeholder, String value){
        this.placeholdersAndTheirValues.put(placeholder, value);
    }

    protected Map<String, List<TextCase>> getAllPlaceholdersFromTemplate(){
        var mapOfFoundPlaceholders = new HashMap<String, List<TextCase>>();
        var placeholderBuilder = new StringBuilder();
        var textCaseNameBuilder = new StringBuilder();
        var suspectOfMappingPlaceholder = false;
        var mappingPlaceholder = false;
        var mappingTextCaseName = false;
        for (var index = 0; index < this.template.length(); index ++){
            var letter = this.template.charAt(index);
            if (letter == '{' && !suspectOfMappingPlaceholder && !mappingPlaceholder){
                suspectOfMappingPlaceholder = true;
                continue;
            }
            if (suspectOfMappingPlaceholder && letter == '{'){
                suspectOfMappingPlaceholder = false;
                mappingPlaceholder = true;
            }
            else{
                suspectOfMappingPlaceholder = false;
            }
            if (letter == ':' && mappingPlaceholder){
                mappingPlaceholder = false;
                mappingTextCaseName = true;
            }
            else if (letter == '}' && mappingTextCaseName){
                mappingTextCaseName = false;
                var alreadyPresent = mapOfFoundPlaceholders.get(placeholderBuilder.toString());
                if (alreadyPresent == null){
                    var newArray = new ArrayList<TextCase>();
                    newArray.add(TextCase.valueOf(textCaseNameBuilder.toString()));
                    mapOfFoundPlaceholders.put(placeholderBuilder.toString(), newArray);
                }
                else
                    alreadyPresent.add(TextCase.valueOf(textCaseNameBuilder.toString()));
                placeholderBuilder.delete(0, placeholderBuilder.length());
                textCaseNameBuilder.delete(0, textCaseNameBuilder.length());
            }
            if (mappingPlaceholder && letter != '{')
                placeholderBuilder.append(letter);
            if(mappingTextCaseName && letter != ':')
                textCaseNameBuilder.append(letter);
        }
        return mapOfFoundPlaceholders;
    }

    protected String processPlaceholdersInTemplate(){
        var placeholdersInTemplate = this.getAllPlaceholdersFromTemplate();
        placeholdersInTemplate.forEach((placeholder, textCases) -> {
            var mappedValue = Optional.ofNullable(this.placeholdersAndTheirValues.get(placeholder))
                    .orElseThrow(() -> new InternalMappedException(
                            "Something went wrong while trying to process template for '" + this.getName() + "' meta file",
                            "More details: couldn't find placeholder '" + placeholder + "'"
                    ));
            textCases.forEach(textCase ->
                this.processedTemplate = this.processedTemplate.replace("{{" + placeholder + ":" + textCase.getName() + "}}", textCase.getTransformer().transform(mappedValue))
            );
        });
        return this.processedTemplate;
    }



}
