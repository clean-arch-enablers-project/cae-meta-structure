package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.fuc.core.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.providers.JavaWorldInfoProvider;

public class KotlinFucImplementationFileMetaStructure extends FileMetaStructure {

    public KotlinFucImplementationFileMetaStructure(
            FolderMetaStructure implementationsFolderMetaStructure,
            String useCaseName) {
        super(
                implementationsFolderMetaStructure,
                useCaseName.concat("UseCaseImplementation"),
                TextCase.PASCAL,
                "kt"
        );
        this.registerPlaceholder("UseCaseName", this.getName().replace("UseCaseImplementation", ""));
        this.registerPlaceholder("GroupId", JavaWorldInfoProvider.SINGLETON.getGroupId());
        this.registerPlaceholder("ArtifactId", JavaWorldInfoProvider.SINGLETON.getArtifactId());
    }
}
