plugins {
    application
    java
    id("com.github.ben-manes.versions") version "0.53.0"
    checkstyle
    id("org.sonarqube") version "7.0.1.6134"
    jacoco
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("info.picocli:picocli:4.7.7")
    implementation("com.fasterxml.jackson.core:jackson-core:2.20.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.20.1")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.20.1")
    implementation("org.apache.commons:commons-collections4:4.5.0")
}

tasks.test {
    useJUnitPlatform()
}
application {
    mainClass = "hexlet.code.App"
}
sonar {
    properties {
        property("sonar.projectKey", "aseccxz_java-project-71")
        property("sonar.organization", "aseccxz")
    }
}
