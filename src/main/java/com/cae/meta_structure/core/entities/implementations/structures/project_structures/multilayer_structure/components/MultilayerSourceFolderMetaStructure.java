package com.cae.meta_structure.core.entities.implementations.structures.project_structures.multilayer_structure.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;

import java.util.List;

public class MultilayerSourceFolderMetaStructure extends FolderMetaStructure {

    protected MultilayerSourceFolderMetaStructure(FolderMetaStructure parent) {
        super(
                parent,
                "src",
                TextCase.KEBAB);
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        return List.of(
                new MultilayerMainFolderMetaStructure(this, this.parent),
                new MultilayerTestFolderMetaStructure(this, this.parent)
        );
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        return List.of();
    }
}
