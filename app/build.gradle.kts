plugins {
    // id("com.github.ben-manes.versions") version "0.52.0"
    // id("com.diffplug.spotless") version "7.2.1"
    application
}

group = "ru.apzakharov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application { mainClass.set("ru.apzakharov.Main") }

tasks.test {
    useJUnitPlatform()
}