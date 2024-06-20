package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.Layers;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.enums.UseCaseTypes;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.components.AssemblerFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.components.IOFolderMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.components.ImplementationsFolderMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.cuc.core.components.CucContractFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.fuc.core.components.FucContractFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.ruc.core.components.RucContractFileMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.suc.core.components.SucContractFileMetaStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class BasicUseCaseStructure extends FolderMetaStructure {

    private final Layers layer;
    private final UseCaseTypes useCaseType;

    protected BasicUseCaseStructure(
            String location,
            String name,
            Layers layer,
            UseCaseTypes useCaseType) {
        super(
                location,
                name,
                TextCase.SNAKE
        );
        this.layer = layer;
        this.useCaseType = useCaseType;
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
                return List.of(new FucContractFileMetaStructure(this));
            case CUC:
                return List.of(new CucContractFileMetaStructure(this));
            case SUC:
                return List.of(new SucContractFileMetaStructure(this));
            case RUC:
                return List.of(new RucContractFileMetaStructure(this));
            default:
                return List.of();
        }
    }

    private List<FileMetaStructure> getFilesForAssemblersLayer(){
        return List.of(new AssemblerFileMetaStructure(this));
    }

    private List<FolderMetaStructure> getFoldersForCoreLayer(){
        var folders = new ArrayList<FolderMetaStructure>();
        folders.add(new ImplementationsFolderMetaStructure(this, this.useCaseType));
        if (this.useCaseType.getHasInput() || this.useCaseType.getHasOutput())
            folders.add(new IOFolderMetaStructure(this, this.useCaseType));
        return folders;
    }

}
