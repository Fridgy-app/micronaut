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
group = "me.rasztabiga.fridgy"

val kotlinVersion = project.properties["kotlinVersion"]
repositories {
    mavenCentral()
}

micronaut {
    runtime("netty")
    testRuntime("spock2")
    processing {
        incremental(true)
        annotations("me.rasztabiga.fridgy.*")
    }
}

dependencies {
    kapt("io.micronaut:micronaut-http-validation")
    kapt("io.micronaut.data:micronaut-data-processor")
    kapt("io.micronaut.openapi:micronaut-openapi")
    kapt("io.micronaut.security:micronaut-security-annotations")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-management")
    implementation("io.micronaut.micrometer:micronaut-micrometer-core")
    implementation("io.micronaut.micrometer:micronaut-micrometer-registry-prometheus")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut.cache:micronaut-cache-ehcache")
    implementation("io.micronaut.data:micronaut-data-hibernate-jpa")
    implementation("io.micronaut.discovery:micronaut-discovery-client")
    implementation("io.micronaut.flyway:micronaut-flyway")
    implementation("io.micronaut.graphql:micronaut-graphql")
    implementation("io.micronaut.kafka:micronaut-kafka")
    implementation("io.micronaut.kotlin:micronaut-kotlin-extension-functions")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("io.micronaut.kubernetes:micronaut-kubernetes-discovery-client")
    implementation("io.micronaut.security:micronaut-security")
    implementation("io.micronaut.security:micronaut-security-jwt")
    implementation("io.micronaut.sql:micronaut-hibernate-jpa")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("io.swagger.core.v3:swagger-annotations")
    implementation("javax.annotation:javax.annotation-api")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.testcontainers:spock")
    testImplementation("org.testcontainers:postgresql")
    testImplementation("org.testcontainers:testcontainers")
    compileOnly("org.graalvm.nativeimage:svm")

    implementation("io.micronaut:micronaut-validation")

    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

    testImplementation("org.hamcrest:hamcrest")

    testImplementation("org.mockito:mockito-core")

}


application {
    mainClass.set("me.rasztabiga.fridgy.ApplicationKt")
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
        images.set(listOf("${System.getenv("DOCKER_IMAGE") ?: project.name}:$project.version"))
    }

    dockerBuildNative {
        images.set(listOf("${System.getenv("DOCKER_IMAGE") ?: project.name}:$project.version"))
    }
}
