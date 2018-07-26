package com.wemakeprice.unusedticket.restapi.admin.service

import com.wemakeprice.unusedticket.restapi.admin.dto.AdminRequest
import com.wemakeprice.unusedticket.restapi.admin.dto.AdminResponse
import com.wemakeprice.unusedticket.restapi.admin.mapper.AdminMasterMapper
import com.wemakeprice.unusedticket.restapi.admin.mapper.AdminSlaveMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AdminService {

    @Autowired
    lateinit var adminMasterMapper: AdminMasterMapper

    @Autowired
    lateinit var adminSlaveMapper: AdminSlaveMapper

    fun getReceiveInfoFromDeal(dealId: Long): List<AdminResponse> {
        return this.adminSlaveMapper.getReceiveInfoFromDeal(dealId)
    }

    fun insertReceiveInfoFromDeal(dealId: Long, adminRequest: AdminRequest): Int {
        adminRequest.dealId = dealId
        return this.adminMasterMapper.insertReceiveInfoFromDeal(adminRequest)
    }

    fun updateReceiveInfoFromDeal(dealId: Long, adminRequest: AdminRequest): Int {
        adminRequest.dealId = dealId
        return this.adminMasterMapper.updateReceiveInfoFromDeal(adminRequest)
    }
}
