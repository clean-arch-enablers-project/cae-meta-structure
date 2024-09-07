package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.cuc.assemblers;

import com.cae.meta_structure.core.entities.enums.Layers;
import com.cae.meta_structure.core.entities.enums.UseCaseTypes;
import com.cae.meta_structure.core.entities.providers.CaeSettingsReader;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.BasicUseCaseStructure;

public class CucAtAssemblersLayer extends BasicUseCaseStructure {

    public CucAtAssemblersLayer(String name, Boolean kotlin) {
        super(
                CaeSettingsReader.SINGLETON.getAssemblersUseCasePath(),
                name,
                Layers.ASSEMBLERS,
                UseCaseTypes.IRRELEVANT,
                kotlin
        );
    }
}
