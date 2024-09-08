package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.enums.UseCaseTypes;

import java.util.ArrayList;
import java.util.List;

public class IOFolderMetaStructure extends FolderMetaStructure {

    private final UseCaseTypes useCaseType;
    private final boolean kotlin;

    public IOFolderMetaStructure(
            FolderMetaStructure basicUseCaseStructure,
            UseCaseTypes useCaseType,
            Boolean kotlin) {
        super(
                basicUseCaseStructure,
                "io",
                TextCase.SNAKE
        );
        this.useCaseType = useCaseType;
        this.kotlin = kotlin;
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        var folders = new ArrayList<FolderMetaStructure>();
        if (Boolean.TRUE.equals(this.useCaseType.getHasInput()))
            folders.add(new InputsFolderMetaStructure(this, this.parent.getName(), this.kotlin));
        if (Boolean.TRUE.equals(this.useCaseType.getHasOutput()))
            folders.add(new OutputsFolderMetaStructure(this, this.parent.getName(), this.kotlin));
        return folders;
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        return List.of();
    }
}
