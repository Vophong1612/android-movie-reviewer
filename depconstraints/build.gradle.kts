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

val composeActivity = "1.5.1"
val composeMaterial = "1.2.1"
val composeAnimation = "1.2.1"
val composeUI = "1.2.1"
val composeViewmodel = "2.5.1"
val composeLivedata = "1.2.1"

val composePager = "0.26.0-beta"
val composePagerIndicator = "0.26.0-alpha"

val composeCoil = "2.2.1"

val composeSwipeRefresh = "0.26.0-alpha"

val composeRatingBar = "1.2.3"

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

        api("${Libs.COMPOSE_ACTIVITY}:$composeActivity")
        api("${Libs.COMPOSE_MATERIAL}:$composeMaterial")
        api("${Libs.COMPOSE_ANIMATION}:$composeAnimation")
        api("${Libs.COMPOSE_UI}:$composeUI")
        api("${Libs.COMPOSE_VIEWMODEL}:$composeViewmodel")
        api("${Libs.COMPOSE_LIVEDATA}:$composeLivedata")

        api("${Libs.COMPOSE_PAGER}:$composePager")
        api("${Libs.COMPOSE_PAGER_INDICATOR}:$composePagerIndicator")

        api("${Libs.COMPOSE_COIL}:$composeCoil")

        api("${Libs.COMPOSE_SWIPE_REFRESH}:$composeSwipeRefresh")

        api("${Libs.COMPOSE_RATING_BAR}:$composeRatingBar")
    }
}