package com.cae.meta_structure.core.entities.providers;

import com.cae.env_vars.EnvVarRetriever;
import com.cae.mapped_exceptions.specifics.InternalMappedException;
import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.components.*;
import com.cae.meta_structure.core.entities.implementations.structures.project_structures.multilayer_structure.components.JavaAdaptersPomFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.project_structures.multilayer_structure.components.JavaAssemblersPomFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.project_structures.multilayer_structure.components.JavaCorePomFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.project_structures.multilayer_structure.components.JavaMultilayerCaeSettingsFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.components.*;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.cuc.core.components.JavaCucContractFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.cuc.core.components.JavaCucImplementationFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.cuc.core.components.KotlinCucContractFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.cuc.core.components.KotlinCucImplementationFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.fuc.core.components.JavaFucContractFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.fuc.core.components.JavaFucImplementationFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.fuc.core.components.KotlinFucContractFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.fuc.core.components.KotlinFucImplementationFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.ruc.core.components.JavaRucContractFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.ruc.core.components.JavaRucImplementationFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.ruc.core.components.KotlinRucContractFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.ruc.core.components.KotlinRucImplementationFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.suc.core.components.JavaSucContractFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.suc.core.components.JavaSucImplementationFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.suc.core.components.KotlinSucContractFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.suc.core.components.KotlinSucImplementationFileMetaStructure;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JavaWorldTemplateProvider {

    public static final JavaWorldTemplateProvider SINGLETON = new JavaWorldTemplateProvider();

    public JavaWorldTemplateProvider() {
        this.templateRepository = new HashMap<>();
        this.templateRepository.put(JavaMonolayerCaeSettingsFileMetaStructure.class, getJavaMonolayerCaeSettingsFileMetaStructure());
        this.templateRepository.put(JavaMultilayerCaeSettingsFileMetaStructure.class, getJavaMultilayerCaeSettingsFileMetaStructure());
        this.templateRepository.put(JavaMonolayerPomFileMetaStructure.class, getJavaMonolayerPomFileMetaStructure());
        this.templateRepository.put(JavaAdaptersPomFileMetaStructure.class, getJavaAdaptersPomFileMetaStructure());
        this.templateRepository.put(JavaAssemblersPomFileMetaStructure.class, getJavaAssemblersPomFileMetaStructure());
        this.templateRepository.put(JavaCorePomFileMetaStructure.class, getJavaCorePomFileMetaStructure());
        this.templateRepository.put(JavaLoggerBootstrapFileMetaStructure.class, getJavaLoggerBootstrapFileMetaStructure());
        this.templateRepository.put(JavaLoggerAdapterFileMetaStructure.class, getJavaLoggerAdapterFileMetaStructure());
        this.templateRepository.put(JavaFucContractFileMetaStructure.class, getJavaFucContractFileMetaStructure());
        this.templateRepository.put(JavaCucContractFileMetaStructure.class, getJavaCucContractFileMetaStructure());
        this.templateRepository.put(JavaSucContractFileMetaStructure.class, getJavaSucContractFileMetaStructure());
        this.templateRepository.put(JavaRucContractFileMetaStructure.class, getJavaRucContractFileMetaStructure());
        this.templateRepository.put(JavaFucImplementationFileMetaStructure.class, getJavaFucImplementationFileMetaStructure());
        this.templateRepository.put(JavaCucImplementationFileMetaStructure.class, getJavaCucImplementationFileMetaStructure());
        this.templateRepository.put(JavaSucImplementationFileMetaStructure.class, getJavaSucImplementationFileMetaStructure());
        this.templateRepository.put(JavaRucImplementationFileMetaStructure.class, getJavaRucImplementationFileMetaStructure());
        this.templateRepository.put(JavaInputFileMetaStructure.class, getJavaInputFileMetaStructure());
        this.templateRepository.put(JavaOutputFileMetaStructure.class, getJavaOutputFileMetaStructure());
        this.templateRepository.put(JavaAssemblerFileMetaStructure.class, getJavaAssemblerFileMetaStructure());
        //KOTLIN DOWN BELOW
        this.templateRepository.put(KotlinLoggerBootstrapFileMetaStructure.class, getKotlinLoggerBootstrapFileMetaStructure());
        this.templateRepository.put(KotlinLoggerAdapterFileMetaStructure.class, getKotlinLoggerAdapterFileMetaStructure());
        this.templateRepository.put(KotlinFucContractFileMetaStructure.class, getKotlinFucContractFileMetaStructure());
        this.templateRepository.put(KotlinCucContractFileMetaStructure.class, getKotlinCucContractFileMetaStructure());
        this.templateRepository.put(KotlinSucContractFileMetaStructure.class, getKotlinSucContractFileMetaStructure());
        this.templateRepository.put(KotlinRucContractFileMetaStructure.class, getKotlinRucContractFileMetaStructure());
        this.templateRepository.put(KotlinFucImplementationFileMetaStructure.class, getKotlinFucImplementationFileMetaStructure());
        this.templateRepository.put(KotlinCucImplementationFileMetaStructure.class, getKotlinCucImplementationFileMetaStructure());
        this.templateRepository.put(KotlinSucImplementationFileMetaStructure.class, getKotlinSucImplementationFileMetaStructure());
        this.templateRepository.put(KotlinRucImplementationFileMetaStructure.class, getKotlinRucImplementationFileMetaStructure());
        this.templateRepository.put(KotlinInputFileMetaStructure.class, getKotlinInputFileMetaStructure());
        this.templateRepository.put(KotlinOutputFileMetaStructure.class, getKotlinOutputFileMetaStructure());
        this.templateRepository.put(KotlinAssemblerFileMetaStructure.class, getKotlinAssemblerFileMetaStructure());
    }

    public Optional<String> getTemplateFor(Class<? extends FileMetaStructure> metaFile){
        return Optional.ofNullable(this.templateRepository.get(metaFile));
    }

    private final Map<Class<? extends FileMetaStructure>, String> templateRepository;

    private String getJavaCorePomFileMetaStructure() {
        return getTemplate("java/poms/multilayer-core-pom-template.txt");
    }

    private String getJavaAssemblersPomFileMetaStructure() {
        return getTemplate("java/poms/multilayer-assemblers-pom-template.txt");
    }

    private String getJavaAdaptersPomFileMetaStructure() {
        return getTemplate("java/poms/multilayer-adapters-pom-template.txt");
    }

    private String getJavaMultilayerCaeSettingsFileMetaStructure() {
        return getTemplate("java/cae-settings/multilayer.txt");
    }

    private static String getJavaMonolayerPomFileMetaStructure(){
        return getTemplate("java/poms/monolayer-pom-template.txt");
    }

    private static String getJavaMonolayerCaeSettingsFileMetaStructure(){
        return getTemplate("java/cae-settings/monolayer.txt");
    }

    private static String getJavaLoggerAdapterFileMetaStructure() {
        return getTemplate("java/loggers/logger-adapter-template.txt");
    }

    private static String getJavaLoggerBootstrapFileMetaStructure() {
        return getTemplate("java/loggers/logger-bootstrap-template.txt");
    }

    private String getJavaFucContractFileMetaStructure() {
        return getTemplate("java/use-cases/fuc/contract-template.txt");
    }

    private String getJavaCucContractFileMetaStructure() {
        return getTemplate("java/use-cases/cuc/contract-template.txt");
    }

    private String getJavaSucContractFileMetaStructure() {
        return getTemplate("java/use-cases/suc/contract-template.txt");
    }

    private String getJavaRucContractFileMetaStructure() {
        return getTemplate("java/use-cases/ruc/contract-template.txt");
    }

    private String getJavaFucImplementationFileMetaStructure() {
        return getTemplate("java/use-cases/fuc/implementation-template.txt");
    }

    private String getJavaCucImplementationFileMetaStructure() {
        return getTemplate("java/use-cases/cuc/implementation-template.txt");
    }

    private String getJavaSucImplementationFileMetaStructure() {
        return getTemplate("java/use-cases/suc/implementation-template.txt");
    }

    private String getJavaRucImplementationFileMetaStructure() {
        return getTemplate("java/use-cases/ruc/implementation-template.txt");
    }

    private String getJavaInputFileMetaStructure() {
        return getTemplate("java/use-cases/overall/input-template.txt");
    }

    private String getJavaOutputFileMetaStructure() {
        return getTemplate("java/use-cases/overall/output-template.txt");
    }

    private String getJavaAssemblerFileMetaStructure() {
        return getTemplate("java/use-cases/assemblers/assembler-template.txt");
    }

    // KOTLIN DOWN BELOW

    private String getKotlinCorePomFileMetaStructure() {
        return getTemplate("kotlin/poms/multilayer-core-pom-template.txt");
    }

    private String getKotlinAssemblersPomFileMetaStructure() {
        return getTemplate("kotlin/poms/multilayer-assemblers-pom-template.txt");
    }

    private String getKotlinAdaptersPomFileMetaStructure() {
        return getTemplate("kotlin/poms/multilayer-adapters-pom-template.txt");
    }

    private String getKotlinMultilayerCaeSettingsFileMetaStructure() {
        return getTemplate("kotlin/cae-settings/multilayer.txt");
    }

    private static String getKotlinMonolayerPomFileMetaStructure(){
        return getTemplate("kotlin/poms/monolayer-pom-template.txt");
    }

    private static String getKotlinMonolayerCaeSettingsFileMetaStructure(){
        return getTemplate("kotlin/cae-settings/monolayer.txt");
    }

    private static String getKotlinLoggerAdapterFileMetaStructure() {
        return getTemplate("kotlin/loggers/logger-adapter-template.txt");
    }

    private static String getKotlinLoggerBootstrapFileMetaStructure() {
        return getTemplate("kotlin/loggers/logger-bootstrap-template.txt");
    }

    private String getKotlinFucContractFileMetaStructure() {
        return getTemplate("kotlin/use-cases/fuc/contract-template.txt");
    }

    private String getKotlinCucContractFileMetaStructure() {
        return getTemplate("kotlin/use-cases/cuc/contract-template.txt");
    }

    private String getKotlinSucContractFileMetaStructure() {
        return getTemplate("kotlin/use-cases/suc/contract-template.txt");
    }

    private String getKotlinRucContractFileMetaStructure() {
        return getTemplate("kotlin/use-cases/ruc/contract-template.txt");
    }

    private String getKotlinFucImplementationFileMetaStructure() {
        return getTemplate("kotlin/use-cases/fuc/implementation-template.txt");
    }

    private String getKotlinCucImplementationFileMetaStructure() {
        return getTemplate("kotlin/use-cases/cuc/implementation-template.txt");
    }

    private String getKotlinSucImplementationFileMetaStructure() {
        return getTemplate("kotlin/use-cases/suc/implementation-template.txt");
    }

    private String getKotlinRucImplementationFileMetaStructure() {
        return getTemplate("kotlin/use-cases/ruc/implementation-template.txt");
    }

    private String getKotlinInputFileMetaStructure() {
        return getTemplate("kotlin/use-cases/overall/input-template.txt");
    }

    private String getKotlinOutputFileMetaStructure() {
        return getTemplate("kotlin/use-cases/overall/output-template.txt");
    }

    private String getKotlinAssemblerFileMetaStructure() {
        return getTemplate("kotlin/use-cases/assemblers/assembler-template.txt");
    }

    private static String getTemplate(String rawPath){
        try {
            var rootPath = EnvVarRetriever.getEnvVarByNameAsString("CAE_META_STRUCTURE_TEMPLATES_PATH");
            String path = rootPath.concat(File.separator).concat(rawPath.replace("/", File.separator));
            var fullPath = Paths.get(path);
            if (Files.exists(fullPath))
                return Files.readString(fullPath);
            throw new IOException("File not found: " + path);
        } catch (IOException e) {
            throw new InternalMappedException(
                    "Something went wrong while trying to fetch a template for path '" + rawPath + "'",
                    "More details: " + e
            );
        }
    }

}
