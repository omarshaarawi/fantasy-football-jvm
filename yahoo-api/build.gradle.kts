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

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
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
    implementation(libs.bundles.hoplite)
    implementation(libs.bundles.jackson)
    implementation(libs.okhttp.logging)
    testImplementation(libs.bundles.kotest)
    detektPlugins(libs.detektFormatting)
}

detekt {
    config = files("../gradle/detekt.yml")
    buildUponDefaultConfig = true
    parallel = true
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/omarshaarawi/fantasy-football-jvm")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GIT_USERNAME")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}
