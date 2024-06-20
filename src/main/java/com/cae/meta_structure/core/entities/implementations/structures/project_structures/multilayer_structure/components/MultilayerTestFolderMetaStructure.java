package com.cae.meta_structure.core.entities.implementations.structures.project_structures.multilayer_structure.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;

import java.util.List;

public class MultilayerTestFolderMetaStructure extends FolderMetaStructure {

    private final FolderMetaStructure origin;

    protected MultilayerTestFolderMetaStructure(FolderMetaStructure parent, FolderMetaStructure origin) {
        super(
                parent,
                "test",
                TextCase.KEBAB
        );
        this.origin = origin;
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        return List.of();
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        return List.of();
    }
}
