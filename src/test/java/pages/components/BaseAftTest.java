package pages.components;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import tests.practiceFormTests.RegistrationPage;

public class BaseAftTest {


  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080"; // Делаем окно большим, чтобы ничего не съезжало
    Configuration.baseUrl = "https://demoqa.com"; // url сайта
    Configuration.pageLoadStrategy = "eager"; // Тесты запускаются быстрее
    Configuration.timeout = 5000; // Если элемент не появится за 5 секунд, то тест упадёт
    Configuration.holdBrowserOpen = true;  // После выполнения теста, браузер не закрывается автоматически

  }

  protected RegistrationPage registrationPage = new RegistrationPage();
  protected CalendarComponent calendarComponent = new CalendarComponent();
  protected ModalContent modalContent = new ModalContent();
}