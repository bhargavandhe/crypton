package com.bhargav.crypton.presentation.coin_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhargav.crypton.common.Response
import com.bhargav.crypton.domain.model.Coin
import com.bhargav.crypton.domain.use_cases.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {
    private var _state: MutableState<CoinListState> = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        setCoinState()
    }

    private fun setCoinState() {
        getCoinsUseCase.invoke().onEach { response ->
            when (response) {
                is Response.Error -> _state.value = CoinListState(
                    error = response.error ?: "An unexpected error occurred"
                )
                is Response.Loading -> _state.value = CoinListState(isLoading = true)
                is Response.Success -> _state.value = CoinListState(coins = response.data ?: emptyList())
            }
        }.launchIn(viewModelScope)
    }
}
