package com.cae.meta_structure.core.entities.implementations.structures.project_structures.multilayer_structure.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.components.JavaLoggerBootstrapFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.components.KotlinLoggerBootstrapFileMetaStructure;

import java.util.List;

public class MultilayerAssemblersLoggerFolderMetaStructure extends FolderMetaStructure {

    private final boolean kotlin;

    protected MultilayerAssemblersLoggerFolderMetaStructure(FolderMetaStructure parent, Boolean kotlin) {
        super(
                parent,
                "logger",
                TextCase.SNAKE
        );
        this.kotlin = kotlin;
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        return List.of();
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        return List.of(this.kotlin?
                new KotlinLoggerBootstrapFileMetaStructure(this) :
                new JavaLoggerBootstrapFileMetaStructure(this)
        );
    }
}
