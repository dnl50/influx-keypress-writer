plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    // Workaround for using Version Catalogs in Precompiled Script Plugins (see https://github.com/gradle/gradle/issues/15383)
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}