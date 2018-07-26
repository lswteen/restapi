package com.wemakeprice.unusedticket.restapi.biz.mapper

import com.wemakeprice.unusedticket.restapi.biz.dto.BizRequest
import com.wemakeprice.unusedticket.restapi.biz.dto.BizResponse
import com.wemakeprice.unusedticket.restapi.config.database.mapper.SlaveMapper
import org.springframework.stereotype.Repository

@Repository
@SlaveMapper
interface BizSlaveMapper {
    fun getTicketsCountFromCompany(companyId: String): Long
    fun getTicketsFromCompany(bizRequest: BizRequest): List<BizResponse>
}
