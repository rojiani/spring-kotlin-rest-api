package tutorial

import com.fasterxml.jackson.annotation.JsonCreator

/**
 * Representation of a User to create
 * @property username The username of the user
 * @property screenName The screen name of the user
 * @property email The email address of the user
 */
data class NewUser @JsonCreator constructor(
    val username: String,
    val screenName: String,
    val email: String
)