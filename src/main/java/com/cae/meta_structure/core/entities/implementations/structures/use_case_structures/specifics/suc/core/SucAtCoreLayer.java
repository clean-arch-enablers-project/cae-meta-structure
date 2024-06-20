package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.suc.core;

import com.cae.meta_structure.core.entities.enums.Layers;
import com.cae.meta_structure.core.entities.enums.UseCaseTypes;
import com.cae.meta_structure.core.entities.providers.CaeSettingsReader;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.BasicUseCaseStructure;

public class SucAtCoreLayer extends BasicUseCaseStructure {

    public SucAtCoreLayer(String name) {
        super(
                CaeSettingsReader.SINGLETON.getCoreUseCasesPath(),
                name,
                Layers.CORE,
                UseCaseTypes.SUC
        );
    }
}
