// TODO can we use version as a variable?
plugins {
//    id("io.micronaut.application") version "2.0.4"
    id("org.jetbrains.kotlin.jvm") version "1.5.30"
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
    compileOnly("io.micronaut.sql:micronaut-hibernate-jpa:4.0.0")
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
