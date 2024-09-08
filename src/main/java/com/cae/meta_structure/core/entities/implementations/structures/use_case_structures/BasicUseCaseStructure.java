package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.Layers;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.enums.UseCaseTypes;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.components.JavaAssemblerFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.components.IOFolderMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.components.ImplementationsFolderMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.components.KotlinAssemblerFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.cuc.core.components.JavaCucContractFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.cuc.core.components.KotlinCucContractFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.fuc.core.components.JavaFucContractFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.fuc.core.components.KotlinFucContractFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.ruc.core.components.JavaRucContractFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.ruc.core.components.KotlinRucContractFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.suc.core.components.JavaSucContractFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.suc.core.components.KotlinSucContractFileMetaStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class BasicUseCaseStructure extends FolderMetaStructure {

    private final Layers layer;
    private final UseCaseTypes useCaseType;
    private final boolean kotlin;

    protected BasicUseCaseStructure(
            String structureLocation,
            String useCaseName,
            Layers structureLocationLayer,
            UseCaseTypes useCaseTypeEnum,
            Boolean kotlin) {
        super(
                structureLocation,
                useCaseName,
                TextCase.SNAKE
        );
        this.layer = structureLocationLayer;
        this.useCaseType = useCaseTypeEnum;
        this.kotlin = kotlin;
    }

    @Override
    protected List<FolderMetaStructure> defineNeededFolders() {
        if (Objects.requireNonNull(this.layer) == Layers.CORE) {
            return this.getFoldersForCoreLayer();
        }
        return List.of();
    }

    @Override
    protected List<FileMetaStructure> defineNeededFiles() {
        switch (this.layer){
            case CORE:
                return this.getFilesForCoreLayer();
            case ASSEMBLERS:
                return this.getFilesForAssemblersLayer();
            default:
                return List.of();
        }
    }

    private List<FileMetaStructure> getFilesForCoreLayer(){
        switch (this.useCaseType){
            case FUC:
                return List.of(this.kotlin? new KotlinFucContractFileMetaStructure(this) : new JavaFucContractFileMetaStructure(this));
            case CUC:
                return List.of(this.kotlin? new KotlinCucContractFileMetaStructure(this): new JavaCucContractFileMetaStructure(this));
            case SUC:
                return List.of(this.kotlin? new KotlinSucContractFileMetaStructure(this) : new JavaSucContractFileMetaStructure(this));
            case RUC:
                return List.of(this.kotlin? new KotlinRucContractFileMetaStructure(this) : new JavaRucContractFileMetaStructure(this));
            default:
                return List.of();
        }
    }

    private List<FileMetaStructure> getFilesForAssemblersLayer(){
        return List.of(this.kotlin? new KotlinAssemblerFileMetaStructure(this) : new JavaAssemblerFileMetaStructure(this));
    }

    private List<FolderMetaStructure> getFoldersForCoreLayer(){
        var folders = new ArrayList<FolderMetaStructure>();
        folders.add(new ImplementationsFolderMetaStructure(this, this.useCaseType, this.kotlin));
        if (this.useCaseType.getHasInput() || this.useCaseType.getHasOutput())
            folders.add(new IOFolderMetaStructure(this, this.useCaseType, this.kotlin));
        return folders;
    }

}
