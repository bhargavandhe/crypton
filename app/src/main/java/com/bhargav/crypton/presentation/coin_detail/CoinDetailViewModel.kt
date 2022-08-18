package com.bhargav.crypton.presentation.coin_detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhargav.crypton.common.Constants
import com.bhargav.crypton.common.Response
import com.bhargav.crypton.domain.model.CoinDetail
import com.bhargav.crypton.domain.use_cases.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coinData: CoinDetail? = null,
    val error: String = ""
)

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var _state: MutableState<CoinDetailState> = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            setCoinState(coinId)
        }
    }

    private fun setCoinState(id: String) {
        getCoinUseCase.invoke(id).onEach { response ->
            when (response) {
                is Response.Error -> _state.value = CoinDetailState(
                    error = response.error ?: "An unexpected error occurred"
                )
                is Response.Loading -> _state.value = CoinDetailState(isLoading = true)
                is Response.Success -> _state.value = CoinDetailState(coinData = response.data)
            }
        }.launchIn(viewModelScope)
    }
}
