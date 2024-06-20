package com.cae.meta_structure.core.entities.providers;

import com.cae.env_vars.EnvVarRetriever;
import com.cae.mapped_exceptions.specifics.InternalMappedException;
import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.components.MonolayerCaeSettingsFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.components.MonolayerLoggerAdapterFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.components.MonolayerLoggerBootstrapFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.components.MonolayerPomFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.project_structures.multilayer_structure.components.*;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.components.AssemblerFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.components.InputFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.components.OutputFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.cuc.core.components.CucContractFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.cuc.core.components.CucImplementationFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.fuc.core.components.FucContractFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.fuc.core.components.FucImplementationFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.ruc.core.components.RucContractFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.ruc.core.components.RucImplementationFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.suc.core.components.SucContractFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.suc.core.components.SucImplementationFileMetaStructure;

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
        this.templateRepository.put(MonolayerPomFileMetaStructure .class, getMonolayerPomFileMetaStructure());
        this.templateRepository.put(MonolayerCaeSettingsFileMetaStructure .class, getMonolayerCaeSettingsFileMetaStructure());
        this.templateRepository.put(MonolayerLoggerAdapterFileMetaStructure .class, getMonolayerLoggerAdapterFileMetaStructure());
        this.templateRepository.put(MonolayerLoggerBootstrapFileMetaStructure .class, getMonolayerLoggerBootstrapFileMetaStructure());
        this.templateRepository.put(MultilayerCaeSettingsFileMetaStructure .class, getMultilayerCaeSettingsFileMetaStructure());
        this.templateRepository.put(AdaptersPomFileMetaStructure .class, getAdaptersPomFileMetaStructure());
        this.templateRepository.put(MultilayerLoggerAdapterFileMetaStructure .class, getMultilayerLoggerAdapterFileMetaStructure());
        this.templateRepository.put(AssemblersPomFileMetaStructure .class, getAssemblersPomFileMetaStructure());
        this.templateRepository.put(MultilayerLoggerBootstrapFileMetaStructure .class, getMultilayerLoggerBootstrapFileMetaStructure());
        this.templateRepository.put(CorePomFileMetaStructure.class, getCorePomFileMetaStructure());
        this.templateRepository.put(FucContractFileMetaStructure .class, getFucContractFileMetaStructure());
        this.templateRepository.put(CucContractFileMetaStructure .class, getCucContractFileMetaStructure());
        this.templateRepository.put(SucContractFileMetaStructure .class, getSucContractFileMetaStructure());
        this.templateRepository.put(RucContractFileMetaStructure .class, getRucContractFileMetaStructure());
        this.templateRepository.put(FucImplementationFileMetaStructure.class, getFucImplementationFileMetaStructure());
        this.templateRepository.put(CucImplementationFileMetaStructure.class, getCucImplementationFileMetaStructure());
        this.templateRepository.put(SucImplementationFileMetaStructure.class, getSucImplementationFileMetaStructure());
        this.templateRepository.put(RucImplementationFileMetaStructure.class, getRucImplementationFileMetaStructure());
        this.templateRepository.put(InputFileMetaStructure.class, getInputFileMetaStructure());
        this.templateRepository.put(OutputFileMetaStructure.class, getOutputFileMetaStructure());
        this.templateRepository.put(AssemblerFileMetaStructure.class, getAssemblerFileMetaStructure());
    }

    public Optional<String> getTemplateFor(Class<? extends FileMetaStructure> metaFile){
        return Optional.ofNullable(this.templateRepository.get(metaFile));
    }

    private final Map<Class<? extends FileMetaStructure>, String> templateRepository;

    private String getCorePomFileMetaStructure() {
        return getTemplate("poms/multilayer-core-pom-template.txt");
    }

    private String getMultilayerLoggerBootstrapFileMetaStructure() {
        return getTemplate("loggers/logger-bootstrap-template.txt");
    }

    private String getAssemblersPomFileMetaStructure() {
        return getTemplate("poms/multilayer-assemblers-pom-template.txt");
    }

    private String getMultilayerLoggerAdapterFileMetaStructure() {
        return getTemplate("loggers/logger-adapter-template.txt");
    }

    private String getAdaptersPomFileMetaStructure() {
        return getTemplate("poms/multilayer-adapters-pom-template.txt");
    }

    private String getMultilayerCaeSettingsFileMetaStructure() {
        return getTemplate("cae-settings/multilayer.txt");
    }

    private static String getMonolayerPomFileMetaStructure(){
        return getTemplate("poms/monolayer-pom-template.txt");
    }

    private static String getMonolayerCaeSettingsFileMetaStructure(){
        return getTemplate("cae-settings/monolayer.txt");
    }

    private static String getMonolayerLoggerAdapterFileMetaStructure() {
        return getTemplate("loggers/logger-adapter-template.txt");
    }

    private static String getMonolayerLoggerBootstrapFileMetaStructure() {
        return getTemplate("loggers/logger-bootstrap-template.txt");
    }

    private String getFucContractFileMetaStructure() {
        return getTemplate("use-cases/fuc/contract-template.txt");
    }

    private String getCucContractFileMetaStructure() {
        return getTemplate("use-cases/cuc/contract-template.txt");
    }

    private String getSucContractFileMetaStructure() {
        return getTemplate("use-cases/suc/contract-template.txt");
    }

    private String getRucContractFileMetaStructure() {
        return getTemplate("use-cases/ruc/contract-template.txt");
    }

    private String getFucImplementationFileMetaStructure() {
        return getTemplate("use-cases/fuc/implementation-template.txt");
    }

    private String getCucImplementationFileMetaStructure() {
        return getTemplate("use-cases/cuc/implementation-template.txt");
    }

    private String getSucImplementationFileMetaStructure() {
        return getTemplate("use-cases/suc/implementation-template.txt");
    }

    private String getRucImplementationFileMetaStructure() {
        return getTemplate("use-cases/ruc/implementation-template.txt");
    }

    private String getInputFileMetaStructure() {
        return getTemplate("use-cases/overall/input-template.txt");
    }

    private String getOutputFileMetaStructure() {
        return getTemplate("use-cases/overall/output-template.txt");
    }

    private String getAssemblerFileMetaStructure() {
        return getTemplate("use-cases/assemblers/assembler-template.txt");
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
