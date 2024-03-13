import com.rsanchezdev.buildsrc.Libs

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.rsanchezdev.randomusercode"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.rsanchezdev.randomusercode"
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
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":usecases"))

    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.AndroidX.recyclerView)
    implementation(Libs.AndroidX.material)
    implementation(Libs.AndroidX.constraintLayout)

    implementation(Libs.AndroidX.Activity.ktx)

    implementation(Libs.AndroidX.Lifecycle.viewmodelKtx)
    implementation(Libs.AndroidX.Lifecycle.runtimeKtx)

    implementation(Libs.AndroidX.Navigation.fragmentKtx)
    implementation(Libs.AndroidX.Navigation.uiKtx)

    implementation(Libs.Glide.glide)
    kapt(Libs.Glide.compiler)

    implementation(Libs.OkHttp3.loginInterceptor)
    implementation(Libs.Retrofit.retrofit)
    implementation(Libs.Retrofit.converterGson)

    implementation (Libs.Arrow.core)

    implementation (Libs.Hilt.android)
    kapt(Libs.Hilt.compiler)

    testImplementation (Libs.JUnit.junit)

    androidTestImplementation (Libs.Hilt.test)
    androidTestImplementation (Libs.Kotlin.Coroutines.test)
    androidTestImplementation (Libs.AndroidX.Test.runner)

    testImplementation (Libs.JUnit.junit)
    testImplementation (Libs.Mockito.kotlin)
    testImplementation (Libs.Mockito.inline)
    testImplementation (Libs.Kotlin.Coroutines.test)
    testImplementation (Libs.turbine)

    kaptAndroidTest(Libs.Hilt.compiler)
}