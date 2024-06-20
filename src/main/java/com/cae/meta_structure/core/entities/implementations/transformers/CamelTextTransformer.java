package com.cae.meta_structure.core.entities.implementations.transformers;

import com.cae.meta_structure.core.entities.TextCaseTransformer;

public class CamelTextTransformer implements TextCaseTransformer {

    @Override
    public String transform(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        text = text.replaceAll("[\\s_-]", " ");
        String[] parts = text.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (!part.isEmpty()) {
                if (i == 0) {
                    result.append(part.toLowerCase());
                } else {
                    result.append(Character.toUpperCase(part.charAt(0)))
                            .append(part.substring(1).toLowerCase());
                }
            }
        }
        return result.toString();
    }
}
