package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.fuc.core.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.providers.JavaWorldInfoProvider;

public class JavaFucContractFileMetaStructure extends FileMetaStructure {

    public JavaFucContractFileMetaStructure(FolderMetaStructure parent) {
        super(
                parent,
                parent.getName().concat("UseCase"),
                TextCase.PASCAL,
                "java"
        );
        this.registerPlaceholder("UseCaseName", this.getName().replace("UseCase", ""));
        this.registerPlaceholder("GroupId", JavaWorldInfoProvider.SINGLETON.getGroupId());
        this.registerPlaceholder("ArtifactId", JavaWorldInfoProvider.SINGLETON.getArtifactId());
    }
}
