plugins {
    id("com.android.library")
    kotlin("android")
    id("maven-publish")
}

object Maven {
    const val groupId = "id.panic_dev.android"
    const val artifactId = "ip"
    const val name = "image-picker"
    const val version = "1.1"
    const val desc = "Image Picker"
    const val siteUrl = "https://github.com/panicDev/ip"
    const val gitUrl = "https://github.com/panicDev/ip.git"
    const val licenseName = "The Apache Software License, Version 2.0"
    const val licenseUrl = "http://www.apache.org/licenses/LICENSE-2.0.txt"
    const val licenseDist = "repo"
}

group = Maven.groupId
version = Maven.version

android {
    namespace = "com.paniclabs.imagepicker"
    compileSdk = 33

    defaultConfig {
        minSdk = 16
        consumerProguardFiles("consumer-proguard-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    libraryVariants.all {
        generateBuildConfigProvider?.configure {
            enabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.7.20")
    implementation("androidx.appcompat:appcompat:1.6.1")

    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.material:material:1.8.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test:runner:1.5.2")

    compileOnly("com.github.bumptech.glide:glide:4.15.1")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.panicDev"
                artifactId = "ip"
                version = "1.1"
            }

        }
    }
}
