package com.cae.meta_structure.core.entities.implementations.structures.project_structures.multilayer_structure.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;

import java.util.List;

public class MultilayerGroupIdPartFolderMetaStructure extends FolderMetaStructure {

    private final List<String> groupIdPartsLeft;
    private final FolderMetaStructure origin;

    public MultilayerGroupIdPartFolderMetaStructure(FolderMetaStructure parent, List<String> groupIdPartsLeft, FolderMetaStructure origin) {
        super(
                parent,
                groupIdPartsLeft.get(0),
                TextCase.SNAKE
        );
        this.groupIdPartsLeft = groupIdPartsLeft;
        this.origin = origin;
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        return this.groupIdPartsLeft.size() == 1?
                List.of(new MultilayerArtifactIdFolderMetaStructure(this, this.origin)) :
                List.of(new MultilayerGroupIdPartFolderMetaStructure(this, this.groupIdPartsLeft.subList(1, this.groupIdPartsLeft.size()), this.origin));
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        return List.of();
    }
}
