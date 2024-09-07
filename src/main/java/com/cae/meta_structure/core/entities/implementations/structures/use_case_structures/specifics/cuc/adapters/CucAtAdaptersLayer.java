package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.cuc.adapters;

import com.cae.meta_structure.core.entities.enums.Layers;
import com.cae.meta_structure.core.entities.enums.UseCaseTypes;
import com.cae.meta_structure.core.entities.providers.CaeSettingsReader;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.BasicUseCaseStructure;

public class CucAtAdaptersLayer  extends BasicUseCaseStructure {

    public CucAtAdaptersLayer(String useCaseName, Boolean kotlin) {
        super(
                CaeSettingsReader.SINGLETON.getAdaptersUseCasePath(),
                useCaseName,
                Layers.ADAPTERS,
                UseCaseTypes.IRRELEVANT,
                kotlin
        );
    }
}
