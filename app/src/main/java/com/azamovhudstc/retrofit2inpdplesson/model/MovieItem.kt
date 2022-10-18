package com.azamovhudstc.retrofit2inpdplesson.model

import java.io.Serializable

data class MovieItem(
    val bio: String,
    val createdby: String,
    val firstappearance: String,
    val imageurl: String,
    val name: String,
    val publisher: String,
    val realname: String,
    val team: String

) : Serializable