package com.cae.meta_structure.core.entities.providers;

import com.cae.meta_structure.core.entities.enums.TextCase;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class JavaWorldInfoProvider {

    public static final JavaWorldInfoProvider SINGLETON = new JavaWorldInfoProvider();

    private String groupId;
    private String artifactId;
    private String caeFrameworkVersion;

    public String getGroupIdInPackageFormat() {
        var parts = Stream.of(this.groupId.split("\\."))
                .map(part -> TextCase.SNAKE.getTransformer().transform(part))
                .collect(Collectors.toList());
        var whole = new StringBuilder();
        for (var index = 0; index < parts.size(); index++){
            if (index != 0)
                whole.append("/");
            whole.append(parts.get(index));
        }
        return whole.toString();
    }
}
