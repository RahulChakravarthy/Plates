package com.enghack2018.Model.dataaccessobject.favouriteplates

import android.arch.persistence.room.*
import com.enghack2018.Model.dataobject.PlateDO

@Dao
interface FavouritePlatesDataAccess {

    @Insert
    fun insertSingleFavouritePlate(plateDO: PlateDO)

    @Insert
    fun insertMultipleFavouritePlates(notes: List<PlateDO>)

    @Query("SELECT * FROM PlateDO")
    fun fetchAllFavouritePlates() : List<PlateDO>

    @Query("SELECT * FROM PlateDO WHERE id = :plateId")
    fun fetchFavouritePlateByPlateId (plateId : Long) : PlateDO

    @Update
    fun updateFavouritePlate(plateDO: PlateDO)

    @Delete
    fun deleteFavouritePlate(plateDO: PlateDO)
}