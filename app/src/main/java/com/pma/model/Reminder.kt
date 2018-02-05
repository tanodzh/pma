package com.pma.model

import java.util.*

/**
 * Created by tano on 5.2.2018 г..
 */

enum class IMPORTANCE {
    LOW, MIDDLE, HIGH
}

data class Reminder(var iconId: Int = 0,
                    var title: String = "default title",
                    var description: String = "default description",
                    var daysToLive: Int = 0,
                    var perDay: Int = 0,
                    var start: Date = Date(),
                    var importance: IMPORTANCE = IMPORTANCE.MIDDLE)
