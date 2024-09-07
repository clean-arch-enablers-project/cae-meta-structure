package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;

import java.util.List;

public class OutputsFolderMetaStructure extends FolderMetaStructure {

    private final String useCaseName;
    private final boolean kotlin;

    public OutputsFolderMetaStructure(FolderMetaStructure ioFolderMetaStructure, String useCaseName, boolean kotlin) {
        super(
                ioFolderMetaStructure,
                "outputs",
                TextCase.SNAKE
        );
        this.useCaseName = useCaseName;
        this.kotlin = kotlin;
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        return List.of();
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        return List.of(this.kotlin?
                new KotlinOutputFileMetaStructure(this, this.useCaseName) :
                new JavaOutputFileMetaStructure(this, this.useCaseName));
    }
}
