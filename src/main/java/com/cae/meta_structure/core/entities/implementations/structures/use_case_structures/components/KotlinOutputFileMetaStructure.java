package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.providers.JavaWorldInfoProvider;

public class KotlinOutputFileMetaStructure extends FileMetaStructure {

    public KotlinOutputFileMetaStructure(FolderMetaStructure outputsFolderMetaStructure, String useCaseName) {
        super(
                outputsFolderMetaStructure,
                useCaseName.concat("UseCaseOutput"),
                TextCase.PASCAL,
                "kt"
        );
        this.registerPlaceholder("UseCaseName", this.getName().replace("UseCaseOutput", ""));
        this.registerPlaceholder("GroupId", JavaWorldInfoProvider.SINGLETON.getGroupId());
        this.registerPlaceholder("ArtifactId", JavaWorldInfoProvider.SINGLETON.getArtifactId());
    }
}
