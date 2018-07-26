package com.wemakeprice.unusedticket.restapi.biz.service

import com.wemakeprice.unusedticket.restapi.biz.dto.BizRequest
import com.wemakeprice.unusedticket.restapi.biz.dto.BizResponse
import com.wemakeprice.unusedticket.restapi.biz.mapper.BizMasterMapper
import com.wemakeprice.unusedticket.restapi.biz.mapper.BizSlaveMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BizService {

    @Autowired
    lateinit var bizMasterMapper: BizMasterMapper

    @Autowired
    lateinit var bizSlaveMapper: BizSlaveMapper

    fun getTicketsCountFromCompany(companyId: String): Long {
        return this.bizSlaveMapper.getTicketsCountFromCompany(companyId)
    }

    fun getTicketsFromCompany(companyId: String, listCount: Int): List<BizResponse> {
        val bizRequest = BizRequest(companyId, listCount)
        return this.bizSlaveMapper.getTicketsFromCompany(bizRequest)
    }
}
