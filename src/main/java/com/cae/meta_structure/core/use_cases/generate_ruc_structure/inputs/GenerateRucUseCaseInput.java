package com.cae.meta_structure.core.use_cases.generate_ruc_structure.inputs;

import com.cae.use_cases.io.UseCaseInput;
import com.cae.use_cases.io.annotations.NotNullInputField;
import lombok.Builder;
import lombok.Getter;

/**
 * This class maps the input fields for your use case. Before executing the use case,
 * the internal method UseCaseInput::validateProperties will be called to ensure each
 * field complies with its requirements.
 */
@Builder
@Getter
public class GenerateRucUseCaseInput extends UseCaseInput {

    @NotNullInputField
    private final String name;

    @NotNullInputField
    private final Boolean kotlin;

}
