package com.example.plugin;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

public class DependencyCollectionTask extends DefaultTask {

    private Project project = getProject();


    @TaskAction
    void taskAction() {

        int size = project.getSubprojects().size();
        System.out.println("No of sub-projects are: " + size);

        project.getSubprojects().forEach(p -> System.out.println("SubProject: " + p));
    }
}