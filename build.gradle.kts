plugins {
    kotlin("jvm") version "1.5.0"
    id("io.gitlab.arturbosch.detekt") version "1.16.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    // kotest
    val kotestVersion = "4.5.0"
    listOf("runner-junit5", "assertions-core", "property").forEach {
        testImplementation("io.kotest:kotest-$it:$kotestVersion")
    }

    // detekt
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.16.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

detekt {
    toolVersion = "1.16.0"
//    config = files("config/detekt/detekt.yml")
    buildUponDefaultConfig = true
}
