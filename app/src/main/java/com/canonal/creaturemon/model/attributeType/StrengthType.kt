package com.canonal.creaturemon.model.attributeType

enum class StrengthType {
    STRONG {
        override fun toString(): String {
            return "Strong"
        }
    },
    REGULAR {
        override fun toString(): String {
            return "Regular"
        }
    },
    WEAK {
        override fun toString(): String {
            return "Weak"
        }
    }
}