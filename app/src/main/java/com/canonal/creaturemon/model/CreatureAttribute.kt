package com.canonal.creaturemon.model

import android.os.Parcelable
import com.canonal.creaturemon.model.attributeType.EnduranceType
import com.canonal.creaturemon.model.attributeType.IntelligenceType
import com.canonal.creaturemon.model.attributeType.StrengthType
import kotlinx.parcelize.Parcelize

@Parcelize
data class CreatureAttribute(
    val intelligence: Int,
    val strength: Int,
    val endurance: Int
): Parcelable