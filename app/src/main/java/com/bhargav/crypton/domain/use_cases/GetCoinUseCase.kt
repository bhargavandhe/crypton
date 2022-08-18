package com.bhargav.crypton.domain.use_cases

import com.bhargav.crypton.common.Response
import com.bhargav.crypton.domain.model.CoinDetail
import com.bhargav.crypton.domain.repository.CryptonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CryptonRepository
) {
    operator fun invoke(id: String): Flow<Response<CoinDetail>> = flow {
        try {
            emit(Response.Loading<CoinDetail>())
            val coin = repository.getCoinDetails(id = id).toCoinDetail()
            emit(Response.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Response.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occurred!"))
        } catch (e: IOException) {
            emit(Response.Error<CoinDetail>("Couldn't reach server. Check your Internet connection!"))
        }
    }
}
