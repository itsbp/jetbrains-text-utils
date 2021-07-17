package com.github.itsbp.jetbrainstextutils.services

import com.github.itsbp.jetbrainstextutils.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
