plugins {
    `java-convention`
    alias(libs.plugins.quarkus)
}

dependencies {
    implementation("io.quarkus:quarkus-core")
    implementation(project(":keyboard-hook:keyboard-hook-api"))

    runtimeOnly("io.quarkus:quarkus-hibernate-validator")
    runtimeOnly(project(":keyboard-hook:keyboard-hook-impl"))
    runtimeOnly(project(":persistence:persistence-impl"))
    runtimeOnly(project(":listener"))
}