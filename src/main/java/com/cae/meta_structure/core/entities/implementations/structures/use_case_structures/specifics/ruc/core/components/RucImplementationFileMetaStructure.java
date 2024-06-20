package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.ruc.core.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.components.ImplementationsFolderMetaStructure;
import com.cae.meta_structure.core.entities.providers.JavaWorldInfoProvider;

public class RucImplementationFileMetaStructure extends FileMetaStructure {
    public RucImplementationFileMetaStructure(ImplementationsFolderMetaStructure implementationsFolderMetaStructure, String name) {
        super(
                implementationsFolderMetaStructure,
                name.concat("UseCaseImplementation"),
                TextCase.PASCAL,
                "java"
        );
        this.registerPlaceholder("UseCaseName", this.getName().replace("UseCaseImplementation", ""));
        this.registerPlaceholder("GroupId", JavaWorldInfoProvider.SINGLETON.getGroupId());
        this.registerPlaceholder("ArtifactId", JavaWorldInfoProvider.SINGLETON.getArtifactId());
    }
}
