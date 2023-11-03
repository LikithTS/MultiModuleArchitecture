plugins {
    id("com.android.library")
    id("kotlin-android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.likith.common"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        targetSdk = 34

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
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Compose
    implementation("androidx.compose.ui:ui:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.material:material:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.ui:ui-tooling:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.ui:ui-tooling-preview:${rootProject.extra["compose_version"]}" )
    implementation("androidx.activity:activity-compose:${rootProject.extra["compose_version"]}")
    implementation("androidx.compose.runtime:runtime-livedata:${rootProject.extra["compose_version"]}")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:${rootProject.extra["compose_version"]}")
    debugImplementation ("androidx.compose.ui:ui-tooling:${rootProject.extra["compose_version"]}")
    implementation( "androidx.constraintlayout:constraintlayout-compose:1.0.1")
    implementation( "androidx.compose.material:material-icons-extended:${rootProject.extra["compose_version"]}")
    implementation( "androidx.lifecycle:lifecycle-runtime-compose:2.6.2")
    implementation("androidx.compose.runtime:runtime:1.5.4")

    //Hilt
    implementation("com.google.dagger:hilt-android:${rootProject.extra["hilt_version"]}")
    kapt("com.google.dagger:hilt-android-compiler:${rootProject.extra["hilt_version"]}")
}