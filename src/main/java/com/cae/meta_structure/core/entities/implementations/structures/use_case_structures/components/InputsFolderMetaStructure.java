package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;

import java.util.List;

public class InputsFolderMetaStructure extends FolderMetaStructure {

    private final String useCaseName;
    private final boolean kotlin;

    public InputsFolderMetaStructure(FolderMetaStructure ioFolderMetaStructure, String useCaseName, boolean kotlin) {
        super(
                ioFolderMetaStructure,
                "inputs",
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
                new KotlinInputFileMetaStructure(this, this.useCaseName) :
                new JavaInputFileMetaStructure(this, this.useCaseName)
        );
    }
}
