plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.maven.publish)
    alias(libs.plugins.tapmoc)
    alias(libs.plugins.spotless)
}

dependencies {
    implementation(libs.okhttp)
    implementation(libs.rxjava)
    implementation(libs.rxandroid)
    implementation(libs.jsoup)
    implementation(libs.injekt)
}

android {
    namespace = "eu.kanade.tachiyomi.extensions"
    compileSdk = 36

    defaultConfig {
        minSdk = 21
    }
}

spotless {
    val ktlintVersion = libs.ktlint.cli.get().version
    kotlin {
        target("src/**/*.kt")
        ktlint(ktlintVersion)
    }

    kotlinGradle {
        target("*.gradle.kts")
        ktlint(ktlintVersion)
    }
}

tapmoc {
    java(17)
    kotlin("2.3.10")
}

mavenPublishing {
    coordinates("com.github.keiyoushi", "extensions-lib", "1.4.5")

    pom {
        name.set("extensions-lib")
        description.set("Stubs used for extensions in Tachiyomi and Mihon 0.x.")
        url.set("https://github.com/keiyoushi/extensions-lib")

        licenses {
            license {
                name.set("Apache License 2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0")
                distribution.set("repo")
            }
        }

        organization {
            name.set("Keiyoushi")
            url.set("https://github.com/keiyoushi")
        }

        scm {
            connection.set("scm:git:git://github.com/keiyoushi/extensions-lib.git")
            url.set("https://github.com/keiyoushi/extensions-lib")
        }
    }
}
