class WithoutTimeLimitSpec extends IntegrationSpec {

  "Custom error messages" must {

    "be preserved when test fails" in {
      eventually {
        assert(1 == 2, "My error message")
      }
    }
  }
}
