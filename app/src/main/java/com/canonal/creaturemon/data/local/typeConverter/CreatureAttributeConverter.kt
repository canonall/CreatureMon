package com.canonal.creaturemon.data.local.typeConverter

import androidx.room.TypeConverter
import com.canonal.creaturemon.model.CreatureAttribute
import java.util.*

class CreatureAttributeConverter {

    @TypeConverter
    fun creatureAttributeToString(creatureAttribute: CreatureAttribute?): String? {
        if (creatureAttribute != null) {
            return String.format(
                Locale.US,
                "%d,%d,%d",
                creatureAttribute.intelligence,
                creatureAttribute.strength,
                creatureAttribute.endurance
            )

        }
        return null
    }


    @TypeConverter
    fun stringToCreatureAttribute(value: String?): CreatureAttribute? {
        if (value != null) {
            val pieces = value.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            return CreatureAttribute(
                Integer.parseInt(pieces[0]),
                Integer.parseInt(pieces[1]),
                Integer.parseInt(pieces[2])
            )
        }
        return null

    }
}