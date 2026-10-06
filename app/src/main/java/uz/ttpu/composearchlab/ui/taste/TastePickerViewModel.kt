package uz.ttpu.composearchlab.ui.taste

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TastePickerViewModel : ViewModel() {

    private val _state = MutableStateFlow(TastePickerState(artists = seedArtists))
    val state: StateFlow<TastePickerState> = _state.asStateFlow()

    fun onGenreClick(genre: String) {
        _state.update { current ->
            current.copy(selectedGenre = if (current.selectedGenre == genre) null else genre)
        }
    }

    fun onArtistLikeToggled(id: Int) {
        _state.update { current ->
            current.copy(
                likedIds = if (id in current.likedIds) current.likedIds - id else current.likedIds + id
            )
        }
    }
}
