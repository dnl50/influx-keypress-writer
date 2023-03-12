plugins {
    `java-convention`
}

dependencies {
    api(project(":keyboard-hook:keyboard-hook-api"))

    implementation(libs.systemhook)
    implementation("jakarta.enterprise:jakarta.enterprise.cdi-api")
}