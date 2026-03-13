package tests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.TextBoxRegistration;

public class TextBoxRegistrationWithPageObject {

  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080"; // Делаем окно большим, чтобы ничего не съезжало
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.pageLoadStrategy = "eager"; // Тесты запускаются быстрее
    Configuration.timeout = 5000; // Если элемент не появится за 5 секунд, то тест упадёт
    Configuration.holdBrowserOpen = true;  // После выполнения теста, браузер не закрывается автоматически.

  }


  TextBoxRegistration textBoxRegistration = new TextBoxRegistration();
  @Test
  void fillFormTest() {
    textBoxRegistration.openPage();

    textBoxRegistration.setUserName("Alex")
        .setUserEmail("alex@egorov.com")
        .setCurrentAddress("Some street 1")
        .setPermanentAddress("Another street")
        .clickSubmit()
        .checkUserName("Alex")
        .checkUserEmail("alex@egorov.com")
        .checkCurrentAddress("Some street 1")
        .checkPermanentAddress("Another street");
  }
}


