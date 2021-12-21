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
            return creatureAttribute.intelligence * 2 +
                    creatureAttribute.strength * 3 +
                    creatureAttribute.endurance * 4
        }

//        private fun getIntelligencePoint(intelligenceType: IntelligenceType): Int {
//            return when (intelligenceType) {
//                IntelligenceType.SMART -> {
//                    (6..10).random()
//                }
//                IntelligenceType.REGULAR -> {
//                    (4..7).random()
//                }
//                IntelligenceType.DUMB -> {
//                    (1..4).random()
//                }
//            }
//        }
//
//        private fun getStrengthPoint(strengthType: StrengthType): Int {
//            return when (strengthType) {
//                StrengthType.STRONG -> {
//                    (5..10).random()
//                }
//                StrengthType.REGULAR -> {
//                    (3..7).random()
//                }
//                StrengthType.WEAK -> {
//                    (1..4).random()
//                }
//            }
//        }
//
//        private fun getEndurancePoint(enduranceType: EnduranceType): Int {
//            return when (enduranceType) {
//                EnduranceType.TOUGH -> {
//                    (8..10).random()
//                }
//                EnduranceType.REGULAR -> {
//                    (3..7).random()
//                }
//                EnduranceType.WEAK -> {
//                    (1..3).random()
//                }
//            }
//        }

    }
}