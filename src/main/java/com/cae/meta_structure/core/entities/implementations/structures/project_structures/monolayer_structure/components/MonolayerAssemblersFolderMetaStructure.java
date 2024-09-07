package com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;

import java.util.List;

public class MonolayerAssemblersFolderMetaStructure extends FolderMetaStructure {

    public MonolayerAssemblersFolderMetaStructure(FolderMetaStructure parent) {
        super(
                parent,
                "assemblers",
                TextCase.SNAKE
        );
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        return List.of(
                new MonolayerUseCasesFolderMetaStructure(this),
                new MonolayerAssemblersLoggerFolderMetaStructure(this, false)
        );
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        return List.of();
    }
}
