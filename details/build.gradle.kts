plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.hilt.android)
    // id("com.google.dagger.hilt.android")
    alias(libs.plugins.google.devtools.ksp)
}

android {
    namespace = "com.kadico.details"
    compileSdk = 36

    defaultConfig {
        minSdk = 26
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
    //    compileOptions {
    //        sourceCompatibility = JavaVersion.VERSION_11
    //        targetCompatibility = JavaVersion.VERSION_11
    //    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    hilt {
        enableAggregatingTask = false
    }
    ksp {
        arg("room.schemaLocation", "$projectDir/schemas")
    }
    testOptions {
        targetSdk = 36
    }
}


dependencies {


    // --- Базовые библиотеки Android и Kotlin ---
    implementation(libs.androidx.core.ktx)                                                              // Расширения Kotlin для Android Core
    implementation(libs.androidx.lifecycle.runtime.ktx)                                                 // Работа с жизненным циклом (Lifecycle)
    implementation(libs.kotlinx.serialization.json)                                                     // Сериализация JSON


    // --- Jetpack Compose (Интерфейс) ---
    implementation(platform(libs.androidx.compose.bom))                                                 // Управление версиями Compose через BOM
    implementation(libs.androidx.activity.compose)                                                      // Интеграция Activity с Compose
    implementation(libs.androidx.ui)                                                                    // Основные компоненты UI Compose
    implementation(libs.androidx.ui.graphics)                                                           // Инструменты отрисовки и графики
    implementation(libs.androidx.ui.tooling.preview)                                                    // Поддержка Preview в Android Studio
    implementation(libs.androidx.material3)                                                             // Компоненты Material Design 3
    implementation(libs.androidx.lifecycle.viewmodel.compose)                                           // Интеграция ViewModel с Compose


    // --- Загрузка изображений (Coil) ---
    implementation(libs.coil.compose)                                                                   // Поддержка Coil для Compose
    implementation(libs.coil.network.okhttp)                                                            // Сетевой движок OkHttp для Coil


    // --- Сеть (Retrofit & OkHttp) ---
    implementation(libs.okhttp)                                                                         // HTTP-клиент
    implementation(libs.retrofit)                                                                       // Библиотека для работы с REST API
    implementation(libs.retrofit.converter.kotlinx.serialization)                                       // Конвертер JSON для Retrofit


    // --- Внедрение зависимостей (Dagger Hilt) ---
    implementation(libs.hilt.android)                                                                   // Основная библиотека Hilt
    implementation(libs.hilt.navigation.compose)                                                        // Интеграция Hilt с навигацией Compose
    ksp(libs.hilt.compiler)                                                                            // Кодогенератор Hilt (требует плагин kapt)


    // --- Локальная база данных (Room) ---
    implementation(libs.room.runtime)                                                                   // Основной рантайм Room
    implementation(libs.room.ktx)                                                                       // Поддержка Coroutines для Room
    ksp(libs.room.compiler)                                                                             // Кодогенератор Room (требует плагин kapt)



    // --- Тестирование (Unit & UI) ---
    testImplementation(libs.junit)                                                                       // Юнит-тесты
    androidTestImplementation(libs.androidx.junit)                                                       // Android-тесты
    androidTestImplementation(libs.androidx.espresso.core)                                               // Тестирование взаимодействий (Espresso)
    androidTestImplementation(platform(libs.androidx.compose.bom))                                       // BOM для тестов
    androidTestImplementation(libs.androidx.ui.test.junit4)                                              // Тестирование Compose


    // --- Отладка (Debug) ---
    debugImplementation(libs.androidx.ui.tooling)                                                        // Инструменты инспекции UI
    debugImplementation(libs.androidx.ui.test.manifest)                                                  // Манифест для тестов Compose


}