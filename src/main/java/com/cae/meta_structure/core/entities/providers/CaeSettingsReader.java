package com.cae.meta_structure.core.entities.providers;

import com.cae.mapped_exceptions.specifics.InternalMappedException;
import com.cae.mapped_exceptions.specifics.NotFoundMappedException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CaeSettingsReader {

    public static final CaeSettingsReader SINGLETON = new CaeSettingsReader();
    private static final String FILE_NAME = "cae-settings.json";

    private CaeSettingsFileModel caeSettingsFileContent;

    public String getCoreUseCasesPath(){
        return this.getLocationForLayer("core");
    }

    public String getAdaptersUseCasePath(){
        return this.getLocationForLayer("adapters");
    }

    public String getAssemblersUseCasePath(){
        return this.getLocationForLayer("assemblers");
    }

    public Boolean isMonolayer(){
        return this.getCaeSettingsFileContent().getMonolayer();
    }

    public String getOrganization(){
        return this.getCaeSettingsFileContent().getOrganization();
    }

    public String getDomain(){
        return this.getCaeSettingsFileContent().getDomain();
    }

    public String getCaeVersion(){
        return this.getCaeSettingsFileContent().getCaeVersion();
    }

    private String getLocationForLayer(String layer){
        return this.getCaeSettingsFileContent()
                .getUseCasePaths()
                .stream()
                .filter(useCasePath -> useCasePath.getLayer().equalsIgnoreCase(layer))
                .findFirst()
                .orElseThrow(() -> new NotFoundMappedException(
                        "the location for the '" +layer + "' layer was not found within your '" + FILE_NAME + "'"
                ))
                .getLocation();
    }

    private CaeSettingsFileModel getCaeSettingsFileContent(){
        return Optional.ofNullable(this.caeSettingsFileContent).orElseGet(() -> {
            this.caeSettingsFileContent = this.loadCaeSettingsFile();
            return this.caeSettingsFileContent;
        });
    }

    private CaeSettingsFileModel loadCaeSettingsFile() {
        var currentPath = System.getProperty("user.dir");
        var expectedCaeSettingsFileLocation = Paths.get(currentPath.concat(File.separator).concat(FILE_NAME));
        if (Files.exists(expectedCaeSettingsFileLocation)){
            try {
                var rawContent = Files.readString(expectedCaeSettingsFileLocation);
                var content = new ObjectMapper().readValue(rawContent, CaeSettingsFileModel.class);
                JavaWorldInfoProvider.SINGLETON.setArtifactId(content.getDomain());
                JavaWorldInfoProvider.SINGLETON.setGroupId(content.getOrganization());
                JavaWorldInfoProvider.SINGLETON.setCaeFrameworkVersion(content.getCaeVersion());
                return content;
            } catch (IOException someProblem) {
                throw new InternalMappedException(
                        "Something went wrong while trying to read the '" + FILE_NAME + "' file",
                        "More details: " + someProblem
                );
            }
        }
        else
            throw new NotFoundMappedException(
                    "The '" + FILE_NAME + "' was not found",
                    "More details: the execution should take place at the root path of your CAE project. There we expect to find the settings file named '" + FILE_NAME + "'"
            );
    }

    @Getter
    @Setter
    public static class CaeSettingsFileModel{

        private String organization;
        private String domain;
        private Boolean monolayer;
        private String caeVersion;
        private List<UseCasePath> useCasePaths;

    }

    @Getter
    @Setter
    public static class UseCasePath{

        private String layer;
        private String location;

    }

}
