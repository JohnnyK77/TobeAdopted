package johnnyk77.android.tobeadopted.ui.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import johnnyk77.android.tobeadopted.domain.entity.WaitAnimalEntity
import johnnyk77.android.tobeadopted.domain.usecase.WaitAnimalListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val waitAnimalListUseCase: WaitAnimalListUseCase,
) : ViewModel() {
    data class MainUiState(
        val waitAnimalList: List<WaitAnimalEntity>? = null
    )

    private val _uiSate = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiSate.asStateFlow()

    init {
        fetchWaitAnimalList()
    }

    private fun fetchWaitAnimalList() {
        viewModelScope.launch {
            waitAnimalListUseCase.invoke("49506270416d61783130306f626b6c66", 1, 999)
                .collect { list ->
                    _uiSate.update { it.copy(waitAnimalList = list) }
                }
        }
    }
}