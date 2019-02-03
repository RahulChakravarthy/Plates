package com.enghack2018.Model.dataaccessobject

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.enghack2018.Model.Converters
import com.enghack2018.Model.dataaccessobject.favouriteplates.FavouritePlatesDataAccess
import com.enghack2018.Model.dataaccessobject.plates.PlatesDataAccess
import com.enghack2018.Model.dataobject.PlateDO

@Database(entities = [PlateDO::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun platesDataAccess() : PlatesDataAccess
    abstract fun favouritePlatesDataAccess() : FavouritePlatesDataAccess
}