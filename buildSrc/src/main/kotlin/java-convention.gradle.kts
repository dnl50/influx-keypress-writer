import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

group = "dev.mieser.listener"

val projectVersion: String? by project
projectVersion?.takeIf { it.isNotBlank() }?.let { version = it }

// Workaround for using Version Catalogs in Precompiled Script Plugins (see https://github.com/gradle/gradle/issues/15383)
val libs = the<LibrariesForLibs>()

dependencies {
    implementation(enforcedPlatform(libs.quarkus.bom)) {
        // The InfluxDB client requires newer versions of these libraries. GraalVM native compilation fails
        // since methods are used which were added in later versions of these libraries.
        exclude("com.squareup.okhttp3")
        exclude("com.squareup.okio")
    }
    implementation(libs.slf4j)

    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
}

tasks.compileJava.configure {
    inputs.file(rootProject.file("lombok.config"))
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}