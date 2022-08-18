package com.bhargav.crypton.domain.use_cases

import com.bhargav.crypton.common.Response
import com.bhargav.crypton.domain.model.Coin
import com.bhargav.crypton.domain.repository.CryptonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CryptonRepository
) {
    operator fun invoke(): Flow<Response<List<Coin>>> = flow {
        try {
            emit(Response.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Response.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Response.Error<List<Coin>>(error = e.localizedMessage ?: "An unexpected error occurred!"))
        } catch (e: IOException) {
            emit(Response.Error<List<Coin>>("Couldn't reach server. Check your Internet connection!"))
        }
    }
}
