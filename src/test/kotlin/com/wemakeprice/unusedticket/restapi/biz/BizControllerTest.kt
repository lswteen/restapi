package com.wemakeprice.unusedticket.restapi.biz

import com.wemakeprice.unusedticket.restapi.RestapiApplication
import name.falgout.jeffrey.testing.junit5.MockitoExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

// 아직 JUnit 플랫폼을 직접 지원하지 않는 IDE 및 빌드 시스템에서 클래스를 실행할 수 있습니다.
// Intellij 2017.03 이후 버전은 아래의 내용이 없어도 사용이 가능합니다.
@RunWith(JUnitPlatform::class)
@ExtendWith(SpringExtension::class, MockitoExtension::class)
@SpringBootTest(classes = [RestapiApplication::class])
@AutoConfigureMockMvc
@ActiveProfiles("local")
class BizControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    @Throws(Exception::class)
    fun testGetTicketsCountFromCompany() {
        val companyId = "wmpp36591"
        this.mockMvc.perform(get("/v1/biz/$companyId/tickets/count"))
                .andDo(print())
                .andExpect(status().isOk)
    }

    @Test
    @Throws(Exception::class)
    fun testGetTicketsFromCompany() {
        val companyId = "wmpp36591"
        val listCount = 5

        this.mockMvc.perform(get("/v1/biz/$companyId/tickets/$listCount"))
                .andDo(print())
                .andExpect(status().isOk)
    }
}