package com.wemakeprice.unusedticket.restapi.admin.dto

data class AdminResponse(
        var companyContactManager: Boolean,
        var companyCsManager: Boolean,
        var companyStockManager: Boolean
)