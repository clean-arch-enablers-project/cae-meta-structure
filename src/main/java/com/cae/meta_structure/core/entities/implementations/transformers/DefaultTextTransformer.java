package com.cae.meta_structure.core.entities.implementations.transformers;

import com.cae.meta_structure.core.entities.TextCaseTransformer;

public class DefaultTextTransformer implements TextCaseTransformer {
    @Override
    public String transform(String text) {
        return text;
    }
}
