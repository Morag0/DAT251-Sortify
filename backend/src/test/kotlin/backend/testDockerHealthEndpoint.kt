package backend

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Test
import java.net.Socket
import kotlin.test.assertTrue

class DockerIntegrationTests {

    companion object {
        private const val backendHost = "localhost"
        private const val backendPort = 9876

        @BeforeAll
        @JvmStatic
        fun waitForBackend() {
            // Wait for backend to be ready (re-try 10 times with 3 seconds sleep time)
            var retries = 10
            val sleepTime = 3000L

            while (retries > 0) {
                try {
                    
                    // Try connecting to the backend service
                    Socket(backendHost, backendPort).use { _ ->
                        println("✅ Backend is up and running!")
                    }
                    return // Exit function if connection is successful

                } catch (e: Exception) {
                    println("⏳ Waiting for backend to be ready... (${10 - retries}/10)")
                }

                // Wait before retrying
                Thread.sleep(sleepTime)
                retries--
            }

            // If retries run out, fail the test
            throw RuntimeException("❌ Backend did not start in time")
        }

        @AfterAll
        @JvmStatic
        fun cleanup() {
            println("✅ Tests completed.")
        }
    }

   @Test
    fun testBackendConnection() {
        // Try to connect to the backend
        val isConnected = try {
            Socket(backendHost, backendPort).use { true }
        } catch (e: Exception) {
            false
        }

        assertTrue(isConnected, "Backend service should be reachable on port $backendPort")
    }
}
