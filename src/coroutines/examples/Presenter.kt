@file:Suppress("unused")

package coroutines.examples

import kotlinx.coroutines.experimental.*
import kotlin.coroutines.experimental.CoroutineContext

interface MainView {
    fun showUserData(data: Data)
    fun showNews(news: List<News>)
    fun showError(t: Throwable)
}

class UserData(val id: Int, val name: String)
class Data()
class News(val publishedAt: Long, val published: Boolean)

interface UserRepository {
    suspend fun getUser(): UserData
    suspend fun getDataFor(id: Int): Data
    suspend fun getNews(): List<News>
}

class MainPresenter(
        private val view: MainView,
        private val repo: UserRepository
) : CoroutineScope {

    private val job = Job()
    private val exceptionHandler = CoroutineExceptionHandler { _, t ->
        view.showError(t)
        t.printStackTrace()
    }
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main + exceptionHandler

    fun onStart() {
        launch {
            val user = repo.getUser()
            val data = repo.getDataFor(user.id)
            view.showUserData(data)
        }
        launch {
            val news = repo.getNews()
            view.showNews(news)
        }
    }

    fun onDestroy() {
        job.cancel()
    }
}