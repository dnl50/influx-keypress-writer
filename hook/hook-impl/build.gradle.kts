plugins {
    `java-convention`
}

dependencies {
    api(project(":hook:hook-api"))

    implementation(libs.systemhook)
    implementation("jakarta.enterprise:jakarta.enterprise.cdi-api")
}