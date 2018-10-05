@file:Suppress("ObsoleteExperimentalCoroutines", "DEPRECATION")

package coroutines.backend

import kotlinx.coroutines.experimental.delay

class EmailService {

    suspend fun sendEmail(to: String, body: String) {
        delay(2000)
        print("Sent email to $to with body $body")
    }
}