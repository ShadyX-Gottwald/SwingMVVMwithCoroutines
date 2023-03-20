import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MovieDao {

    suspend fun getMovie() = withContext(Dispatchers.IO) {
        delay(1000)
        MovieRepo.movies.random()
    }
}