package com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.providers.JavaWorldInfoProvider;

import java.util.List;

public class MonolayerJavaFolderMetaStructure extends FolderMetaStructure {

    public MonolayerJavaFolderMetaStructure(FolderMetaStructure parent) {
        super(
                parent,
                "java",
                TextCase.CAMEL);
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        var groupIdParts = List.of(JavaWorldInfoProvider.SINGLETON.getGroupId().split("\\."));
        return List.of(new MonolayerGroupIdPartFolderMetaStructure(this, groupIdParts));
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        return List.of();
    }
}
