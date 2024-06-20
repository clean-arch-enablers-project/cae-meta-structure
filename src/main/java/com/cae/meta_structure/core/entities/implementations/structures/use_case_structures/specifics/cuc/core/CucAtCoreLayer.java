package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.cuc.core;

import com.cae.meta_structure.core.entities.enums.Layers;
import com.cae.meta_structure.core.entities.enums.UseCaseTypes;
import com.cae.meta_structure.core.entities.providers.CaeSettingsReader;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.BasicUseCaseStructure;

public class CucAtCoreLayer extends BasicUseCaseStructure {

    public CucAtCoreLayer(String name) {
        super(
                CaeSettingsReader.SINGLETON.getCoreUseCasesPath(),
                name,
                Layers.CORE,
                UseCaseTypes.CUC
        );
    }
}
