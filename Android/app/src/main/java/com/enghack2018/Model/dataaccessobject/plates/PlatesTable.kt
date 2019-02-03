package com.enghack2018.Model.dataaccessobject.plates

import android.arch.persistence.room.Room
import android.content.Context
import com.enghack2018.Model.dataaccessobject.ApplicationDatabase
import com.enghack2018.Model.dataaccessobject.BaseTable
import com.enghack2018.Model.dataaccessobject.DatabaseOperationInterface
import com.enghack2018.Model.dataobject.PlateDO
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlatesTable @Inject constructor(val context: Context): BaseTable() {

    private val abstractNotesDatabase : ApplicationDatabase
    private val dao : PlatesDataAccess
    private val databaseName = "PlatesDB"

    init {
        abstractNotesDatabase = Room.databaseBuilder(context, ApplicationDatabase::class.java, databaseName)
                .fallbackToDestructiveMigration()
                .build()
        dao = abstractNotesDatabase.platesDataAccess()
    }

    fun insertPlate(plateDO: PlateDO, operation : DatabaseOperationInterface<Any?>) {
        doDatabaseOperation {
            operation.beforeOperation()
            dao.insertSinglePlate(plateDO)
            operation.afterOperation(null)
        }
    }
    fun insertPlates(notes : List<PlateDO>, operation : DatabaseOperationInterface<Any?>) {
        doDatabaseOperation {
            operation.beforeOperation()
            dao.insertMultiplePlates(notes)
            operation.afterOperation(null)
        }
    }

    fun fetchPlateById(id : Long, operation : DatabaseOperationInterface<PlateDO>) {
        doDatabaseOperation {
            operation.beforeOperation()
            val plate = dao.fetchPlateByPlateId(id)
            operation.afterOperation(plate)
        }
    }

    fun fetchAllPlates(operation : DatabaseOperationInterface<List<PlateDO>>) {
        doDatabaseOperation {
            operation.beforeOperation()
            val plate = dao.fetchAllPlates()
            operation.afterOperation(plate)
        }
    }

    fun updatePlate(plateDO: PlateDO, operation : DatabaseOperationInterface<Any?>) {
        doDatabaseOperation {
            operation.beforeOperation()
            dao.updatePlate(plateDO)
            operation.afterOperation(null)
        }
    }

    fun deletePlate(plateDO: PlateDO, operation : DatabaseOperationInterface<Any?>) {
        doDatabaseOperation {
            operation.beforeOperation()
            dao.deletePlate(plateDO)
            operation.afterOperation(null)
        }
    }
}