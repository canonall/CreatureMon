package com.canonal.creaturemon.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CreatureAttribute(
    val intelligence: Int = 0,
    val strength: Int = 0,
    val endurance: Int = 0
): Parcelable