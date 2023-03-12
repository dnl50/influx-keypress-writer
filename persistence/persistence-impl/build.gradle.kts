plugins {
    `java-convention`
}

dependencies {
    api(project(":persistence:persistence-api"))

    implementation("io.smallrye.config:smallrye-config-core")
    implementation("jakarta.enterprise:jakarta.enterprise.cdi-api")
    implementation("jakarta.validation:jakarta.validation-api")

    // the coroutines-core lib is used by transitive dependencies of the InfluxDB client
    implementation(libs.influxClient)
    runtimeOnly("org.jetbrains.kotlinx:kotlinx-coroutines-core")
}