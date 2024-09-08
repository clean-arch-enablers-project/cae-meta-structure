package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.enums.UseCaseTypes;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.cuc.core.components.JavaCucImplementationFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.cuc.core.components.KotlinCucImplementationFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.fuc.core.components.JavaFucImplementationFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.fuc.core.components.KotlinFucImplementationFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.ruc.core.components.JavaRucImplementationFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.ruc.core.components.KotlinRucImplementationFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.suc.core.components.JavaSucImplementationFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.suc.core.components.KotlinSucImplementationFileMetaStructure;

import java.util.List;

public class ImplementationsFolderMetaStructure extends FolderMetaStructure {

    private final UseCaseTypes useCaseType;
    private final boolean kotlin;

    public ImplementationsFolderMetaStructure(
            FolderMetaStructure parent,
            UseCaseTypes useCaseType,
            Boolean kotlin) {
        super(
                parent,
                "implementations",
                TextCase.SNAKE
        );
        this.useCaseType = useCaseType;
        this.kotlin = kotlin;
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        return List.of();
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        switch (this.useCaseType){
            case FUC:
                return List.of(this.kotlin?
                        new KotlinFucImplementationFileMetaStructure(this, this.parent.getName()) :
                        new JavaFucImplementationFileMetaStructure(this, this.parent.getName()));
            case CUC:
                return List.of(this.kotlin?
                        new KotlinCucImplementationFileMetaStructure(this, this.parent.getName()) :
                        new JavaCucImplementationFileMetaStructure(this, this.parent.getName()));
            case SUC:
                return List.of(this.kotlin?
                        new KotlinSucImplementationFileMetaStructure(this, this.parent.getName()) :
                        new JavaSucImplementationFileMetaStructure(this, this.parent.getName()));
            case RUC:
                return List.of(this.kotlin?
                        new KotlinRucImplementationFileMetaStructure(this, this.parent.getName()) :
                        new JavaRucImplementationFileMetaStructure(this, this.parent.getName()));
            default:
                return List.of();
        }
    }
}
