package com.cae.meta_structure.core.entities.implementations.transformers;

import com.cae.meta_structure.core.entities.TextCaseTransformer;

public class PascalTextTransformer implements TextCaseTransformer {

    @Override
    public String transform(String text) {
        if (text == null || text.isEmpty())
            return text;
        text = text.replaceAll("[\\s_-]", " ");
        var parts = text.split("\\s+");
        var result = new StringBuilder();
        for (String part : parts) {
            if (!part.isEmpty()) {
                result.append(Character.toUpperCase(part.charAt(0)))
                        .append(part.substring(1));
            }
        }
        return result.toString();
    }
}
