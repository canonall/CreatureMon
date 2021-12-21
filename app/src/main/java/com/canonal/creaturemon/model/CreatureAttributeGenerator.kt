package com.canonal.creaturemon.model

import com.canonal.creaturemon.model.attributeType.EnduranceType
import com.canonal.creaturemon.model.attributeType.IntelligenceType
import com.canonal.creaturemon.model.attributeType.StrengthType

class CreatureAttributeGenerator {
    companion object {
        fun generateCreatureAttribute(
            intelligenceType: IntelligenceType,
            strengthType: StrengthType,
            enduranceType: EnduranceType,
        ): CreatureAttribute {
            return CreatureAttribute(
                getIntelligencePoint(intelligenceType),
                getStrengthPoint(strengthType),
                getEndurancePoint(enduranceType)
            )
        }

        private fun getIntelligencePoint(intelligenceType: IntelligenceType): Int {
            return when (intelligenceType) {
                IntelligenceType.SMART -> {
                    (6..10).random()
                }
                IntelligenceType.REGULAR -> {
                    (4..7).random()
                }
                IntelligenceType.DUMB -> {
                    (1..4).random()
                }
            }
        }

        private fun getStrengthPoint(strengthType: StrengthType): Int {
            return when (strengthType) {
                StrengthType.STRONG -> {
                    (5..10).random()
                }
                StrengthType.REGULAR -> {
                    (3..7).random()
                }
                StrengthType.WEAK -> {
                    (1..4).random()
                }
            }
        }

        private fun getEndurancePoint(enduranceType: EnduranceType): Int {
            return when (enduranceType) {
                EnduranceType.TOUGH -> {
                    (8..10).random()
                }
                EnduranceType.REGULAR -> {
                    (3..7).random()
                }
                EnduranceType.WEAK -> {
                    (1..3).random()
                }
            }
        }
    }
}