package com.wemakeprice.unusedticket.restapi.biz.dto

import java.sql.Timestamp

data class BizResponse(
    var dealId: Long ,
    var dealName: String,
    var validEndTime: String
)