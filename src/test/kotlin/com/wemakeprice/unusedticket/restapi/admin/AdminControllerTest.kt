package com.wemakeprice.unusedticket.api.admin

import com.google.gson.GsonBuilder
import com.wemakeprice.unusedticket.restapi.RestapiApplication
import com.wemakeprice.unusedticket.restapi.admin.dto.AdminRequest
import name.falgout.jeffrey.testing.junit5.MockitoExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.transaction.annotation.Transactional

// 아직 JUnit 플랫폼을 직접 지원하지 않는 IDE 및 빌드 시스템에서 클래스를 실행할 수 있습니다.
// Intellij 2017.03 이후 버전은 아래의 내용이 없어도 사용이 가능합니다.
@RunWith(JUnitPlatform::class)
@ExtendWith(SpringExtension::class, MockitoExtension::class)
@SpringBootTest(classes = [RestapiApplication::class])
@AutoConfigureMockMvc
@ActiveProfiles("local")
class AdminControllerTest {

    /* *****************8********************** TEST CASE 내역 ***********************************************

       getReceiveInfoFromDeal    : GET -> 딜 별 미사용 티켓 알람 수신처 정보 조회 (/v1/admin/receive/{dealId})
       insertReceiveInfoFromDeal : POST -> 딜 별 미사용 티켓 알람 수신처 정보 저장 (/v1/admin/receive/{dealId})
       updateReceiveInfoFromDeal : PUT -> 딜 별 미사용 티켓 알람 수신처 정보 저장 및 수정 (/v1/admin/receive/{dealId})

     *******************************************************************************************************/


    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    @Throws(Exception::class)
    fun testGetReceiveInfoFromDeal() {
        this.mockMvc.perform(get("/v1/admin/receive/4"))
                .andDo(print())
                .andExpect(status().isOk)
    }

    @Test
    @Transactional
    @Rollback
    @Throws(Exception::class)
    fun testInsertReceiveInfoFromDeal() {
        val randomDealId = this.createRandomDealId()
        var adminRequestJson = this.createDummyAdminRequestJson(1, 1, 1)

        this.mockMvc.perform(post("/v1/admin/receive/$randomDealId")
                .content(adminRequestJson).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk)
    }

    @Test
    @Transactional
    @Rollback
    @Throws(Exception::class)
    fun testUpdateReceiveInfoFromDeal() {
        val randomDealId = this.createRandomDealId()
        var adminRequestJson = createDummyAdminRequestJson( 1, 1, 0)

        this.mockMvc.perform(put("/v1/admin/receive/$randomDealId")
                .content(adminRequestJson).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk)
    }

    private fun createDummyAdminRequestJson(companyContactManager: Int, companyCsManager: Int, companyStockManager: Int): String {
        val gson = GsonBuilder().create()
        return gson.toJson(AdminRequest(0, companyContactManager, companyCsManager, companyStockManager))
    }

    // deal id 를 random 으로 생성 하여 중복을 최대한 방지하는 테스트를 진행한다
    private fun createRandomDealId(): Long {
        return (Math.random() * 10000).toLong()
    }
}


