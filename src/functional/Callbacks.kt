package functional

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

fun main(args: Array<String>) {
    val username = "Your username"
    val token = "Your token"
    val org = "kotlin"
    val req = RequestData(username, token, org)
    val service: GitHubService = createGitHubService(req.username, req.password)

    service.getOrgReposCall().onResponse {
        println(it)
    }
}

fun GitHubService.getOrgRepos(callback: (List<Repo>)->Unit) =
    this.getOrgReposCall().onResponse {
        callback(it.body() ?: throw Error("No body in the response"))
    }

fun GitHubService.getRepoContributors(repo: String, callback: (List<User>)->Unit) =
    this.getRepoContributorsCall(repo).onResponse {
        callback(it.body() ?: throw Error("No body in the response"))
    }

interface GitHubService {
    @GET("orgs/kotlin/repos?per_page=100")
    fun getOrgReposCall(): Call<List<Repo>>

    @GET("repos/kotlin/{repo}/contributors?per_page=100")
    fun getRepoContributorsCall(
        @Path("repo") repo: String
    ): Call<List<User>>
}

@JsonIgnoreProperties(ignoreUnknown = true)
data class Repo(
    val id: Long,
    val name: String
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class User(
    val login: String,
    val contributions: Int
)

data class RequestData(
    val username: String,
    val password: String,
    val org: String
)

fun createGitHubService(username: String, password: String): GitHubService {
    val authToken = "Basic " + Base64.getEncoder().encode("$username:$password".toByteArray()).toString(Charsets.UTF_8)
    val httpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val original = chain.request()
            val builder = original.newBuilder()
                .header("Accept", "application/vnd.github.v3+json")
                .header("Authorization", authToken)
            val request = builder.build()
            chain.proceed(request)
        }
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(JacksonConverterFactory.create(jacksonObjectMapper()))
        .client(httpClient)
        .build()
    return retrofit.create(GitHubService::class.java)
}

inline fun <T> Call<T>.onResponse(crossinline callback: (Response<T>) -> Unit) {
    enqueue(object : Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            callback(response)
        }

        override fun onFailure(call: Call<T>, t: Throwable) {
            throw t
        }
    })
}