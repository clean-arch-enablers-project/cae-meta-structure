package com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;

import java.util.List;

public class MonolayerGroupIdPartFolderMetaStructure extends FolderMetaStructure {

    private final List<String> groupIdPartsLeft;

    public MonolayerGroupIdPartFolderMetaStructure(FolderMetaStructure parent, List<String> groupIdPartsLeft) {
        super(
                parent,
                groupIdPartsLeft.get(0),
                TextCase.SNAKE
        );
        this.groupIdPartsLeft = groupIdPartsLeft;
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        return this.groupIdPartsLeft.size() == 1?
                List.of(new MonolayerArtifactIdFolderMetaStructure(this)) :
                List.of(new MonolayerGroupIdPartFolderMetaStructure(this, this.groupIdPartsLeft.subList(1, this.groupIdPartsLeft.size())));
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        return List.of();
    }
}
