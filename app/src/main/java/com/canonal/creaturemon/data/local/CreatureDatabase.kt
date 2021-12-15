package com.canonal.creaturemon.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.canonal.creaturemon.data.local.dao.CreatureDao
import com.canonal.creaturemon.data.local.typeConverter.CreatureAttributeConverter
import com.canonal.creaturemon.model.Creature


@Database(entities = [Creature::class], version = 1, exportSchema = false)
@TypeConverters(CreatureAttributeConverter::class)
abstract class CreatureDatabase : RoomDatabase() {

    abstract fun creatureDao(): CreatureDao

    companion object {

        @Volatile
        private var INSTANCE: CreatureDatabase? = null

        fun getDatabase(context: Context): CreatureDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CreatureDatabase::class.java,
                    "motto_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}