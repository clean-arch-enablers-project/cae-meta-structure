package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.cuc.core;

import com.cae.meta_structure.core.entities.enums.Layers;
import com.cae.meta_structure.core.entities.enums.UseCaseTypes;
import com.cae.meta_structure.core.entities.providers.CaeSettingsReader;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.BasicUseCaseStructure;

public class CucAtCoreLayer extends BasicUseCaseStructure {

    public CucAtCoreLayer(String useCaseName, Boolean kotlin) {
        super(
                CaeSettingsReader.SINGLETON.getCoreUseCasesPath(),
                useCaseName,
                Layers.CORE,
                UseCaseTypes.CUC,
                kotlin
        );
    }
}
