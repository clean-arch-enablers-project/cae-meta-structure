package com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;

import java.util.List;

public class MonolayerAdaptersFolderMetaStructure extends FolderMetaStructure {

    public MonolayerAdaptersFolderMetaStructure(FolderMetaStructure parent) {
        super(
                parent,
                "adapters",
                TextCase.SNAKE
        );
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        return List.of(
                new MonolayerUseCasesFolderMetaStructure(this),
                new MonolayerAdaptersLoggerFolderMetaStructure(this)
        );
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        return List.of();
    }
}
