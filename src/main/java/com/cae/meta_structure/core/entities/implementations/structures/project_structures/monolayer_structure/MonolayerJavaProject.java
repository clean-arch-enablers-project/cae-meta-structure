package com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.components.MonolayerCaeSettingsFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.components.MonolayerPomFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.components.MonolayerSourceFolderMetaStructure;
import com.cae.meta_structure.core.entities.providers.JavaWorldInfoProvider;

import java.util.List;

public class MonolayerJavaProject extends FolderMetaStructure {

    private static final String CURRENT_RELATIVE_PATH = System.getProperty("user.dir");
    private final String mergedDependencies;

    public MonolayerJavaProject(String artifactId, String groupId, String caeVersion) {
        super(
                CURRENT_RELATIVE_PATH ,
                artifactId,
                TextCase.KEBAB
        );
        this.mergedDependencies = null;
        JavaWorldInfoProvider.SINGLETON.setArtifactId(artifactId);
        JavaWorldInfoProvider.SINGLETON.setGroupId(groupId);
        JavaWorldInfoProvider.SINGLETON.setCaeFrameworkVersion(caeVersion);
    }

    public MonolayerJavaProject(String artifactId, String groupId, String caeVersion, String rotateContext, String mergedDependencies) {
        super(
                rotateContext,
                artifactId,
                TextCase.KEBAB
        );
        this.mergedDependencies = mergedDependencies;
        JavaWorldInfoProvider.SINGLETON.setArtifactId(artifactId);
        JavaWorldInfoProvider.SINGLETON.setGroupId(groupId);
        JavaWorldInfoProvider.SINGLETON.setCaeFrameworkVersion(caeVersion);
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        return List.of(
            new MonolayerSourceFolderMetaStructure(this)
        );
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        return List.of(
            new MonolayerPomFileMetaStructure(this, this.mergedDependencies),
            new MonolayerCaeSettingsFileMetaStructure(this)
        );
    }
}
