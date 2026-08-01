plugins {
    `java-library`
    kotlin("jvm") version "1.9.23"
    `maven-publish`
    signing
}

group = "com.granturismo"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.google.code.gson:gson:2.10.1")
    
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
    withSourcesJar()
    withJavadocJar()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "11"
    }
}


tasks.test {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = "com.granturismo"
            artifactId = "devicespecs-sdk"
            version = "1.0.0"

            pom {
                name.set("DeviceSpecs SDK")
                description.set("Official Java, Kotlin, and Android SDK for Device Specs API with Fluent Deep Filtering.")
                url.set("https://github.com/granturismo/DeviceSpecs")

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }

                developers {
                    developer {
                        id.set("granturismo")
                        name.set("GranTurismo")
                        email.set("support@granturismo.com")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/granturismo/DeviceSpecs.git")
                    developerConnection.set("scm:git:ssh://github.com/granturismo/DeviceSpecs.git")
                    url.set("https://github.com/granturismo/DeviceSpecs")
                }
            }
        }
    }

    repositories {
        maven {
            name = "sonatype"
            val releasesRepoUrl = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            val snapshotsRepoUrl = uri("https://s01.oss.sonatype.org/content/repositories/snapshots/")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
            credentials {
                username = project.findProperty("ossrhUsername")?.toString() ?: ""
                password = project.findProperty("ossrhPassword")?.toString() ?: ""
            }
        }
    }
}

signing {
    val signingKey = project.findProperty("signingKey")?.toString()
    val signingPassword = project.findProperty("signingPassword")?.toString()
    if (!signingKey.isNullOrEmpty()) {
        useInMemoryPgpKeys(signingKey, signingPassword)
        sign(publishing.publications["mavenJava"])
    }
}
