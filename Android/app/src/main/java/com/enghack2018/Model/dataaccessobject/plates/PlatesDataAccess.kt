package com.enghack2018.Model.dataaccessobject.plates

import android.arch.persistence.room.*
import com.enghack2018.Model.dataobject.PlateDO

@Dao
interface PlatesDataAccess {

    @Insert
    fun insertSinglePlate(plateDO: PlateDO)

    @Insert
    fun insertMultiplePlates(notes: List<PlateDO>)

    @Query("SELECT * FROM PlateDO")
    fun fetchAllPlates() : List<PlateDO>

    @Query("SELECT * FROM PlateDO WHERE id = :plateId")
    fun fetchPlateByPlateId (plateId : Long) : PlateDO

    @Update
    fun updatePlate(plateDO: PlateDO)

    @Delete
    fun deletePlate(plateDO: PlateDO)
}