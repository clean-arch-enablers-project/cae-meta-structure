package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.fuc.adapters;

import com.cae.meta_structure.core.entities.enums.Layers;
import com.cae.meta_structure.core.entities.enums.UseCaseTypes;
import com.cae.meta_structure.core.entities.providers.CaeSettingsReader;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.BasicUseCaseStructure;

public class FucAtAdaptersLayer extends BasicUseCaseStructure {

    public FucAtAdaptersLayer(String useCaseName, Boolean kotlin) {
        super(
                CaeSettingsReader.SINGLETON.getAdaptersUseCasePath(),
                useCaseName,
                Layers.ADAPTERS,
                UseCaseTypes.IRRELEVANT,
                kotlin
        );
    }

}
