package com.example.weatherappcompose.domain.weather

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.weatherappcompose.R

sealed class WeatherType(
    @StringRes val stringRes: Int,
    @DrawableRes val iconRes: Int
) {
    object ClearSky : WeatherType(
        stringRes = R.string.clear_sky,
        iconRes = R.drawable.ic_sunny
    )
    object MainlyClear : WeatherType(
        stringRes = R.string.mainly_clear,
        iconRes = R.drawable.ic_cloudy
    )
    object PartlyCloudy : WeatherType(
        stringRes = R.string.partly_cloudy,
        iconRes = R.drawable.ic_cloudy
    )
    object Overcast : WeatherType(
        stringRes = R.string.overcast,
        iconRes = R.drawable.ic_cloudy
    )
    object Foggy : WeatherType(
        stringRes = R.string.foggy,
        iconRes = R.drawable.ic_very_cloudy
    )
    object DepositingRimeFog : WeatherType(
        stringRes = R.string.depositing_rime_fog,
        iconRes = R.drawable.ic_very_cloudy
    )
    object LightDrizzle : WeatherType(
        stringRes = R.string.light_drizzle,
        iconRes = R.drawable.ic_rainshower
    )
    object ModerateDrizzle : WeatherType(
        stringRes = R.string.moderate_drizzle,
        iconRes = R.drawable.ic_rainshower
    )
    object DenseDrizzle : WeatherType(
        stringRes = R.string.dense_drizzle,
        iconRes = R.drawable.ic_rainshower
    )
    object LightFreezingDrizzle : WeatherType(
        stringRes = R.string.slight_freezing_drizzle,
        iconRes = R.drawable.ic_snowyrainy
    )
    object DenseFreezingDrizzle : WeatherType(
        stringRes = R.string.dense_freezing_drizzle,
        iconRes = R.drawable.ic_snowyrainy
    )
    object SlightRain : WeatherType(
        stringRes = R.string.slight_rain,
        iconRes = R.drawable.ic_rainy
    )
    object ModerateRain : WeatherType(
        stringRes = R.string.rainy,
        iconRes = R.drawable.ic_rainy
    )
    object HeavyRain : WeatherType(
        stringRes = R.string.heavy_rain,
        iconRes = R.drawable.ic_rainy
    )
    object HeavyFreezingRain: WeatherType(
        stringRes = R.string.heavy_freezing_rain,
        iconRes = R.drawable.ic_snowyrainy
    )
    object SlightSnowFall: WeatherType(
        stringRes = R.string.slight_snow_fall,
        iconRes = R.drawable.ic_snowy
    )
    object ModerateSnowFall: WeatherType(
        stringRes = R.string.moderate_snow_fall,
        iconRes = R.drawable.ic_heavysnow
    )
    object HeavySnowFall: WeatherType(
        stringRes = R.string.heavy_snow_fall,
        iconRes = R.drawable.ic_heavysnow
    )
    object SnowGrains: WeatherType(
        stringRes = R.string.snow_grains,
        iconRes = R.drawable.ic_heavysnow
    )
    object SlightRainShowers: WeatherType(
        stringRes = R.string.slight_rain_showers,
        iconRes = R.drawable.ic_rainshower
    )
    object ModerateRainShowers: WeatherType(
        stringRes =  R.string.moderate_rain_showers,
        iconRes = R.drawable.ic_rainshower
    )
    object ViolentRainShowers: WeatherType(
        stringRes =  R.string.violent_rain_showers,
        iconRes = R.drawable.ic_rainshower
    )
    object SlightSnowShowers: WeatherType(
        stringRes = R.string.light_snow_showers,
        iconRes = R.drawable.ic_snowy
    )
    object HeavySnowShowers: WeatherType(
        stringRes = R.string.heavy_snow_showers,
        iconRes = R.drawable.ic_snowy
    )
    object ModerateThunderstorm: WeatherType(
        stringRes = R.string.moderate_thunderstorm,
        iconRes = R.drawable.ic_thunder
    )
    object SlightHailThunderstorm: WeatherType(
        stringRes = R.string.thunderstorm_with_slight_hail,
        iconRes = R.drawable.ic_rainythunder
    )
    object HeavyHailThunderstorm: WeatherType(
        stringRes = R.string.thunderstorm_with_heavy_hail,
        iconRes = R.drawable.ic_rainythunder
    )

    companion object {
        fun fromWMO(code: Int): WeatherType {
            return when(code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingDrizzle
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> ClearSky
            }
        }
    }
}