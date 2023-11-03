plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.likith.multimodulearchitectureapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.likith.multimodulearchitectureapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(project(":navigation"))
    implementation(project(":common"))
    implementation(project(":broadband"))
    implementation(project(":history"))
    implementation(project(":profile"))

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //hilt
    implementation("com.google.dagger:hilt-android:${rootProject.extra["hilt_version"]}")
    kapt("com.google.dagger:hilt-android-compiler:${rootProject.extra["hilt_version"]}")
}