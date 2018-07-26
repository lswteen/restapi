package com.wemakeprice.unusedticket.restapi.admin.mapper

import com.wemakeprice.unusedticket.restapi.admin.dto.AdminRequest
import com.wemakeprice.unusedticket.restapi.admin.dto.AdminResponse
import com.wemakeprice.unusedticket.restapi.config.database.mapper.MasterMapper
import org.springframework.stereotype.Repository

@Repository
@MasterMapper
interface AdminMasterMapper {
    fun insertReceiveInfoFromDeal(adminRequest: AdminRequest): Int
    fun updateReceiveInfoFromDeal(adminRequest: AdminRequest): Int
}
