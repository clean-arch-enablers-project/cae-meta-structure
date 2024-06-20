package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.enums.UseCaseTypes;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.cuc.core.components.CucImplementationFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.fuc.core.components.FucImplementationFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.ruc.core.components.RucImplementationFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.suc.core.components.SucImplementationFileMetaStructure;

import java.util.List;

public class ImplementationsFolderMetaStructure extends FolderMetaStructure {

    private final UseCaseTypes useCaseType;

    public ImplementationsFolderMetaStructure(FolderMetaStructure parent, UseCaseTypes useCaseType) {
        super(
                parent,
                "implementations",
                TextCase.SNAKE
        );
        this.useCaseType = useCaseType;
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        return List.of();
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        switch (this.useCaseType){
            case FUC:
                return List.of(new FucImplementationFileMetaStructure(this, this.parent.getName()));
            case CUC:
                return List.of(new CucImplementationFileMetaStructure(this, this.parent.getName()));
            case SUC:
                return List.of(new SucImplementationFileMetaStructure(this, this.parent.getName()));
            case RUC:
                return List.of(new RucImplementationFileMetaStructure(this, this.parent.getName()));
            default:
                return List.of();
        }
    }
}
