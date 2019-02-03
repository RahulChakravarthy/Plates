package com.enghack2018.Model.dataaccessobject.favouriteplates

import android.arch.persistence.room.Room
import android.content.Context
import com.enghack2018.Model.dataaccessobject.ApplicationDatabase
import com.enghack2018.Model.dataaccessobject.BaseTable
import com.enghack2018.Model.dataaccessobject.DatabaseOperationInterface
import com.enghack2018.Model.dataobject.PlateDO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavouritePlatesTable @Inject constructor(context: Context) : BaseTable() {

    private val abstractNotesDatabase : ApplicationDatabase
    private val dao : FavouritePlatesDataAccess
    private val databaseName = "FavouritePlatesDB"

    init {
        abstractNotesDatabase = Room.databaseBuilder(context, ApplicationDatabase::class.java, databaseName)
                .fallbackToDestructiveMigration()
                .build()
        dao = abstractNotesDatabase.favouritePlatesDataAccess()
    }

    fun insertFavouritePlate(plateDO: PlateDO, operation : DatabaseOperationInterface<Any?>) {
        doDatabaseOperation {
            operation.beforeOperation()
            dao.insertSingleFavouritePlate(plateDO)
            operation.afterOperation(null)
        }
    }
    fun insertFavouritePlates(notes : List<PlateDO>, operation : DatabaseOperationInterface<Any?>) {
        doDatabaseOperation {
            operation.beforeOperation()
            dao.insertMultipleFavouritePlates(notes)
            operation.afterOperation(null)
        }
    }

    fun fetchFavouritePlateById(id : Long, operation : DatabaseOperationInterface<PlateDO>) {
        doDatabaseOperation {
            operation.beforeOperation()
            val plate = dao.fetchFavouritePlateByPlateId(id)
            operation.afterOperation(plate)
        }
    }

    fun fetchAllFavouritePlates(operation : DatabaseOperationInterface<List<PlateDO>>) {
        doDatabaseOperation {
            operation.beforeOperation()
            val plate = dao.fetchAllFavouritePlates()
            operation.afterOperation(plate)
        }
    }

    fun updateFavouritePlate(plateDO: PlateDO, operation : DatabaseOperationInterface<Any?>) {
        doDatabaseOperation {
            operation.beforeOperation()
            dao.updateFavouritePlate(plateDO)
            operation.afterOperation(null)
        }
    }

    fun deleteFavouritePlate(plateDO: PlateDO, operation : DatabaseOperationInterface<Any?>) {
        doDatabaseOperation {
            operation.beforeOperation()
            dao.deleteFavouritePlate(plateDO)
            operation.afterOperation(null)
        }
    }
}