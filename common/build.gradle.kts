plugins {
    id("groovy")
    id("org.jetbrains.kotlin.jvm") version "1.6.0"
    id("org.jetbrains.kotlin.kapt") version "1.6.0"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.0"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.6.0"
}

version = "0.0.1"
group = "me.rasztabiga.fridgy.common"

val kotlinVersion = project.properties["kotlinVersion"]
val micronautVersion = project.properties["micronautVersion"]

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("io.micronaut:micronaut-inject:3.2.1")
    annotationProcessor("io.micronaut:micronaut-inject-java:3.2.1")
    implementation("io.micronaut.sql:micronaut-hibernate-jpa:4.0.4")
}

java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}
