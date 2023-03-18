plugins {
    `java-convention`
    alias(libs.plugins.quarkus)
}

dependencies {
    implementation("io.quarkus:quarkus-core")
    implementation(project(":hook:hook-api"))

    runtimeOnly("io.quarkus:quarkus-hibernate-validator")
    runtimeOnly(project(":hook:hook-impl"))
    runtimeOnly(project(":persistence:persistence-impl"))
    runtimeOnly(project(":listener"))
}