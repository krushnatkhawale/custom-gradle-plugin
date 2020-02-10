package com.example.plugin;

import org.assertj.core.api.Assertions;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class DependencyCollectionPluginTest {

    private static Project project = setupProject();

    @BeforeEach
    public void setUp() throws IOException {

    }

    @AfterEach
    public void afterAll() throws IOException {
        project.getTasks().getAt("clean").getActions();
    }

    @DisplayName("Basic test to test if correct task is run")
    @Test
    public void mainTest() throws IOException {
        Task myGradleTask = project.getTasks().getAt("myGradleTask");
        Assertions.assertThat(myGradleTask).isInstanceOf(DependencyCollectionTask.class);
    }

    private static Project setupProject() {
        final Project project = ProjectBuilder.builder().withName("qa").withProjectDir(new File("build")).build();
        project.setVersion("1.0.0");
        project.getPlugins().apply("java");
        project.getPlugins().apply("myGradleTask");
        return project;
    }
}