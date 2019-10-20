package functional

import org.junit.Test
import kotlin.concurrent.thread
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@Suppress("FunctionName")
internal class CallbacksTest {
    private val user1 = User("AAA", 123)
    private val user2 = User("BBB", 1)
    private val repo1 = Repo(10, "R1")
    private val repo2 = Repo(11, "R2")

    @Test
    fun `Function works without errors`() {
        getAggregatedContributions(EmptyService) {}
    }

    @Test
    fun `When no repositories or no users, returns empty lists`() {
        var times = 0
        getAggregatedContributions(EmptyService) {
            times++
        }
        assertEquals(times, 1)
        getAggregatedContributions(FakeStaticSyncService(listOf(), listOf(user1))) {
            assertEquals(listOf(), it)
            times++
        }
        assertEquals(times, 2)
        getAggregatedContributions(FakeStaticSyncService(listOf(repo1), listOf())) {
            assertEquals(listOf(), it)
            times++
        }
        assertEquals(times, 3)
    }

    @Test
    fun `Lists all unique users`() {
        var called = false
        getAggregatedContributions(FakeStaticSyncService(listOf(repo1), listOf(user1, user2))) {
            assertEquals(listOf(user1, user2), it)
            called = true
        }
        assertTrue(called)
    }

    @Test
    fun `Accumulates contributions of a single user`() {
        var called = false
        getAggregatedContributions(FakeStaticSyncService(listOf(repo1), listOf(user1, user1))) {
            assertEquals(listOf(User(user1.login, user1.contributions * 2)), it)
            called = true
        }
        assertTrue(called)
    }

    @Test
    fun `Accumulates contributions of multiple users user`() {
        var called = false
        getAggregatedContributions(FakeStaticSyncService(listOf(repo1, repo2), listOf(user1, user1, user2))) {
            val expected = listOf(
                User(user1.login, user1.contributions * 4),
                User(user2.login, user2.contributions * 2)
            ).sortedBy { it.contributions }
            assertEquals(expected, it.sortedBy { it.contributions })
            called = true
        }
        assertTrue(called)
    }

    @Test
    fun `Prepared for multithreading`() {
        val service = FakeDelayedAsyncService(List(100) { repo1 }, List(100) { user1 })
        var res = listOf<User>()
        getAggregatedContributions(service) { res = it }
        Thread.sleep(500)
        assertEquals(listOf(User(user1.login, user1.contributions * 100 * 100)), res)
    }

    class FakeStaticSyncService(private val repos: List<Repo>, private val users: List<User>) : GitHubService {
        override fun getOrgRepos(callback: (List<Repo>) -> Unit) {
            callback(repos)
        }

        override fun getRepoContributors(repo: String, callback: (List<User>) -> Unit) {
            callback(users)
        }
    }

    class FakeDelayedAsyncService(private val repos: List<Repo>, private val users: List<User>) : GitHubService {

        override fun getOrgRepos(callback: (List<Repo>) -> Unit) {
            thread {
                Thread.sleep(DELAY_TIME_MS)
                callback(repos)
            }
        }

        override fun getRepoContributors(repo: String, callback: (List<User>) -> Unit) {
            thread {
                Thread.sleep(DELAY_TIME_MS)
                callback(users)
            }
        }

        companion object {
            val DELAY_TIME_MS = 30L
        }
    }

    object EmptyService : GitHubService {
        override fun getOrgRepos(callback: (List<Repo>) -> Unit) {
            callback(emptyList())
        }

        override fun getRepoContributors(repo: String, callback: (List<User>) -> Unit) {
            callback(emptyList())
        }
    }
}