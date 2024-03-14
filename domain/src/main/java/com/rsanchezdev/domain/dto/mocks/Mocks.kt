package com.rsanchezdev.domain.dto.mocks

import com.rsanchezdev.domain.dto.user.User
import com.rsanchezdev.domain.dto.user.UserName
import com.rsanchezdev.domain.dto.user.UserPicture
import com.rsanchezdev.domain.dto.user.UserRegistered
import java.util.Date

val sampleUser = User(
    gender = "male",
    name = UserName("Mr.", "Rubén", "Sánchez"),
    email = "ruben.sanchez@example.com",
    registered = UserRegistered(Date(), 19),
    phone = "655728162",
    picture = UserPicture("https://randomuser.me/api/portraits/men/53.jpg", "https://randomuser.me/api/portraits/men/53.jpg", "https://randomuser.me/api/portraits/men/53.jpg")
)