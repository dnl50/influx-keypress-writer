pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "influx-keypress-writer"

include("app")
include("domain")
include("hook:hook-api")
include("hook:hook-impl")
include("persistence:persistence-api")
include("persistence:persistence-impl")
include("listener")
