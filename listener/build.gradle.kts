plugins {
    `java-convention`
}

dependencies {
    api(project(":persistence:persistence-api"))
    api(project(":hook:hook-api"))

    implementation("io.smallrye.config:smallrye-config-core")
    implementation("jakarta.enterprise:jakarta.enterprise.cdi-api")
    implementation("jakarta.validation:jakarta.validation-api")
}