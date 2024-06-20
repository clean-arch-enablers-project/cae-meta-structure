package com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.components;

import com.cae.meta_structure.core.entities.FileMetaStructure;
import com.cae.meta_structure.core.entities.FolderMetaStructure;
import com.cae.meta_structure.core.entities.enums.TextCase;
import com.cae.meta_structure.core.entities.providers.JavaWorldInfoProvider;

public class MonolayerPomFileMetaStructure extends FileMetaStructure {

    private static final String DEPENDENCY_TAG_OPENING = "        <dependency>\n";
    private static final String DEPENDENCY_TAG_CLOSURE = "        </dependency>\n";
    private static final String TEST_SCOPE = "";

    public MonolayerPomFileMetaStructure(FolderMetaStructure parent, String dependencies) {
        super(
                parent,
                "pom",
                TextCase.CAMEL,
                "xml"
        );
        this.registerPlaceholder("groupId", JavaWorldInfoProvider.SINGLETON.getGroupId());
        this.registerPlaceholder("artifactId", JavaWorldInfoProvider.SINGLETON.getArtifactId());
        this.registerPlaceholder("dependencies", dependencies == null? this.getDefaultDependencies() : dependencies);
    }

    private String getDefaultDependencies() {
        return DEPENDENCY_TAG_OPENING +
                "            <groupId>com.clean-arch-enablers</groupId>\n" +
                "            <artifactId>cae-framework</artifactId>\n" +
                "            <version>" + JavaWorldInfoProvider.SINGLETON.getCaeFrameworkVersion() + "</version>\n" +
                DEPENDENCY_TAG_CLOSURE +
                DEPENDENCY_TAG_OPENING +
                "            <groupId>org.projectlombok</groupId>\n" +
                "            <artifactId>lombok</artifactId>\n" +
                "            <version>1.18.26</version>\n" +
                DEPENDENCY_TAG_CLOSURE +
                "         <dependency>\n" +
                "            <groupId>junit</groupId>\n" +
                "            <artifactId>junit</artifactId>\n" +
                "            <version>4.13.2</version>\n" +
                TEST_SCOPE +
                DEPENDENCY_TAG_CLOSURE +
                DEPENDENCY_TAG_OPENING +
                "            <groupId>org.mockito</groupId>\n" +
                "            <artifactId>mockito-core</artifactId>\n" +
                "            <version>4.8.0</version>\n" +
                TEST_SCOPE +
                DEPENDENCY_TAG_CLOSURE +
                DEPENDENCY_TAG_OPENING +
                "            <groupId>org.mockito</groupId>\n" +
                "            <artifactId>mockito-junit-jupiter</artifactId>\n" +
                "            <version>4.8.0</version>\n" +
                TEST_SCOPE +
                DEPENDENCY_TAG_CLOSURE +
                DEPENDENCY_TAG_OPENING +
                "            <groupId>ch.qos.logback</groupId>\n" +
                "            <artifactId>logback-classic</artifactId>\n" +
                "            <version>1.4.12</version>\n" +
                "        </dependency>";
    }
}
