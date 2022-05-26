import Versions.NAV_VERSION

object Versions {
    const val NAV_VERSION = "2.4.0-alpha01"
}

object AndroidX {
    const val MATERIAL = "androidx.compose.material:material:1.0.0-rc02"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.1.2"
    const val APP_COMPAT = "androidx.appcompat:appcompat:1.3.1"
    const val LEGACY = "androidx.legacy:legacy-support-v4:1.0.0"
    const val LIFECYCLE_VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1"
    const val LIFECYCLE_LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"
    const val ACTIVITY = "androidx.activity:activity-ktx:1.3.1"
    const val FRAGMENT = "androidx.fragment:fragment-ktx:1.4.0-alpha03"
    const val DATASTORE = "androidx.datastore:datastore-preferences:1.0.0"
    const val ANNOTATION = "androidx.annotation:annotation:1.3.0"
}
object KTX {
    const val CORE = "androidx.core:core-ktx:1.6.0"
}
object Google {
    const val MATERIAL = "com.google.android.material:material:1.3.0"
    const val FLEXBOX = "com.google.android.flexbox:flexbox:3.0.0"
}
object Test {
    const val JUNIT = "junit:junit:4.+"
    const val ANDROID_JUNIT_RUNNER = "AndroidJUnitRunner"
}
object AndroidTest {
    const val EXT_JUNIT = "androidx.test.ext:junit:1.1.3"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:3.4.0"
}
object Retrofit{
    const val RETROFIT = "com.squareup.retrofit2:retrofit:2.9.0"
    const val CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:2.9.0"
}
object OkHttp {
    const val OKHTTP = "com.squareup.okhttp3:okhttp:4.9.1"
    const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:4.9.1"
}
object Glide {
    const val GLIDE = "com.github.bumptech.glide:glide:4.11.0"
}
object Firebase {
    const val FIREBASE_BOM = "com.google.firebase:firebase-bom:29.0.4"
}
object Room {
    const val ROOM = "androidx.room:room-ktx:2.3.0"
    const val ROOM_COMPILER = "androidx.room:room-compiler:2.3.0"
    const val ROOM_TESTING = "androidx.room:room-testing:2.3.0"
}
object NavComponent {
    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:$NAV_VERSION"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:$NAV_VERSION"
    const val NAVIGATION_RUNTIME = "androidx.navigation:navigation-runtime-ktx:$NAV_VERSION"
}
