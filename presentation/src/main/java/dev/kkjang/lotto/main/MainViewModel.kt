package dev.kkjang.lotto.main

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
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

    private val _fbResponse = MutableStateFlow<GetFbLottoState>(GetFbLottoState.Init)
    val fbResponse: StateFlow<GetFbLottoState> = _fbResponse

    /** parameter : 회차 **/
    // xxx 회차별 로또 당첨 번호 조회
    fun getLotto(method: String, drwNo: Int) {
        viewModelScope.launch {
            getLottoUseCase.invoke(method = method, drwNo = drwNo)
                .onStart {
                    _lottoResponse.value = GetLottoState.IsLoading(true)
                }
                .catch { exception ->
                    _lottoResponse.value = GetLottoState.IsLoading(false)
                    _lottoResponse.value = GetLottoState.Failure(exception.message.default())
                }
                .collect {
                    _lottoResponse.value = GetLottoState.IsLoading(false)
                    _lottoResponse.value = GetLottoState.Success(it)
                }
        }
    }

    // realtime database 로또 번호 조회
    fun getFbLotto(path: String) {
        _fbResponse.value = GetFbLottoState.IsLoading

        viewModelScope.launch {
            try {
                val database = Firebase.database
                val myRef = database.getReference(path)

                myRef.get().addOnSuccessListener {
                    val data = it.value.toString()
                    _fbResponse.value = GetFbLottoState.Success(data)
                }.addOnFailureListener {
                    _fbResponse.value = GetFbLottoState.Failure(it.message ?: "Unknown error")
                }
            } catch (e: Exception) {
                _fbResponse.value = GetFbLottoState.Failure(e.message ?: "Unknown error")
            }
        }
    }

    sealed class GetFbLottoState {
        object Init : GetFbLottoState()
        object IsLoading : GetFbLottoState()
        data class Success(val lottoResponse: String) : GetFbLottoState()
        data class Failure(val message: String) : GetFbLottoState()
    }


    sealed class GetLottoState {
        object Init : GetLottoState()
        data class IsLoading(val isLoading: Boolean) : GetLottoState()
        data class Success(val lottoResponse: LottoVo) : GetLottoState()
        data class Failure(val message: String) : GetLottoState()
    }
}