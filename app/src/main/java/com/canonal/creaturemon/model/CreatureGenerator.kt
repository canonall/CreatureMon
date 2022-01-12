package com.canonal.creaturemon.model

class CreatureGenerator {
    companion object {
        fun generateCreature(
            creatureAttribute: CreatureAttribute,
            name: String,
            avatar: String
        ): Creature {
            return Creature(
                name = name,
                creatureAttribute = creatureAttribute,
                hitPoint = calculateHitPoint(creatureAttribute),
                avatar = avatar
            )
        }

        private fun calculateHitPoint(creatureAttribute: CreatureAttribute): Int {
            return creatureAttribute.intelligence * 2 +
                    creatureAttribute.strength * 3 +
                    creatureAttribute.endurance * 4
        }
    }
}