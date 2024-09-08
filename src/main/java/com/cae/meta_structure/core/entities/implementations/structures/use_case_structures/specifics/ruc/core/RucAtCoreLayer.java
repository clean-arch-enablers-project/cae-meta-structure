package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.ruc.core;

import com.cae.meta_structure.core.entities.enums.Layers;
import com.cae.meta_structure.core.entities.enums.UseCaseTypes;
import com.cae.meta_structure.core.entities.providers.CaeSettingsReader;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.BasicUseCaseStructure;

public class RucAtCoreLayer extends BasicUseCaseStructure {

    public RucAtCoreLayer(String useCaseName, Boolean kotlin) {
        super(
                CaeSettingsReader.SINGLETON.getCoreUseCasesPath(),
                useCaseName,
                Layers.CORE,
                UseCaseTypes.RUC,
                kotlin
        );
    }
}
