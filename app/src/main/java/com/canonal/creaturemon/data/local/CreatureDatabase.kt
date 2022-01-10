package com.canonal.creaturemon.data.local

import android.content.Context
import androidx.room.*
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


@Database(
    entities = [Creature::class],
    version = 3,
    autoMigrations = [
        AutoMigration(from = 2, to = 3)
    ],
    exportSchema = true
)
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
                            ),
                            "Toxic Rick",
                            "https://rickandmortyapi.com/api/character/avatar/361.jpeg"
                        )
                    )

                    it.creatureDao().insertCreature(
                        CreatureGenerator.generateCreature(
                            CreatureAttributeGenerator.generateCreatureAttribute(
                                IntelligenceType.SMART,
                                StrengthType.STRONG,
                                EnduranceType.TOUGH
                            ),
                            "Super Turkey",
                            "https://rickandmortyapi.com/api/character/avatar/800.jpeg"
                        )
                    )

                    it.creatureDao().insertCreature(
                        CreatureGenerator.generateCreature(
                            CreatureAttributeGenerator.generateCreatureAttribute(
                                IntelligenceType.REGULAR,
                                StrengthType.WEAK,
                                EnduranceType.WEAK
                            ),
                            "Tiny Rick",
                            "https://rickandmortyapi.com/api/character/avatar/353.jpeg"
                        )
                    )
                }
            }
        }
    }

}