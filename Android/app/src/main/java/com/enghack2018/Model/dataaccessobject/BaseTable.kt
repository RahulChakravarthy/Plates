package com.enghack2018.Model.dataaccessobject

import com.enghack2018.util.bgPool
import kotlinx.coroutines.experimental.launch

open class BaseTable {
    protected fun doDatabaseOperation(operation : () -> Unit) {
        launch (bgPool) {
            operation()
        }
    }
}