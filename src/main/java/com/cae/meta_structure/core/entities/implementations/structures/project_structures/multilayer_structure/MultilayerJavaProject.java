package com.cae.meta_structure.core.entities.implementations.structures.project_structures.multilayer_structure;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.providers.JavaWorldInfoProvider;
import com.cae.meta_structure.core.entities.implementations.structures.project_structures.multilayer_structure.components.MultilayerAdaptersProject;
import com.cae.meta_structure.core.entities.implementations.structures.project_structures.multilayer_structure.components.MultilayerAssemblersProject;
import com.cae.meta_structure.core.entities.implementations.structures.project_structures.multilayer_structure.components.JavaMultilayerCaeSettingsFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.project_structures.multilayer_structure.components.MultilayerCoreProject;

import java.util.List;

public class MultilayerJavaProject extends FolderMetaStructure {

    private static final String CURRENT_PATH = System.getProperty("user.dir");

    public MultilayerJavaProject(String artifactId, String groupId, String caeVersion) {
        super(
                CURRENT_PATH,
                artifactId,
                TextCase.KEBAB
        );
        JavaWorldInfoProvider.SINGLETON.setArtifactId(artifactId);
        JavaWorldInfoProvider.SINGLETON.setGroupId(groupId);
        JavaWorldInfoProvider.SINGLETON.setCaeFrameworkVersion(caeVersion);
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        return List.of(
                new MultilayerAdaptersProject(this),
                new MultilayerAssemblersProject(this),
                new MultilayerCoreProject(this)
        );
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        return List.of(new JavaMultilayerCaeSettingsFileMetaStructure(this));
    }
}
