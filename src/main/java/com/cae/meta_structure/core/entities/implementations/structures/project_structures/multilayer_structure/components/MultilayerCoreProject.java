package com.cae.meta_structure.core.entities.implementations.structures.project_structures.multilayer_structure.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;

import java.util.List;

public class MultilayerCoreProject extends FolderMetaStructure {

    public MultilayerCoreProject(FolderMetaStructure parent) {
        super(
                parent,
                "core",
                TextCase.KEBAB);
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        return List.of(new MultilayerSourceFolderMetaStructure(this));
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        return List.of(new JavaCorePomFileMetaStructure(this));
    }
}
