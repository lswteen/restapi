package com.wemakeprice.unusedticket.restapi.admin.controller

import com.wemakeprice.unusedticket.restapi.admin.dto.AdminRequest
import com.wemakeprice.unusedticket.restapi.admin.dto.AdminResponse
import com.wemakeprice.unusedticket.restapi.admin.service.AdminService
import com.wemakeprice.unusedticket.restapi.common.response.RestResponse
import io.swagger.annotations.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class AdminController {

    @Autowired
    lateinit var adminService: AdminService


    @ApiOperation(value = "딜 별 미사용 티켓 알람 수신처 정보 조회")
    @ApiImplicitParams(
            ApiImplicitParam(name = "dealId", value = "딜 아이디", required = true, dataType = "Long", paramType = "path")
    )
    @GetMapping("/v1/admin/receive/{dealId}")
    fun getReceiveInfoFromDeal(@PathVariable("dealId") dealId: Long): RestResponse<List<AdminResponse>> {
        val receiveInfo = adminService.getReceiveInfoFromDeal(dealId)
        return RestResponse(result = receiveInfo, status = HttpStatus.OK.value(), message = HttpStatus.OK.name)
    }

    @ApiOperation(value = "딜 별 미사용 티켓 알람 수신처 정보 저장")
    @ApiImplicitParams(
            ApiImplicitParam(name = "dealId", value = "딜 아이디", required = true, dataType = "Long", paramType = "path"),
            ApiImplicitParam(name = "adminRequest", value = "수신처 정보", required = true, dataType = "AdminRequest", paramType = "body",
                    examples = Example(
                            ExampleProperty(value = "adminRequestExample")
                    )
            )
    )
    @PostMapping("/v1/admin/receive/{dealId}")
    fun insertReceiveInfoFromDeal(@PathVariable("dealId") dealId: Long, @RequestBody adminRequest: AdminRequest): RestResponse<Int> {
        val insertStatus = adminService.insertReceiveInfoFromDeal(dealId, adminRequest)
        return RestResponse(result = insertStatus, status = HttpStatus.OK.value(), message = HttpStatus.OK.name)
    }

    @ApiOperation(value = "딜 별 미사용 티켓 알람 수신처 정보 저장 및 수정")
    @ApiImplicitParams(
            ApiImplicitParam(name = "dealId", value = "딜 아이디", required = true, dataType = "Long", paramType = "path"),
            ApiImplicitParam(name = "adminRequest", value = "수신처 정보", required = true, dataType = "AdminRequest", paramType = "body",
                    examples = Example(
                            ExampleProperty(value = "adminRequestExample")
                    )
            )
    )
    @PutMapping("/v1/admin/receive/{dealId}")
    fun updateReceiveInfoFromDeal(@PathVariable("dealId") dealId: Long, @RequestBody adminRequest: AdminRequest): RestResponse<Int> {
        val insertUpdateStatus = adminService.updateReceiveInfoFromDeal(dealId, adminRequest)
        return RestResponse(result = insertUpdateStatus, status = HttpStatus.OK.value(), message = HttpStatus.OK.name)
    }

}
