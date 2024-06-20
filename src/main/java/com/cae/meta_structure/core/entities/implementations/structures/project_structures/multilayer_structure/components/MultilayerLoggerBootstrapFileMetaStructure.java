package com.cae.meta_structure.core.entities.implementations.structures.project_structures.multilayer_structure.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.providers.JavaWorldInfoProvider;

public class MultilayerLoggerBootstrapFileMetaStructure extends FileMetaStructure {

    public MultilayerLoggerBootstrapFileMetaStructure(FolderMetaStructure parent) {
        super(parent,
                "LoggerBootstrap",
                TextCase.PASCAL,
                "java"
        );
        this.registerPlaceholder("groupId", JavaWorldInfoProvider.SINGLETON.getGroupId());
        this.registerPlaceholder("artifactId", JavaWorldInfoProvider.SINGLETON.getArtifactId());
    }
}
