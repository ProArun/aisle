package com.example.aisle.utils

import java.util.regex.Pattern

object Utils {
    fun String.isValidPhoneNumber(): Boolean {
        val patterns =
            "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$"
        return Pattern.compile(patterns).matcher(this).matches()
    }
}