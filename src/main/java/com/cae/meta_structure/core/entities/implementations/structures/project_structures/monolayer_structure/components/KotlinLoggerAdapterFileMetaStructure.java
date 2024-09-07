package com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.providers.JavaWorldInfoProvider;

public class KotlinLoggerAdapterFileMetaStructure extends FileMetaStructure {

    public KotlinLoggerAdapterFileMetaStructure(FolderMetaStructure parent) {
        super(
                parent,
                "LoggerAdapter",
                TextCase.PASCAL,
                "kt"
        );
        this.registerPlaceholder("groupId", JavaWorldInfoProvider.SINGLETON.getGroupId());
        this.registerPlaceholder("artifactId", JavaWorldInfoProvider.SINGLETON.getArtifactId());
    }
}
