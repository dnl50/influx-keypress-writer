plugins {
    `java-convention`
    alias(libs.plugins.quarkus)
}

dependencies {
    implementation("io.quarkus:quarkus-core")
    implementation("io.quarkus:quarkus-hibernate-validator")
    implementation(project(":keyboard-hook:keyboard-hook-api"))

    runtimeOnly(project(":keyboard-hook:keyboard-hook-impl"))
    runtimeOnly(project(":persistence:persistence-impl"))
    runtimeOnly(project(":listener"))
}