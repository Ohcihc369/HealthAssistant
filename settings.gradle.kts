
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        // ...

        // Add the dependency for the Google services Gradle plugin
        id("com.google.gms.google-services") version "4.4.2" apply false

    }
}


dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Health Assistant"
include(":app")
 