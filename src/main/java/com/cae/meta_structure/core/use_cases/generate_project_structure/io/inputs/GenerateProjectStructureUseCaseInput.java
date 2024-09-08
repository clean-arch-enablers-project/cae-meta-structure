package com.cae.meta_structure.core.use_cases.generate_project_structure.io.inputs;

import com.cae.use_cases.io.UseCaseInput;
import com.cae.use_cases.io.annotations.NotBlankInputField;
import com.cae.use_cases.io.annotations.NotNullInputField;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GenerateProjectStructureUseCaseInput extends UseCaseInput {

    @NotNullInputField
    @NotBlankInputField
    private final String artifactId;

    @NotNullInputField
    @NotBlankInputField
    private final String groupId;

    @NotNullInputField
    @NotBlankInputField
    private final String caeFrameworkVersion;

    @NotNullInputField
    private final Boolean monolayer;

}
