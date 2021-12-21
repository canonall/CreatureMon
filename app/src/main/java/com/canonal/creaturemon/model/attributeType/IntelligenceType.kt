package com.canonal.creaturemon.model.attributeType

enum class IntelligenceType {
    SMART {
        override fun toString(): String {
            return "Smart"
        }
    },
    REGULAR{
        override fun toString(): String {
            return "Regular"
        }
           },
    DUMB{
        override fun toString(): String {
            return "Dumb"
        }
    }

}