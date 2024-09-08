package com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;

import java.util.List;

public class MonolayerAdaptersLoggerFolderMetaStructure extends FolderMetaStructure {

    public MonolayerAdaptersLoggerFolderMetaStructure(FolderMetaStructure parent) {
        super(
                parent,
                "logger",
                TextCase.SNAKE);
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        return List.of();
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        return List.of(
                new JavaLoggerAdapterFileMetaStructure(this)
        );
    }
}
