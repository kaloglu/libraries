package com.kaloglu.library.ui.models

import com.kaloglu.library.ui.utils.Constants

data class ErrorModel(
    var code: String = Constants.UNKNOWN_ERROR_CODE,
    var message: String = Constants.UNKNOWN_ERROR
)
