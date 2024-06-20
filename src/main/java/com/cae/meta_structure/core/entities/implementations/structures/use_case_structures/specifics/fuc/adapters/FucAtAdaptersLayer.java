package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.fuc.adapters;

import com.cae.meta_structure.core.entities.enums.Layers;
import com.cae.meta_structure.core.entities.enums.UseCaseTypes;
import com.cae.meta_structure.core.entities.providers.CaeSettingsReader;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.BasicUseCaseStructure;

public class FucAtAdaptersLayer extends BasicUseCaseStructure {

    public FucAtAdaptersLayer(String name) {
        super(
                CaeSettingsReader.SINGLETON.getAdaptersUseCasePath(),
                name,
                Layers.ADAPTERS,
                UseCaseTypes.IRRELEVANT
        );
    }

}
