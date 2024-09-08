package com.cae.meta_structure.core.use_cases.generate_cuc_structure.implementations;

import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.cuc.adapters.CucAtAdaptersLayer;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.cuc.assemblers.CucAtAssemblersLayer;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.cuc.core.CucAtCoreLayer;
import com.cae.meta_structure.core.use_cases.generate_cuc_structure.GenerateCucUseCase;
import com.cae.meta_structure.core.use_cases.generate_cuc_structure.inputs.GenerateCucUseCaseInput;
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
public class GenerateCucUseCaseImplementation extends GenerateCucUseCase {

    @Override
    protected void applyInternalLogic(GenerateCucUseCaseInput input, UseCaseExecutionCorrelation correlation) {
        var fucStructure = List.of(
            new CucAtCoreLayer(input.getName(), input.getKotlin()),
            new CucAtAdaptersLayer(input.getName(), input.getKotlin()),
            new CucAtAssemblersLayer(input.getName(), input.getKotlin())
        );
        fucStructure.forEach(FolderMetaStructure::create);
    }
}
