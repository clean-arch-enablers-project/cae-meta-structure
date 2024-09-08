package com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.fuc.assemblers;

import com.cae.meta_structure.core.entities.enums.Layers;
import com.cae.meta_structure.core.entities.enums.UseCaseTypes;
import com.cae.meta_structure.core.entities.providers.CaeSettingsReader;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.BasicUseCaseStructure;

public class FucAtAssemblersLayer extends BasicUseCaseStructure {

    public FucAtAssemblersLayer(String useCaseName, Boolean kotlin) {
        super(
                CaeSettingsReader.SINGLETON.getAssemblersUseCasePath(),
                useCaseName,
                Layers.ASSEMBLERS,
                UseCaseTypes.IRRELEVANT,
                kotlin
        );
    }

}
