package com.cae.meta_structure.core.use_cases.generate_ruc_structure.implementations;

import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.ruc.adapters.RucAtAdaptersLayer;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.ruc.assemblers.RucAtAssemblersLayer;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.ruc.core.RucAtCoreLayer;
import com.cae.meta_structure.core.use_cases.generate_ruc_structure.GenerateRucUseCase;
import com.cae.meta_structure.core.use_cases.generate_ruc_structure.inputs.GenerateRucUseCaseInput;
import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;

import java.util.List;

/**
 * This class implements the GenerateFucUseCase, containing all the internal logic for its operation.
 * <p>
 * Important: Avoid hardcoding any sensitive information in this code. The auto-documentation
 * process will analyze this section of the source code.
 * <p>
 * Note: It depends on your organization whether the GPT model is enabled for this process
 * and which version (cloud-provided or otherwise) is being used.
 */
public class GenerateRucUseCaseImplementation extends GenerateRucUseCase {

    @Override
    protected void applyInternalLogic(GenerateRucUseCaseInput input, UseCaseExecutionCorrelation correlation) {
        var fucStructure = List.of(
            new RucAtCoreLayer(input.getName(), input.getKotlin()),
            new RucAtAdaptersLayer(input.getName(), input.getKotlin()),
            new RucAtAssemblersLayer(input.getName(), input.getKotlin())
        );
        fucStructure.forEach(FolderMetaStructure::create);
    }
}
