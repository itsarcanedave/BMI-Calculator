package com.example.weightdiary_lifeinformationsystem

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diary_table")
data class WeightHistory(


    @ColumnInfo(name = "date")
    val Date: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "weight")
    val WeightData:Int,

    @ColumnInfo(name = "bmi")
    val BMIData:String
){
    @PrimaryKey(autoGenerate = true)
    var bmiID:Int = 0
}
