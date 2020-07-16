package com.example.jsoncontactk

import java.io.Serializable

data class Contact(val name: Name, val picture: Picture, val email: String, val gender: String):Serializable
