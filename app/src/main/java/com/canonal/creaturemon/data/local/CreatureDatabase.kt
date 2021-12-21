package com.canonal.creaturemon.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.canonal.creaturemon.data.local.dao.CreatureDao
import com.canonal.creaturemon.data.local.typeConverter.CreatureAttributeConverter
import com.canonal.creaturemon.model.Creature
import com.canonal.creaturemon.model.CreatureAttributeGenerator
import com.canonal.creaturemon.model.CreatureGenerator
import com.canonal.creaturemon.model.attributeType.EnduranceType
import com.canonal.creaturemon.model.attributeType.IntelligenceType
import com.canonal.creaturemon.model.attributeType.StrengthType
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


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
                    "creaturemon_database"
                )
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            generateInitialData()
                        }
                    })
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private fun generateInitialData() {
            GlobalScope.launch {
                INSTANCE?.let {
                    it.creatureDao().insertCreature(
                        CreatureGenerator.generateCreature(
                            CreatureAttributeGenerator.generateCreatureAttribute(
                                IntelligenceType.SMART,
                                StrengthType.REGULAR,
                                EnduranceType.WEAK
                            ), "Chris Paul",
                            0
                        )
                    )

                    it.creatureDao().insertCreature(
                        CreatureGenerator.generateCreature(
                            CreatureAttributeGenerator.generateCreatureAttribute(
                                IntelligenceType.SMART,
                                StrengthType.STRONG,
                                EnduranceType.TOUGH
                            ), "LeBron James",
                            1
                        )
                    )

                    it.creatureDao().insertCreature(
                        CreatureGenerator.generateCreature(
                            CreatureAttributeGenerator.generateCreatureAttribute(
                                IntelligenceType.REGULAR,
                                StrengthType.WEAK,
                                EnduranceType.REGULAR
                            ), "Kevin Durant",
                            2
                        )
                    )
                }
            }
        }
    }

}