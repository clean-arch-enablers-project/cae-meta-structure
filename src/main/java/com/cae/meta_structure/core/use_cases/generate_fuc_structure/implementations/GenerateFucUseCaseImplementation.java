package com.cae.meta_structure.core.use_cases.generate_fuc_structure.implementations;

import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.fuc.adapters.FucAtAdaptersLayer;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.fuc.assemblers.FucAtAssemblersLayer;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.fuc.core.FucAtCoreLayer;
import com.cae.meta_structure.core.use_cases.generate_fuc_structure.GenerateFucUseCase;
import com.cae.meta_structure.core.use_cases.generate_fuc_structure.io.inputs.GenerateFucUseCaseInput;
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
public class GenerateFucUseCaseImplementation extends GenerateFucUseCase {

    @Override
    protected void applyInternalLogic(GenerateFucUseCaseInput input, UseCaseExecutionCorrelation correlation) {
        var fucStructure = List.of(
            new FucAtCoreLayer(input.getName()),
            new FucAtAdaptersLayer(input.getName()),
            new FucAtAssemblersLayer(input.getName())
        );
        fucStructure.forEach(FolderMetaStructure::create);
    }
}
