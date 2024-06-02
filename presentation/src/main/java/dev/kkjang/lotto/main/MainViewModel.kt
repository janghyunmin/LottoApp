package dev.kkjang.lotto.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.kkjang.data.module.provider.ResourcesProvider
import dev.kkjang.data.util.default
import dev.kkjang.domain.model.LottoVo
import dev.kkjang.domain.usecase.GetLottoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val resourcesProvider: ResourcesProvider,
    private val getLottoUseCase: GetLottoUseCase
) : ViewModel() {

    private val _lottoResponse: MutableStateFlow<GetLottoState> =
        MutableStateFlow(GetLottoState.Init)
    val lottoResponse: StateFlow<GetLottoState> get() = _lottoResponse.asStateFlow()

    fun getLotto(method: String, drwNo: Int) {
        viewModelScope.launch {
            getLottoUseCase.invoke(method = method, drwNo = drwNo)
                .onStart {
                    _lottoResponse.value = GetLottoState.IsLoading(true)
                }
                .catch {exception ->
                    _lottoResponse.value = GetLottoState.IsLoading(false)
                    _lottoResponse.value = GetLottoState.Failure(exception.message.default())
                }
                .collect {
                    _lottoResponse.value = GetLottoState.IsLoading(false)
                    _lottoResponse.value = GetLottoState.Success(it)
                }
        }
    }


    sealed class GetLottoState {
        object Init : GetLottoState()
        data class IsLoading(val isLoading: Boolean) : GetLottoState()
        data class Success(val lottoResponse: LottoVo) : GetLottoState()
        data class Failure(val message: String) : GetLottoState()
    }
}