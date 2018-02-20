package tutorial

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


/**
 * The main entry point to the application
 *
 * [Tutorial](https://scotch.io/@grahamcox82/how-to-build-a-simple-rest-api-with-kotlin-and-spring-boot)
 */
@EnableAutoConfiguration
@Configuration
class Application {

    @Bean
    fun controller() = FirstController()
}

/**
 * Run the application
 * @param args The command line arguments
 */
fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}