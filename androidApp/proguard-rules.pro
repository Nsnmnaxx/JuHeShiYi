# ProGuard rules for JuHeShiYi KMP

# Keep Kotlin serialization
-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.AnnotationsKt

# Keep Compose
-keep class androidx.compose.** { *; }

# Keep Ktor
-keep class io.ktor.** { *; }

# Keep multiplatform-settings
-keep class com.russhwolf.settings.** { *; }
