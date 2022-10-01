plugins {
    id("java-platform")
}

val androidxCoreKtx = "1.7.0"
val androidxAppCompat = "1.5.1"
val googleMaterial = "1.6.1"
val constraintLayout = "2.1.4"

val retrofit = "2.4.0"
val gson = "2.4.0"

val rxAndroid = "2.1.0"
val rxJava = "2.2.2"
val rxAdapterRetrofit = "2.9.0"

val dagger = "2.44"

dependencies {
    constraints {
        api("${Libs.ANDROIDX_CORE_KTX}:$androidxCoreKtx")
        api("${Libs.ANDROIDX_APPCOMPAT}:$androidxAppCompat")
        api("${Libs.GOOGLE_MATERIAL}:$googleMaterial")
        api("${Libs.CONSTRAINTLAYOUT}:$constraintLayout")

        api("${Libs.RETROFIT}:$retrofit")
        api("${Libs.GSON}:$gson")

        api("${Libs.RXANDROID}:$rxAndroid")
        api("${Libs.RXJAVA}:$rxJava")
        api("${Libs.RX_ADAPTER_RETROFIT}:$rxAdapterRetrofit")

        api("${Libs.DAGGER_2}:$dagger")
        api("${Libs.DAGGER_ANDROID}:$dagger")
        api("${Libs.DAGGER_COMPILER}:$dagger")
        api("${Libs.DAGGER_ANDROID_PROCESSOR}:$dagger")
    }
}