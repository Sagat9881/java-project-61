plugins {
    id("application")
}

group = "ru.apzakharov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

 application {
    mainClass.set("hexlet.code.Main")
}

dependencies { }

