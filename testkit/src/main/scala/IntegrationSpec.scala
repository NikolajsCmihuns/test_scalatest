import org.scalatest.{MustMatchers, WordSpec}
import org.scalatest.concurrent.Eventually
import org.scalatest.time.{Millis, Seconds, Span}

trait IntegrationSpec extends WordSpec with Eventually with MustMatchers {

  implicit override val patienceConfig: PatienceConfig = PatienceConfig(
    timeout = scaled(Span(2, Seconds)),
    interval = scaled(Span(500, Millis))
  )

}


