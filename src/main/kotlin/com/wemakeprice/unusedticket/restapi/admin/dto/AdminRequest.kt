package com.wemakeprice.unusedticket.restapi.admin.dto

data class AdminRequest (
        var dealId: Long,
        var companyContactManager: Int,
        var companyCsManager: Int,
        var companyStockManager: Int
)