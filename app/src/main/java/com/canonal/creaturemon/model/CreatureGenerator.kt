package com.canonal.creaturemon.model

class CreatureGenerator {
    companion object {
        fun generateCreature(
            creatureAttribute: CreatureAttribute,
            name: String,
            icon: Int
        ): Creature {
            return Creature(name, creatureAttribute, calculateHitPoint(creatureAttribute), icon)
        }

        private fun calculateHitPoint(creatureAttribute: CreatureAttribute): Int {
            return creatureAttribute.intelligence * 5 +
                    creatureAttribute.strength * 3 +
                    creatureAttribute.endurance * 4
        }
    }
}