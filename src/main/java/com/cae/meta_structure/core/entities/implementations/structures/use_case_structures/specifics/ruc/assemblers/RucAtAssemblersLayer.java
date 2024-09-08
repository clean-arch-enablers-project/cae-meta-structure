package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.ruc.assemblers;

import com.cae.meta_structure.core.entities.enums.Layers;
import com.cae.meta_structure.core.entities.enums.UseCaseTypes;
import com.cae.meta_structure.core.entities.providers.CaeSettingsReader;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.BasicUseCaseStructure;

public class RucAtAssemblersLayer extends BasicUseCaseStructure {

    public RucAtAssemblersLayer(String name, Boolean kotlin) {
        super(
                CaeSettingsReader.SINGLETON.getAssemblersUseCasePath(),
                name,
                Layers.ASSEMBLERS,
                UseCaseTypes.IRRELEVANT,
                kotlin
        );
    }
}
