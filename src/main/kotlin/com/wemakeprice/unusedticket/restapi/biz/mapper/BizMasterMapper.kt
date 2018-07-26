package com.wemakeprice.unusedticket.restapi.biz.mapper

import com.wemakeprice.unusedticket.restapi.biz.dto.BizResponse
import com.wemakeprice.unusedticket.restapi.config.database.mapper.MasterMapper
import org.springframework.stereotype.Repository

@Repository
@MasterMapper
interface BizMasterMapper {
    fun addDealsFromCompany(deals: List<BizResponse>): Int
}