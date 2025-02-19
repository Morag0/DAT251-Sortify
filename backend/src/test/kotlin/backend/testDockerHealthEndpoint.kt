package backend

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.AfterAll
import org.springframework.web.client.RestTemplate
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.containers.GenericContainer

@Testcontainers  // Ensure Testcontainers is properly managed by JUnit 5
class DockerIntegrationTests {

    // Create a subclass of GenericContainer to avoid wildcard projection issues
    class FixedGenericContainer(imageName: String) : GenericContainer<FixedGenericContainer>(imageName)

    // Create a Testcontainers-managed container using the specified Docker image and the port it exposes
    companion object {
        private val backendContainer = GenericContainer<Nothing>("sortify-backend-image:latest")
            .withExposedPorts(9876)

        // Runs once before all tests in this class. Starts the container before any tests are run
        @BeforeAll
        @JvmStatic
        fun startContainer() {
            backendContainer.start()
        }

        // Runs once after all tests have completed. Stops and cleans up the container after all tests have run
        @AfterAll
        @JvmStatic
        fun stopContainer() {
            backendContainer.stop()
        }
    }

    @Test
    fun testHealthEndpoint() {
        val restTemplate = RestTemplate()

        // Get the actual mapped port for the backend container
        val backendPort = backendContainer.getMappedPort(9876)
        val backendUrl = "http://localhost:$backendPort/health"

        // Assert that the health endpoint returns 200 OK
        val response = restTemplate.getForEntity(backendUrl, String::class.java)
        assertEquals(200, response.statusCode.value())
    }
}
