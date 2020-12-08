package com.example.weightdiary_lifeinformationsystem

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DatabaseDao {
    @Insert
    fun insert(inputData: WeightHistory)
    @Query("DELETE FROM diary_table")
    fun clear()
    @Query("SELECT Date FROM diary_table ORDER BY bmiID DESC LIMIT 1")
    fun loadDateLatest():Long
    @Query("SELECT BMI FROM diary_table ORDER BY bmiID DESC LIMIT 1")
    fun loadBMILatest():Int
    @Query("SELECT Weight FROM diary_table ORDER BY bmiID DESC LIMIT 1")
    fun loadWeightLatest():Int
    @Query("SELECT Date FROM diary_table WHERE bmiID = 2")
    fun loadDateSecond():Long
    @Query("SELECT BMI FROM diary_table WHERE bmiID = 2")
    fun loadBMISecond():Int
    @Query("SELECT Weight FROM diary_table WHERE bmiID = 2")
    fun loadWeightSecond():Int



    @Update
    suspend fun update(BMI: WeightHistory)
    @Query ("SELECT * from diary_table WHERE bmiId = :key")
    suspend fun get(key: Long): WeightHistory?

    @Query("SELECT * FROM diary_table ORDER BY bmiID DESC LIMIT 1")
    suspend fun getLatest(): WeightHistory?
    @Query("SELECT * FROM diary_table ORDER BY bmiID DESC")
    fun getAllHistory(): LiveData<List<WeightHistory>>


}