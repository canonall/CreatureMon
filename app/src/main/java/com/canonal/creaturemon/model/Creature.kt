package com.canonal.creaturemon.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "creature_table")
data class Creature(
    @PrimaryKey
    val name: String,
    val creatureAttribute: CreatureAttribute,
    val hitPoint: Int = 0,
    val icon: Int,
): Parcelable