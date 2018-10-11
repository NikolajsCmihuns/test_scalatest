import org.scalatest.concurrent.TimeLimitedTests
import org.scalatest.time.{Seconds, Span}

class TimeLimitedSpec extends IntegrationSpec with TimeLimitedTests {

  "Custom error messages" must {

    "be preserved when test fails" in {
      eventually {
        assert(1 == 2, "My error message")
      }
    }
  }

  override def timeLimit: Span = Span(5, Seconds)

}
