package com.canonal.creaturemon.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "creature_table")
data class Creature(
    @PrimaryKey
    val name: String,
    val creatureAttribute: CreatureAttribute,
    val hitPoint: Int = 0,
    val icon: Int,
)