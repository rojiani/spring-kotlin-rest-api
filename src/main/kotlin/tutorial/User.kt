package tutorial

import java.time.Instant

/**
 * Representation of a User
 * @property username The username of the user
 * @property screenName The screen name of the user
 * @property email The email address of the user
 * @property registered When the user registered with us
 */
data class User(
    val username: String,
    val screenName: String,
    val email: String,
    val registered: Instant
)