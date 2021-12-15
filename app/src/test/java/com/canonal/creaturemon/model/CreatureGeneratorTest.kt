package com.canonal.creaturemon.model

import junit.framework.Assert.assertEquals
import org.junit.Test

class CreatureGeneratorTest {
//    private lateinit var creatureGenerator: CreatureGenerator
//
//    @Before
//    fun setup(){
//        creatureGenerator = CreatureGenerator()
//       // CreatureGenerator.generateCreature()
//    }

    @Test
    fun testGeneratorHitPoints() {
        //according to these attributes expected hitpoint is 84
        val creatureAttribute = CreatureAttribute(
            intelligence = 7,
            strength = 3,
            endurance = 10
        )
        val creatureName = "Lebron James"
        val expectedCreature = Creature(creatureName, creatureAttribute, 84, 0)
        assertEquals(
            expectedCreature,
            CreatureGenerator.generateCreature(creatureAttribute, creatureName, 0)
        )

    }
}