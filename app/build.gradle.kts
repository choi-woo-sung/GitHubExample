

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.github.ben-manes.versions")
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

android {
    compileSdk = 31

    viewBinding{
        isEnabled = true
    }

    dataBinding{
        isEnabled = true
    }

    defaultConfig {
        applicationId = "kr.co.disfection.edcms"
        minSdk = 24
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = Test.ANDROID_JUNIT_RUNNER

    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {


    //AndroidX
    implementation(Dependencies.AndroidX.APP_COMPAT)
    implementation(Dependencies.AndroidX.CONSTRAINT_LAYOUT)
    implementation(Dependencies.AndroidX.MATERIAL)
    implementation(Dependencies.AndroidX.COROUTINE)
    implementation(Dependencies.AndroidX.LIFECYCLE)
    implementation(Dependencies.AndroidX.PAGINGCOMMON)
    implementation(Dependencies.AndroidX.PAGINGRUNTIME)
//    implementation(Dependencies.AndroidX.VIEWMODEL)
    implementation(Dependencies.AndroidX.ACTIVITY)


    //Kotlin
    implementation(KTX.CORE)

    //Second Lib
    implementation(Dependencies.Lib.QRCODE)
    implementation(Dependencies.Lib.IMAGEPICKER)



    //TEST
    testImplementation(Test.JUNIT)
    androidTestImplementation(AndroidTest.TEST_RUNNER)
    androidTestImplementation(AndroidTest.ESPRESSO_CORE)
    androidTestImplementation(AndroidTest.ESPRESSO_Web)

    //DEBUG
    implementation(Dependencies.Debug.STARTUP)
    implementation(Dependencies.Debug.TIMBER)

    //ANIMATION
    implementation(Dependencies.Animation.LOTTIE)

    //NETWORK
    implementation(Dependencies.Network.RETROFIT)
    implementation(Dependencies.Network.GSON)
    implementation(Dependencies.Network.SCALAR)
    implementation(Dependencies.Network.OKHTTP3)


    //PERMISSION
    implementation(Dependencies.Permission.NEEDS)
    implementation(Dependencies.Permission.TEDPERMISSION)


    //HILT
    implementation(Dependencies.Hilt.HILT)
    kapt(Dependencies.Hilt.HILTCOMPILER)
}