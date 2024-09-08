package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.suc.core.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.providers.JavaWorldInfoProvider;

public class KotlinSucImplementationFileMetaStructure extends FileMetaStructure {

    public KotlinSucImplementationFileMetaStructure(FolderMetaStructure implementationsFolderMetaStructure, String name) {
        super(
                implementationsFolderMetaStructure,
                name.concat("UseCaseImplementation"),
                TextCase.PASCAL,
                "kt"
        );
        this.registerPlaceholder("UseCaseName", this.getName().replace("UseCaseImplementation", ""));
        this.registerPlaceholder("GroupId", JavaWorldInfoProvider.SINGLETON.getGroupId());
        this.registerPlaceholder("ArtifactId", JavaWorldInfoProvider.SINGLETON.getArtifactId());
    }
}
