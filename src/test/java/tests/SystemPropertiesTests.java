package tests;

import static java.lang.String.format;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
  @Test
  void systemPropertiesTest() { // получает свойство с именем browser
    String browser = System.getProperty("browser"); // получает свойство с именем browser

    System.out.println(browser); // null
  }

  @Test
  void systemProperties1Test() {
    System.setProperty("browser", "chrome"); // set - установили свойства внутри теста
    String browser = System.getProperty("browser"); // получаем свойство с заданным именем

    System.out.println(browser); // chrome
  }

  @Test
  void systemProperties2Test() {
    // Если свойство "browser" найдено — возвращает его значение.
    // Если не найдено — возвращает "mozilla"
    String browser = System.getProperty("browser", "mozilla");

    System.out.println(browser); // mozilla
  }

  @Test
  void systemProperties3Test() {
    // ставим значение перед чтением → всегда будет "chrome"
    System.setProperty("browser", "chrome");
    String browser = System.getProperty("browser", "mozilla");

    System.out.println(browser); // chrome
  }


  // как передавать свойства при запуске тестов через Gradle:
  @Test
  @Tag("property")
  void systemProperties4Test() {
    String browser = System.getProperty("browser", "mozilla");

    System.out.println(browser);
    // gradle property_test, вывод - "mozilla"

    // gradle property_test -Dbrowser=opera, вывод - "opera"

  }

  // передаем имя с пробелом
  @Test
  @Tag("hello")
  void systemProperties5Test() {
    String name = System.getProperty("name", "default student");
    String message = format("Hello, %s!", name);

    System.out.println(message);
    // ./gradlew hello_test
    // Hello, default student!

// Это НЕ сработает
    // ./gradlew hello_test -Dname=Tatiana Mel
    // Вывод: BUILD FAILED: Task 'Mel' not found in root project 'tests-demoqa.com'.

// Это сработает
    // ./gradlew hello_test -Dname="Tatiana Mel"
    // ./gradlew hello_test "-Dname="Tatiana Mel"
    // Вывод: Hello, Tatiana Mel!

  }

}
