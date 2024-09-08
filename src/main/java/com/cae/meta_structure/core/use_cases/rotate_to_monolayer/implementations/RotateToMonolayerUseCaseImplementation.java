package com.cae.meta_structure.core.use_cases.rotate_to_monolayer.implementations;

import com.cae.mapped_exceptions.specifics.InternalMappedException;
import com.cae.meta_structure.core.entities.implementations.structures.project_structures.monolayer_structure.MonolayerJavaProject;
import com.cae.meta_structure.core.entities.implementations.transformers.KebabTextTransformer;
import com.cae.meta_structure.core.entities.implementations.transformers.SnakeTextTransformer;
import com.cae.meta_structure.core.entities.providers.CaeSettingsReader;
import com.cae.meta_structure.core.entities.providers.JavaWorldInfoProvider;
import com.cae.meta_structure.core.use_cases.rotate_to_monolayer.RotateToMonolayerUseCase;
import com.cae.use_cases.correlations.UseCaseExecutionCorrelation;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Stream;

/**
 * This class implements the RotateToMonolayerUseCase, containing all the internal logic for its operation.
 * Since it is a ConsumerUseCase, its purpose is to do something based on its input, not returning anything.
 * <p>
 * Important: Avoid hardcoding any sensitive information in this code. The auto-documentation
 * process will analyze this section of the source code if the GPT mode is enabled.
 */
public class RotateToMonolayerUseCaseImplementation extends RotateToMonolayerUseCase {

    private static final String CURRENT_PATH = System.getProperty("user.dir");
    private static final String CORE = "core";
    private static final String ADAPTERS = "adapters";
    private static final String ASSEMBLERS = "assemblers";
    private static final String POM = "pom.xml";
    private String mergedDependencies;

    @Override
    protected void applyInternalLogic(UseCaseExecutionCorrelation correlation) {
        if (Boolean.FALSE.equals(CaeSettingsReader.SINGLETON.isMonolayer())){
            var oldCorePath = this.getOldCorePath();
            var oldAdaptersPath = oldCorePath.replace(CORE, ADAPTERS);
            var oldAssemblersPath = oldCorePath.replace(CORE, ASSEMBLERS);
            this.extractOldPomDependencies();
            var newStructure = new MonolayerJavaProject(
                    CaeSettingsReader.SINGLETON.getDomain(),
                    CaeSettingsReader.SINGLETON.getOrganization(),
                    CaeSettingsReader.SINGLETON.getCaeVersion(),
                    CURRENT_PATH.replace(new KebabTextTransformer().transform(JavaWorldInfoProvider.SINGLETON.getArtifactId()), ""),
                    this.mergedDependencies
            );
            var prefix = this.getNewPathPrefix();
            var newCorePath = prefix  + CORE;
            var newAdaptersPath = prefix + ADAPTERS;
            var newAssemblersPath =  prefix + ASSEMBLERS;
            newStructure.create();
            this.moveContent(oldCorePath, newCorePath);
            this.moveContent(oldAdaptersPath, newAdaptersPath);
            this.moveContent(oldAssemblersPath, newAssemblersPath);
            this.deleteOldCore();
            this.deleteOldAdapters();
            this.deleteOldAssemblers();
        }
    }

    private String getOldCorePath() {
        return CURRENT_PATH.concat(File.separator)
                .concat(CORE)
                .concat(File.separator)
                .concat("src")
                .concat(File.separator)
                .concat("main")
                .concat(File.separator)
                .concat("java")
                .concat(File.separator)
                .concat(JavaWorldInfoProvider.SINGLETON.getGroupIdInPackageFormat())
                .concat(File.separator)
                .concat(new SnakeTextTransformer().transform(JavaWorldInfoProvider.SINGLETON.getArtifactId()))
                .concat(File.separator)
                .concat(CORE);
    }

    private void extractOldPomDependencies() {
        var corePomPath = CURRENT_PATH.concat(File.separator).concat(CORE).concat(File.separator).concat(POM);
        var adaptersPomPath = CURRENT_PATH.concat(File.separator).concat(ADAPTERS).concat(File.separator).concat(POM);
        var assemblersPomPath = CURRENT_PATH.concat(File.separator).concat(ASSEMBLERS).concat(File.separator).concat(POM);
        var coreDependencies = "\n\t\t<!--CORE-->".concat(this.getDependenciesFrom(corePomPath));
        var adaptersDependencies = "\n\t\t<!--ADAPTERS-->".concat(this.getDependenciesFrom(adaptersPomPath));
        var assemblersDependencies = "\n\t\t<!--ASSEMBLERS-->".concat(this.getDependenciesFrom(assemblersPomPath));
        var allDependencies = coreDependencies.concat(adaptersDependencies).concat(assemblersDependencies);
        this.mergedDependencies = Stream.of(allDependencies.replace(" ", "").split("<dependency>"))
                .filter(str -> !str.isBlank())
                .filter(str -> !str.contains(new KebabTextTransformer().transform(JavaWorldInfoProvider.SINGLETON.getArtifactId().concat("Core"))))
                .filter(str -> !str.contains(new KebabTextTransformer().transform(JavaWorldInfoProvider.SINGLETON.getArtifactId().concat("Adapters"))))
                .filter(str -> !str.contains(new KebabTextTransformer().transform(JavaWorldInfoProvider.SINGLETON.getArtifactId().concat("Assemblers"))))
                .map(str -> str.replace("\n<groupId>", "\t\t<dependency>\n<groupId>"))
                .map(str -> str.replace("</dependency>", "\t\t</dependency>"))
                .map(str -> str.replace("<groupId>", "\t\t\t<groupId>"))
                .map(str -> str.replace("<artifactId>", "\t\t\t<artifactId>"))
                .map(str -> str.replace("<version>", "\t\t\t<version>"))
                .map(str -> str.replace("<scope>", "\t\t\t<scope>"))
                .reduce("", String::concat);
    }


    private String getNewPathPrefix() {
        return CURRENT_PATH +
                File.separator +
                "src" +
                File.separator +
                "main" +
                File.separator +
                "java" +
                File.separator +
                JavaWorldInfoProvider.SINGLETON.getGroupIdInPackageFormat() +
                File.separator +
                new SnakeTextTransformer().transform(JavaWorldInfoProvider.SINGLETON.getArtifactId()) +
                File.separator;
    }

    private void moveContent(String oldPathCoreUseCases, String newPathCoreUseCases) {
        var sourceDir = Paths.get(oldPathCoreUseCases);
        var destinationDir = Paths.get(newPathCoreUseCases);
        try {
            Files.walkFileTree(sourceDir, new SimpleFileVisitor<>() {

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    var targetDir = destinationDir.resolve(sourceDir.relativize(dir));
                    if (!Files.exists(targetDir)) {
                        Files.createDirectory(targetDir);
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.copy(file, destinationDir.resolve(sourceDir.relativize(file)), StandardCopyOption.REPLACE_EXISTING);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new InternalMappedException("Something went wrong while trying to copy stuff to the new format", "More details: " + e);
        }
    }

    private String getDependenciesFrom(String pomPath) {
        try{
            var formalPath = Paths.get(pomPath);
            if (Files.exists(formalPath)){
                var pomFile = Files.readString(formalPath);
                return this.getDependenciesChunk(pomFile);
            }
            throw new InternalMappedException(
                    "It was not possible to find the pom file for the merging process",
                    "Path searched: " + pomPath
            );
        } catch (IOException ioException){
            throw new InternalMappedException(
                    "Something went wrong while trying to get the dependencies from '" + pomPath + "'",
                    "More on this issue: " + ioException
            );
        }
    }

    private String getDependenciesChunk(String pomFile) {
        return this.getBeforeDependenciesClosure(this.getAfterDependenciesOpening(this.clean(pomFile)));
    }

    private String clean(String pomFile) {
        return pomFile.replace(" ", "");
    }

    private String getAfterDependenciesOpening(String pomEssence){
        var chunks = List.of(pomEssence.split("<dependencies>"));
        if (chunks.size() != 2)
            throw new InternalMappedException(
                    "Something went wrong while trying to extract all dependencies from a pom file",
                    "When splitting the pom content by the <dependencies> tag, the expected is to have 2 chunks of content: before and after the opening tag. However the result was not 2 chunks"
            );
        return chunks.get(1);
    }

    private String getBeforeDependenciesClosure(String afterDependenciesOpening) {
        var chunksAfterOpening = List.of(afterDependenciesOpening.split("</dependencies>"));
        if (chunksAfterOpening.size() != 2)
            throw new InternalMappedException(
                    "Something went wrong while trying to extract all dependencies from a pom file",
                    "When splitting the pom content by the </dependencies> tag, the expected is to have 2 chunks of content: before and after the closure. However the result was not 2 chunks"
            );
        return chunksAfterOpening.get(0);
    }

    private void deleteOldCore() {
        this.deleteOldContent(CURRENT_PATH.concat(File.separator).concat(CORE));
    }

    private void deleteOldAdapters() {
        this.deleteOldContent(CURRENT_PATH.concat(File.separator).concat(ADAPTERS));
    }

    private void deleteOldAssemblers() {
        this.deleteOldContent(CURRENT_PATH.concat(File.separator).concat(ASSEMBLERS));

    }

    private void deleteOldContent(String path) {
        var directoryToDelete = Paths.get(path);
        try {
            Files.walkFileTree(directoryToDelete, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new InternalMappedException(
                    "Something went wrong while trying to delete stuff from the old format",
                    "More details: " + e
            );
        }
    }

}
