package com.example.androiddihilt.ui.mapper

import com.example.androiddihilt.domain.model.User
import com.example.androiddihilt.ui.model.UserUI

fun User.toUserUi(): UserUI {
    return UserUI(
        name = name.split(" ").joinToString(" ") { it.replaceFirstChar { c -> c.uppercase() } },
        email = email
    )
}
