package com.cae.meta_structure.core.entities.enums;

import com.cae.meta_structure.core.entities.TextCaseTransformer;
import com.cae.meta_structure.core.entities.implementations.transformers.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum TextCase {

    SNAKE(new SnakeTextTransformer(), "SNAKE"),
    KEBAB(new KebabTextTransformer(), "KEBAB"),
    PASCAL(new PascalTextTransformer(), "PASCAL"),
    CAMEL(new CamelTextTransformer(), "CAMEL"),
    DEFAULT(new DefaultTextTransformer(), "DEFAULT");

    private final TextCaseTransformer transformer;
    private final String name;

}
