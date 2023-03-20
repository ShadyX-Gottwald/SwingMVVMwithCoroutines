import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MovieViewModel {

    private val  movieDao: MovieDao = MovieDao()

    private val context: CoroutineName = CoroutineName("movie viewModel scope")

    private val scope: CoroutineScope = CoroutineScope(context)

    var currentMovie: Movie? = null
        private set

    fun loadMovieData() {
        scope.launch {
            val movie =  movieDao.getMovie()
            println(movie.title)
            selectedMovieObserver(movie)

        }
    }

    private fun selectedMovieObserver(movie: Movie) {
        currentMovie = movie
    }

}