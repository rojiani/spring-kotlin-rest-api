package tutorial

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

@RestController
class FirstController {

    /**
     * The ultimate answer to life, the universe and everything
     */
    @RequestMapping("/answer")
    fun answer() = 42

    /**
     * Get the details of a user
     */
    @RequestMapping("/user")
    fun user(): User = User(
        username = "nrojiani",
        screenName = "Navid",
        email = "nrojiani@gmail.com",
        registered = Instant.now()
    )

    /**
     * Perform some string manipulation on the given value
     * @param value The value to manipulate (path variable)
     * @param operation The operation to perform (query param)
     */
    @RequestMapping("/string/{value}")
    fun manipulateString(
        @PathVariable value: String,
        @RequestParam(name = "operation", defaultValue = "none") operation: String
    ): String = when (operation.toUpperCase()) {
        "REVERSE" -> value.reversed()
        "UPPER" -> value.toUpperCase()
        "LOWER" -> value.toLowerCase()
        else -> value
    }

    /**
     * Pretend to create a new user
     * @param user The details of the user to create
     */
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = ["/user"], method = [RequestMethod.POST])
    fun createUser(@RequestBody user: NewUser): User = User(
        username = user.username,
        screenName = user.screenName,
        email = user.email,
        registered = Instant.now()
    )

    /** Cause an error to occur */
    @RequestMapping("/raiseError")
    fun raiseError(): Unit = throw IllegalArgumentException("This shouldn't have happened")

    /** Handle the error */
    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(code = HttpStatus.CONFLICT)
    fun handleError(e: IllegalArgumentException): String? = e.message

}
