package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.suc.core;

import com.cae.meta_structure.core.entities.enums.Layers;
import com.cae.meta_structure.core.entities.enums.UseCaseTypes;
import com.cae.meta_structure.core.entities.providers.CaeSettingsReader;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.BasicUseCaseStructure;

public class SucAtCoreLayer extends BasicUseCaseStructure {

    public SucAtCoreLayer(String useCaseName, Boolean kotlin) {
        super(
                CaeSettingsReader.SINGLETON.getCoreUseCasesPath(),
                useCaseName,
                Layers.CORE,
                UseCaseTypes.SUC,
                kotlin
        );
    }
}
