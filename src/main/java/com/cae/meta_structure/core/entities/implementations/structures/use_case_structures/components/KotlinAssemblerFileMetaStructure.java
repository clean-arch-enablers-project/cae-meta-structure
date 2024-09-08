package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.providers.JavaWorldInfoProvider;

public class KotlinAssemblerFileMetaStructure extends FileMetaStructure {
    public KotlinAssemblerFileMetaStructure(FolderMetaStructure parent) {
        super(
            parent,
            parent.getName().concat("UseCaseAssembler"),
            TextCase.PASCAL,
            "kt"
        );
        this.registerPlaceholder("UseCaseName", this.getName().replace("UseCaseAssembler", ""));
        this.registerPlaceholder("GroupId", JavaWorldInfoProvider.SINGLETON.getGroupId());
        this.registerPlaceholder("ArtifactId", JavaWorldInfoProvider.SINGLETON.getArtifactId());
    }
}
