pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name="influx-keypress-writer"

include("app")
include("domain")
include("keyboard-hook:keyboard-hook-api")
include("keyboard-hook:keyboard-hook-impl")
include("persistence:persistence-api")
include("persistence:persistence-impl")
include("listener")
