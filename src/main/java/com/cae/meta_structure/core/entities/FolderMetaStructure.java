package com.cae.meta_structure.core.entities;

import com.cae.mapped_exceptions.specifics.InternalMappedException;
import com.cae.meta_structure.core.entities.enums.TextCase;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Getter
@Setter
public abstract class FolderMetaStructure extends MetaStructure{

    protected final String location;
    protected final FolderMetaStructure parent;
    protected final String name;
    protected final TextCase nameTextCase;

    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private List<FolderMetaStructure> neededFolders;

    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private List<FileMetaStructure> neededFiles;

    protected FolderMetaStructure(
            String location,
            String name,
            TextCase nameTextCase) {
        this.location = location;
        this.parent = null;
        this.name = name;
        this.nameTextCase = nameTextCase;
    }

    protected FolderMetaStructure(
            FolderMetaStructure parent,
            String name,
            TextCase nameTextCase) {
        this.location = parent.getFullQualifiedPath();
        this.parent = parent;
        this.name = name;
        this.nameTextCase = nameTextCase;
    }

    private List<FolderMetaStructure> retrieveNeededFolders(){
        return Optional.ofNullable(this.getNeededFolders()).orElseGet(() -> {
            this.setNeededFolders(this.defineNeededFolders());
            return this.getNeededFolders();
        });
    }

    protected abstract List<FolderMetaStructure> defineNeededFolders();

    private List<FileMetaStructure> retrieveNeededFiles(){
        return Optional.ofNullable(this.getNeededFiles()).orElseGet(() -> {
            this.setNeededFiles(this.defineNeededFiles());
            return this.getNeededFiles();
        });
    }

    protected abstract List<FileMetaStructure> defineNeededFiles();


    public String getFullQualifiedPath(){
        return this.location
                .concat(File.separator)
                .concat(this.nameTextCase.getTransformer().transform(this.name));
    }

    @Override
    public void create(){
        var directory = new File(this.getFullQualifiedPath());
        if (!directory.exists() && !directory.mkdirs())
                throw new InternalMappedException(
                        "Something went wrong while trying to create folder '" + this.getName() + "'",
                        "Full path: " + this.getFullQualifiedPath()
                );
        this.createChildren();
    }

    private void createChildren() {
        Stream.concat(
                this.retrieveNeededFiles().stream(),
                this.retrieveNeededFolders().stream()
        ).forEach(MetaStructure::create);
    }

}
