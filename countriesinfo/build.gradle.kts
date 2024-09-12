import org.gradle.internal.impldep.com.amazonaws.util.IOUtils.release

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)

    `maven-publish`
}

android {
    namespace = "ak.countriesinfo"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

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


}

// Add the publishing configuration below
group = "com.github.Aqeldev" // Replace with your group ID
version = "1.0.0" // Replace with your version


// Publishing configuration (details needed)
publishing {
    publications {
        register("release", MavenPublication::class) {
            groupId = group.toString()
            artifactId = project.name
            version = version
            // Add configurations and artifacts here (explained later)
        }

    }
}