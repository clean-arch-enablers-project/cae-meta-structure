package com.cae.meta_structure.core.entities.implementations.transformers;

import com.cae.meta_structure.core.entities.TextCaseTransformer;

public class KebabTextTransformer implements TextCaseTransformer {

    @Override
    public String transform(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        text = text.replaceAll("[\\s_]", "-");
        return text.replaceAll("([a-z])([A-Z])", "$1-$2")
                .replaceAll("([A-Z])([A-Z][a-z])", "$1-$2")
                .toLowerCase();
    }
}
