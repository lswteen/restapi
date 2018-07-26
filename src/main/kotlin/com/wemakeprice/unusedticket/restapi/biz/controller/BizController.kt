package com.wemakeprice.unusedticket.restapi.biz.controller

import com.wemakeprice.unusedticket.restapi.biz.dto.BizResponse
import com.wemakeprice.unusedticket.restapi.biz.service.BizService
import com.wemakeprice.unusedticket.restapi.common.response.RestResponse
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class BizController {

    @Autowired
    lateinit var bizService: BizService

    @ApiOperation(value = "미사용 티켓이 포함된 딜 카운트 조회")
    @ApiImplicitParams(
            ApiImplicitParam(name = "companyId", value = "회사 아이디", required = true, dataType = "string", paramType = "path")
    )
    @GetMapping("/v1/biz/{companyId}/tickets/count")
    fun getTicketsCountFromCompany(@PathVariable("companyId") companyId: String): RestResponse<Long> {
        val count = this.bizService.getTicketsCountFromCompany(companyId)
        return RestResponse(result = count, status = HttpStatus.OK.value(), message = HttpStatus.OK.name)
    }

    @ApiOperation(value = "미사용 티켓 딜 정보")
    @ApiImplicitParams(
            ApiImplicitParam(name = "companyId", value = "회사 아이디", required = true, dataType = "string", paramType = "path"),
            ApiImplicitParam(name = "listCount", value = "조회할 티켓 개수 ", required = true, dataType = "int", paramType = "path")
    )
    @GetMapping("/v1/biz/{companyId}/tickets/{listCount}")
    fun getTicketsFromCompany(@PathVariable("companyId") companyId: String, @PathVariable("listCount") listCount: Int): RestResponse<List<BizResponse>> {
        val tickets = this.bizService.getTicketsFromCompany(companyId, listCount)
        return RestResponse(result = tickets, status = HttpStatus.OK.value(), message = HttpStatus.OK.name)
    }
}
