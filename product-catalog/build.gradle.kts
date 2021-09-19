plugins {
    id("groovy")
    id("org.jetbrains.kotlin.jvm") version "1.5.21"
    id("org.jetbrains.kotlin.kapt") version "1.5.21"
    id("com.github.johnrengelman.shadow") version "7.0.0"
    id("io.micronaut.application") version "2.0.4"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.5.21"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.5.21"
    id("com.google.cloud.tools.jib") version "2.8.0"
}

version = "0.0.1"
group = "me.rasztabiga.fridgy.productcatalog"

val kotlinVersion = "1.5.21"
val micronautVersion = "3.0.1"

repositories {
    mavenCentral()
}

micronaut {
    runtime("netty")
    testRuntime("spock2")
    processing {
        incremental(true)
        annotations("me.rasztabiga.fridgy.productcatalog.*")
    }
}

dependencies {
    annotationProcessor("io.micronaut.data:micronaut-data-processor:${micronautVersion}")
    kapt("io.micronaut:micronaut-http-validation:${micronautVersion}")
    kapt("io.micronaut.data:micronaut-data-processor:${micronautVersion}")
    kapt("io.micronaut.openapi:micronaut-openapi:3.0.2")
    kapt("io.micronaut.security:micronaut-security-annotations:${micronautVersion}")
    implementation("io.micronaut:micronaut-http-client:${micronautVersion}")
    implementation("io.micronaut:micronaut-management:${micronautVersion}")
    implementation("io.micronaut.micrometer:micronaut-micrometer-core:4.0.0")
    implementation("io.micronaut.micrometer:micronaut-micrometer-registry-prometheus:4.0.0")
    implementation("io.micronaut:micronaut-runtime:${micronautVersion}")
    implementation("io.micronaut.cache:micronaut-cache-core:3.0.0")
    implementation("io.micronaut.cache:micronaut-cache-caffeine:3.0.0")
    implementation("io.micronaut.data:micronaut-data-hibernate-jpa:${micronautVersion}")
    implementation("io.micronaut.discovery:micronaut-discovery-client:3.0.0")
    implementation("io.micronaut.flyway:micronaut-flyway:4.1.0")
    implementation("io.micronaut.graphql:micronaut-graphql:3.0.0")
    implementation("io.micronaut.kafka:micronaut-kafka:4.0.0")
    implementation("io.micronaut.kotlin:micronaut-kotlin-extension-functions:3.0.0")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime:3.0.0")
    implementation("io.micronaut.kubernetes:micronaut-kubernetes-discovery-client:3.0.0")
    implementation("io.micronaut.security:micronaut-security:${micronautVersion}")
    implementation("io.micronaut.security:micronaut-security-jwt:${micronautVersion}")
    implementation("io.micronaut.sql:micronaut-hibernate-jpa:4.0.0")
    implementation("io.micronaut.data:micronaut-data-jdbc:${micronautVersion}")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari:4.0.0")
    implementation("io.swagger.core.v3:swagger-annotations:2.1.10")
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    runtimeOnly("ch.qos.logback:logback-classic:1.2.6")
    runtimeOnly("org.postgresql:postgresql:42.2.23.jre7")
    testImplementation("org.testcontainers:spock:1.16.0")
    testImplementation("org.testcontainers:postgresql:1.16.0")
    testImplementation("org.testcontainers:testcontainers:1.16.0")
    compileOnly("org.graalvm.nativeimage:svm:21.2.0")
    implementation("io.micronaut:micronaut-validation:${micronautVersion}")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.5")
    testImplementation("org.hamcrest:hamcrest:2.2")
    testImplementation("org.mockito:mockito-core:3.12.4")

}

application {
    mainClass.set("me.rasztabiga.fridgy.productcatalog.ProductCatalogServiceKt")
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

    dockerBuild {
        images.set(listOf(System.getenv("DOCKER_IMAGE") ?: "${project.name}:${project.version}"))
    }

    dockerBuildNative {
        images.set(listOf(System.getenv("DOCKER_IMAGE") ?: "${project.name}:${project.version}"))
    }

    test {
        filter {
            // exclude integration tests, TODO add another task for running only integration tests
            excludeTestsMatching("*IT")
        }
    }
}
