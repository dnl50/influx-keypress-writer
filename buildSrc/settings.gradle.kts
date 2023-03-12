// Workaround for using Version Catalogs in Precompiled Script Plugins (see https://github.com/gradle/gradle/issues/15383)
dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}