package tests.simple;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;



 @Tag("simple")
public class SkippedTests {


  @Test
  @Disabled
  void someTest() {
    assertTrue(false);
  }

  @Test
  @Disabled("Some reason")
  void someTest1() {
    assertTrue(false);
  }

}
