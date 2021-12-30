package com.canonal.creaturemon.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "creature_table")
data class Creature(
    @PrimaryKey
    val name: String = "No name",
    val creatureAttribute: CreatureAttribute = CreatureAttribute(0,0,0),
    val hitPoint: Int = 0,
    val icon: String = "https://miro.medium.com/max/400/1*UL9RWkTUtJlyHW7kGm20hQ.png",
): Parcelable