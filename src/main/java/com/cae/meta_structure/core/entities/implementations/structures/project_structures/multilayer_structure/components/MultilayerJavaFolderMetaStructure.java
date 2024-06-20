package com.cae.meta_structure.core.entities.implementations.structures.project_structures.multilayer_structure.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.providers.JavaWorldInfoProvider;

import java.util.List;

public class MultilayerJavaFolderMetaStructure extends FolderMetaStructure {

    private final FolderMetaStructure origin;

    public MultilayerJavaFolderMetaStructure(FolderMetaStructure parent, FolderMetaStructure origin) {
        super(
                parent,
                "java",
                TextCase.KEBAB
        );
        this.origin = origin;
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        return List.of(new MultilayerGroupIdPartFolderMetaStructure(this, List.of(JavaWorldInfoProvider.SINGLETON.getGroupId().split("\\.")), this.origin));
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        return List.of();
    }
}
