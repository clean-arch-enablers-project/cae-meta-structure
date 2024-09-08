package com.cae.meta_structure.core.entities.implementations.structures.project_structures.multilayer_structure.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;

import java.util.List;

public class MultilayerMainFolderMetaStructure extends FolderMetaStructure {

    private final FolderMetaStructure origin;

    protected MultilayerMainFolderMetaStructure(FolderMetaStructure parent, FolderMetaStructure origin) {
        super(
                parent,
                "main",
                TextCase.KEBAB
        );
        this.origin = origin;
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        return List.of(new MultilayerJavaFolderMetaStructure(this, this.origin));
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        return List.of();
    }
}
