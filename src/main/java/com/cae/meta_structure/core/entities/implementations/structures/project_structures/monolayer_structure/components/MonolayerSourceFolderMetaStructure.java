package com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;

import java.util.List;

public class MonolayerSourceFolderMetaStructure extends FolderMetaStructure {

    public MonolayerSourceFolderMetaStructure(
            FolderMetaStructure parent) {
        super(
                parent,
                "src",
                TextCase.CAMEL
        );
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        return List.of(
                new MonolayerMainFolderMetaStructure(this),
                new MonolayerTestFolderMetaStructure(this)
        );
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        return List.of();
    }
}
