package com.cae.meta_structure.core.use_cases.generate_project_structure.implementations;

import com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.MonolayerJavaProject;
import com.cae.meta_structure.core.entities.implementations.structures.project_structures.multilayer_structure.MultilayerJavaProject;
import com.cae.meta_structure.core.use_cases.generate_project_structure.GenerateProjectStructureUseCase;
import com.cae.meta_structure.core.use_cases.generate_project_structure.io.inputs.GenerateProjectStructureUseCaseInput;
import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;

public class GenerateProjectStructureUseCaseImplementation extends GenerateProjectStructureUseCase {

    @Override
    protected void applyInternalLogic(GenerateProjectStructureUseCaseInput input, UseCaseExecutionCorrelation correlation) {
        var projectStructure = Boolean.TRUE.equals(input.getMonolayer())?
                new MonolayerJavaProject(input.getArtifactId(), input.getGroupId(), input.getCaeFrameworkVersion()) :
                new MultilayerJavaProject(input.getArtifactId(), input.getGroupId(), input.getCaeFrameworkVersion());
        projectStructure.create();
    }

}
