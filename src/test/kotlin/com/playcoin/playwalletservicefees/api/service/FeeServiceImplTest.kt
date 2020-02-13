package com.playcoin.playwalletservicefees.api.service

import com.playcoin.playwalletservicefees.enums.CoinType
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FeeServiceImplTest {

    @Autowired
    lateinit var feeService: FeeService

    @Test
    fun beanNotNull() {
        assertThat(feeService).isNotNull
    }

    @Test
    fun bitcoinFees() {
        val result = feeService.fees(coinType = CoinType.BTC)
        assertThat(result.isSuccess).isTrue()

        val fee = result.getOrNull()
        assertThat(fee).isNotNull
    }

    @Test
    fun ethereumFees() {
        val result = feeService.fees(coinType = CoinType.ETH)
        assertThat(result.isFailure).isTrue()

        val fee = result.getOrNull()
        assertThat(fee).isNull()
    }

    @Test
    fun playcoinFees() {
        val result = feeService.fees(coinType = CoinType.PLY)
        assertThat(result.isFailure).isTrue()

        val fee = result.getOrNull()
        assertThat(fee).isNull()
    }

    @Test
    fun playcoinxFees() {
        val result = feeService.fees(coinType = CoinType.PLX)
        assertThat(result.isFailure).isTrue()

        val fee = result.getOrNull()
        assertThat(fee).isNull()
    }

    @Test
    fun dummyFees() {
        val result = feeService.fees(coinType = CoinType.DMY)
        assertThat(result.isFailure).isTrue()

        val fee = result.getOrNull()
        assertThat(fee).isNull()
    }
}
