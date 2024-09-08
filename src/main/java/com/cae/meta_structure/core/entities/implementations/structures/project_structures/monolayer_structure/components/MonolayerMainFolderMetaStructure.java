package com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;

import java.util.List;

public class MonolayerMainFolderMetaStructure extends FolderMetaStructure {


    public MonolayerMainFolderMetaStructure(FolderMetaStructure parent) {
        super(
                parent,
                "main",
                TextCase.CAMEL
                );
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        return List.of(
                new MonolayerJavaFolderMetaStructure(this),
                new MonolayerResourcesFolderMetaStructure(this)
        );
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        return List.of();
    }
}
