package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.providers.JavaWorldInfoProvider;

public class InputFileMetaStructure extends FileMetaStructure {

    public InputFileMetaStructure(FolderMetaStructure inputsFolderMetaStructure, String useCaseName) {
        super(
                inputsFolderMetaStructure,
                useCaseName.concat("UseCaseInput"),
                TextCase.PASCAL,
                "java"
        );
        this.registerPlaceholder("UseCaseName", this.getName().replace("UseCaseInput", ""));
        this.registerPlaceholder("GroupId", JavaWorldInfoProvider.SINGLETON.getGroupId());
        this.registerPlaceholder("ArtifactId", JavaWorldInfoProvider.SINGLETON.getArtifactId());
    }
}
