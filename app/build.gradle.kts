plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.diaz.rodrigo.laboratoriocalificadosustitutorio"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.diaz.rodrigo.laboratoriocalificadosustitutorio"
        minSdk = 24
        targetSdk = 35
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

    // Habilitamos ViewBinding
    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Dependencias del proyecto
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // RecyclerView
    implementation("androidx.recyclerview:recyclerview:1.3.1")

    // Material Design
    implementation("com.google.android.material:material:1.9.0")

    // Logging Interceptor para Retrofit (opcional para depuración)
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

    // Dependencia ajustada de core-ktx para compatibilidad con compileSdk 34
    implementation("androidx.core:core-ktx:1.12.0") // Cambiado a 1.12.0 para asegurar compatibilidad

    // Compatibilidad adicional
    implementation("androidx.appcompat:appcompat:1.6.1")

    // Pruebas
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}