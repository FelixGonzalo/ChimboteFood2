package com.example.chimbotefood2.entities

import java.io.Serializable

class Restaurant (
    val name:String,
    val location:String,
    val phone:String,
    val schedule:String,
    val description:String,
    val image:Int
) : Serializable