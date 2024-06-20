package com.cae.meta_structure.assemblers.use_cases.rotate_to_monolayer;

import com.cae.meta_structure.core.use_cases.rotate_to_monolayer.RotateToMonolayerUseCase;
import com.cae.meta_structure.core.use_cases.rotate_to_monolayer.implementations.RotateToMonolayerUseCaseImplementation;
import com.cae.use_cases.assemblers.UseCaseAssembler;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * This class creates a singleton object for the RotateToMonolayerUseCase class.
 * You can use this class to access the instance of this use case anywhere.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RotateToMonolayerUseCaseAssembler implements UseCaseAssembler<RotateToMonolayerUseCase>{

    public static final RotateToMonolayerUseCaseAssembler SINGLETON_ASSEMBLER = new RotateToMonolayerUseCaseAssembler();

    // You might want to preserve the V1 and as new versions of your implementation gets created, increment here with new versions (V1, V2, V3...)
    public static final RotateToMonolayerUseCase V1 = new RotateToMonolayerUseCaseImplementation();

    // You can select the main version of your use case implementation here. This way anywhere calling this method will automatically be upgraded with the new default version.
    @Override
    public RotateToMonolayerUseCase getDefaultAssembledInstance(){
        return V1;
    }
}