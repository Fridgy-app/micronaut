plugins {
    id("groovy")
    id("org.jetbrains.kotlin.jvm") version "1.6.0"
    id("org.jetbrains.kotlin.kapt") version "1.6.0"
    id("com.github.johnrengelman.shadow") version "7.1.0"
    id("io.micronaut.application") version "3.0.1"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.0"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.6.0"
    id("com.google.cloud.tools.jib") version "3.1.4"
}

version = "0.0.1"
group = "me.rasztabiga.fridgy.recipes"

val kotlinVersion = project.properties["kotlinVersion"]
val micronautVersion = project.properties["micronautVersion"]

repositories {
    mavenCentral()
}

micronaut {
    runtime("netty")
    testRuntime("kotest")
    processing {
        incremental(true)
        annotations("me.rasztabiga.fridgy.recipes.*")
    }
}

dependencies {
    kapt("io.micronaut:micronaut-http-validation")
    kapt("io.micronaut.data:micronaut-data-processor")
    kapt("io.micronaut.openapi:micronaut-openapi")
    kapt("io.micronaut.security:micronaut-security-annotations")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut.cache:micronaut-cache-ehcache")
    implementation("io.micronaut.data:micronaut-data-hibernate-jpa")
    implementation("io.micronaut.elasticsearch:micronaut-elasticsearch")
//    implementation("io.micronaut.flyway:micronaut-flyway")
    implementation("io.micronaut.kafka:micronaut-kafka")
    implementation("io.micronaut.kotlin:micronaut-kotlin-extension-functions")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
//    implementation("io.micronaut.kubernetes:micronaut-kubernetes-discovery-client")
    implementation("io.micronaut.problem:micronaut-problem-json")
    implementation("io.micronaut.security:micronaut-security")
    implementation("io.micronaut.security:micronaut-security-jwt")
//    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("io.swagger.core.v3:swagger-annotations")
    implementation("javax.annotation:javax.annotation-api")
    implementation("org.apache.logging.log4j:log4j-api:2.14.1")
    implementation("org.apache.logging.log4j:log4j-core:2.14.1")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("org.slf4j:log4j-over-slf4j:1.7.30")
    testImplementation("org.testcontainers:postgresql")
    testImplementation("org.testcontainers:testcontainers")
    compileOnly("org.graalvm.nativeimage:svm")

    implementation("io.micronaut:micronaut-validation")

    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation(project(":common"))
}

application {
    mainClass.set("me.rasztabiga.fridgy.recipes.RecipesService")
}

java {
    sourceCompatibility = JavaVersion.toVersion("17")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "17"
        }
    }

    dockerBuild {
        images.set(
            listOf(
                "${rootProject.name}/${project.name}:${project.version}",
                "${rootProject.name}/${project.name}:latest"
            )
        )
    }

    jib {
        to {
            image = "gcr.io/myapp/jib-image"
        }
    }

    dockerBuildNative {
        images.set(
            listOf(
                "${rootProject.name}/${project.name}:${project.version}",
                "${rootProject.name}/${project.name}:latest"
            )
        )
    }

    test {
        filter {
            // exclude integration tests, TODO add another task for running only integration tests
            excludeTestsMatching("*IT")
        }
    }
}
