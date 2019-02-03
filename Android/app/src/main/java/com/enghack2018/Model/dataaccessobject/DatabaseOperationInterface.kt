package com.enghack2018.Model.dataaccessobject

interface DatabaseOperationInterface<T> {

    //Run before database operation starts
    fun beforeOperation()

    //Run after database operation starts
    fun afterOperation(result : T)
}