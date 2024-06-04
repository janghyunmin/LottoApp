package dev.kkjang.lotto.splash

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.kkjang.data.module.provider.ResourcesProvider
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val resourcesProvider: ResourcesProvider
) : ViewModel() {

    init {

    }

}