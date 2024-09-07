package com.cae.meta_structure.core.entities.implementations.structures.project_structures.multilayer_structure.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;

import java.util.List;

public class MultilayerNameFolderMetaStructure extends FolderMetaStructure {

    private final FolderMetaStructure origin;

    protected MultilayerNameFolderMetaStructure(FolderMetaStructure parent, FolderMetaStructure origin) {
        super(
                parent,
                origin.getName(),
                TextCase.SNAKE);
        this.origin = origin;
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        switch (this.origin.getName()) {
            case "core":
                return List.of(
                        new MultilayerEntitiesFolderMetaStructure(this),
                        new MultilayerUseCasesFolderMetaStructure(this)
                );
            case "adapters":
                return List.of(
                        new MultilayerAdaptersLoggerFolderMetaStructure(this),
                        new MultilayerUseCasesFolderMetaStructure(this)
                );
            case "assemblers":
                return List.of(
                        new MultilayerAssemblersLoggerFolderMetaStructure(this, false),
                        new MultilayerUseCasesFolderMetaStructure(this)
                );
            default:
                return List.of();
        }
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        return List.of();
    }
}
