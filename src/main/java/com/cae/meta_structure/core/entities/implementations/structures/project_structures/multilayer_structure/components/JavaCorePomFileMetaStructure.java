package com.cae.meta_structure.core.entities.implementations.structures.project_structures.multilayer_structure.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.providers.JavaWorldInfoProvider;

public class JavaCorePomFileMetaStructure extends FileMetaStructure {

    public JavaCorePomFileMetaStructure(FolderMetaStructure parent) {
        super(
                parent,
                "pom",
                TextCase.KEBAB,
                "xml"
        );
        this.registerPlaceholder("groupId", JavaWorldInfoProvider.SINGLETON.getGroupId());
        this.registerPlaceholder("artifactId", JavaWorldInfoProvider.SINGLETON.getArtifactId());
        this.registerPlaceholder("cae-framework-version", JavaWorldInfoProvider.SINGLETON.getCaeFrameworkVersion());
    }
}
