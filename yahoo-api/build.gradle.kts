plugins {
    `java-library`

    id("idea")
    id("maven-publish")

    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.detekt)
}

group = "com.fantasy.football"
version = System.getenv("VERSION")

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.lombok)
    implementation(libs.retrofit)
    implementation(libs.retrofit.jackson)
    implementation(libs.retrofit.jaxb)
    implementation(libs.retrofit.kotlinx.serialization)
    implementation(libs.kotlin.logging)
    implementation(libs.kotlinx.serialization)
    implementation(libs.slf4j)
    implementation(libs.kotlin.logging)
    implementation(libs.detektFormatting)

    testImplementation(libs.bundles.kotest)
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/omarshaarawi/fantasy-football-jvm")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}
