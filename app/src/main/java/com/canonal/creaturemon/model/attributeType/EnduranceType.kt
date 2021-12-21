package com.canonal.creaturemon.model.attributeType

enum class EnduranceType {
    TOUGH {
        override fun toString(): String {
            return "Tough"
        }
    },
    REGULAR {
        override fun toString(): String {
            return "Smart"
        }
    },
    WEAK {
        override fun toString(): String {
            return "Smart"
        }
    }
}