package com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.providers.JavaWorldInfoProvider;

public class MonolayerCaeSettingsFileMetaStructure extends FileMetaStructure {

    public MonolayerCaeSettingsFileMetaStructure(FolderMetaStructure parent) {
        super(
                parent,
                "cae-settings",
                TextCase.KEBAB,
                "json"
        );
        this.registerPlaceholder("groupId", JavaWorldInfoProvider.SINGLETON.getGroupId());
        this.registerPlaceholder("artifactId", JavaWorldInfoProvider.SINGLETON.getArtifactId());
        this.registerPlaceholder("groupIdToPackageFormat", JavaWorldInfoProvider.SINGLETON.getGroupIdInPackageFormat());
        this.registerPlaceholder("caeFrameworkVersion", JavaWorldInfoProvider.SINGLETON.getCaeFrameworkVersion());
    }
}
