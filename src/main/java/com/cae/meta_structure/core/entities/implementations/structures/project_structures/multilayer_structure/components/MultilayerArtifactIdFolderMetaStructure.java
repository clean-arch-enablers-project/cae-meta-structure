package com.cae.meta_structure.core.entities.implementations.structures.project_structures.multilayer_structure.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.providers.JavaWorldInfoProvider;

import java.util.List;

public class MultilayerArtifactIdFolderMetaStructure extends FolderMetaStructure {

    private final FolderMetaStructure origin;

    protected MultilayerArtifactIdFolderMetaStructure(FolderMetaStructure parent, FolderMetaStructure origin) {
        super(
                parent,
                JavaWorldInfoProvider.SINGLETON.getArtifactId(),
                TextCase.SNAKE
        );
        this.origin = origin;
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        return List.of(new MultilayerNameFolderMetaStructure(this, this.origin));
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        return List.of();
    }
}
