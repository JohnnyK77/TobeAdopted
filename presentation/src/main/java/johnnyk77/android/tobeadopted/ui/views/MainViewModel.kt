package johnnyk77.android.tobeadopted.ui.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import johnnyk77.android.tobeadopted.domain.entity.Species
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
        val waitAnimalList: List<WaitAnimalEntity>? = null,
        val isCatListType: Boolean = false
    )

    private val _uiSate = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiSate.asStateFlow()
    private var totalWaitAnimalList: List<WaitAnimalEntity>? = null

    init {
        fetchWaitAnimalList()
    }

    private fun fetchWaitAnimalList() {
        viewModelScope.launch {
            waitAnimalListUseCase.invoke("49506270416d61783130306f626b6c66", 1, 999)
                .collect { list ->
                    totalWaitAnimalList = list
                    setWaitAnimalList()
                }
        }
    }

    fun setListType(isCatListType: Boolean) {
        _uiSate.update { it.copy(isCatListType = isCatListType) }
        setWaitAnimalList()
    }

    private fun setWaitAnimalList() {
        if (totalWaitAnimalList.isNullOrEmpty()) {
            return
        }
        _uiSate.update {
            it.copy(
                waitAnimalList = totalWaitAnimalList!!.filter { list ->
                    if (uiState.value.isCatListType)
                        list.species == Species.Cat.code
                    else
                        list.species == Species.Dog.code
                })
        }
    }
}