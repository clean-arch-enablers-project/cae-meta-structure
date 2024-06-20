package com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.providers.JavaWorldInfoProvider;

import java.util.List;

public class MonolayerArtifactIdFolderMetaStructure extends FolderMetaStructure {


    public MonolayerArtifactIdFolderMetaStructure(FolderMetaStructure parent) {
        super(
                parent,
                JavaWorldInfoProvider.SINGLETON.getArtifactId(),
                TextCase.SNAKE
        );
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        return List.of(
                new MonolayerCoreFolderMetaStructure(this),
                new MonolayerAdaptersFolderMetaStructure(this),
                new MonolayerAssemblersFolderMetaStructure(this)
        );
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        return List.of();
    }
}
