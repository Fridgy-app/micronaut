import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

// TODO can we use version as a variable?
plugins {
    id("groovy")
    id("org.jetbrains.kotlin.jvm") version "1.5.30"
    id("org.jetbrains.kotlin.kapt") version "1.5.30"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.5.30"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.5.30"
}

version = "0.0.1"
group = "me.rasztabiga.fridgy.common"

// TODO can I use gradle.properties?
val kotlinVersion = project.properties["kotlinVersion"]
val micronautVersion = project.properties["micronautVersion"]

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("io.micronaut:micronaut-inject:1.2.5")
    annotationProcessor("io.micronaut:micronaut-inject-java:1.2.5")
//    annotationProcessor("io.micronaut.data:micronaut-data-processor:${micronautVersion}")
//    kapt("io.micronaut.data:micronaut-data-processor:${micronautVersion}")
//    implementation("io.micronaut.data:micronaut-data-hibernate-jpa:${micronautVersion}")
    implementation("io.micronaut.sql:micronaut-hibernate-jpa:4.0.0")
}

//application {
//    mainClass.set("me.rasztabiga.fridgy.productcatalog.ProductCatalogService")
//}

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
