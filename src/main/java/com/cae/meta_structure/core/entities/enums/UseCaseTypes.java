package com.cae.meta_structure.core.entities.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum UseCaseTypes {

    FUC(true, true),
    CUC(true, false),
    SUC(false, true),
    RUC(false, false),
    IRRELEVANT(null, null);

    private final Boolean hasInput;
    private final Boolean hasOutput;


}
