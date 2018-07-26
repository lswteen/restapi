package com.wemakeprice.unusedticket.restapi.common.response

data class RestResponse<T>(var result: T, var status: Int, var message: String = "")