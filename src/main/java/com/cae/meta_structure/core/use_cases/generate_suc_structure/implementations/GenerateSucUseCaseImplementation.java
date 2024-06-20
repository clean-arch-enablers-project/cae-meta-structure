package com.cae.meta_structure.core.use_cases.generate_suc_structure.implementations;

import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.suc.adapters.SucAtAdaptersLayer;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.suc.assemblers.SucAtAssemblersLayer;
import com.cae.meta_structure.core.entities.implementations.structures.use_case_structures.specifics.suc.core.SucAtCoreLayer;
import com.cae.meta_structure.core.use_cases.generate_suc_structure.GenerateSucUseCase;
import com.cae.meta_structure.core.use_cases.generate_suc_structure.inputs.GenerateSucUseCaseInput;
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
public class GenerateSucUseCaseImplementation extends GenerateSucUseCase {

    @Override
    protected void applyInternalLogic(GenerateSucUseCaseInput input, UseCaseExecutionCorrelation correlation) {
        var fucStructure = List.of(
            new SucAtCoreLayer(input.getName()),
            new SucAtAdaptersLayer(input.getName()),
            new SucAtAssemblersLayer(input.getName())
        );
        fucStructure.forEach(FolderMetaStructure::create);
    }
}
