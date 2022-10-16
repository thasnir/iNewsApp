package com.cba.core_domain

data class ErrorResult(var errorCode : String?= ErrorCodes.Base.GENERIC_ERROR,var errorMsg :String?=null )
