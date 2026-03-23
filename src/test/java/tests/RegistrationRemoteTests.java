package tests;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import java.io.File;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RegistrationRemoteTests {
  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080"; // Делаем окно большим, чтобы ничего не съезжало
    Configuration.baseUrl = "https://demoqa.com"; // url сайта
    Configuration.pageLoadStrategy = "eager"; // Тесты запускаются быстрее
    Configuration.timeout = 5000; // Если элемент не появится за 5 секунд, то тест упадёт
   //  Configuration.holdBrowserOpen = true;   После выполнения теста, браузер не закрывается автоматически
    // тест будет запускаться на удаленном сервере Selenoid
    Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";


    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("selenoid:options", Map.<String, Object>of(
        "enableVNC", true, // Включили живой просмотр экрана браузера через VNC.
        "enableVideo", true // Включили автоматическую запись видео всего теста
    ));
    Configuration.browserCapabilities = capabilities; // Передаёт эти фичи Selenide → Selenoid

    SelenideLogger.addListener("AllureSelenide", new AllureSelenide()); // Делает Allure-отчёт красивым
  }


  // После каждого теста в Allure будут отображаться:
  @AfterEach
  void addAttachments() {
    Attach.screenshotAs("Last screenshot"); // скриншот,
    Attach.pageSource(); // html-код страницы,
    Attach.browserConsoleLogs(); // логи консоли браузера,
    Attach.addVideo();  // видео выполнения теста

  }


    @Test
  @Tag("demoqa")
  void successfulRegistrationTest() {
    // метод "step" - делает шаги в тесте более читаемыми
    step("Open form", () -> {
      open("/automation-practice-form");
      $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    // executeJavaScript("$('#fixedban').remove()");
    // executeJavaScript("$('footer').remove()");
    });

      // метод "step" - делает шаги в тесте более читаемыми
      step("Fill form", () -> {
      $("#firstName").setValue("Tatiana");
      $("#lastName").setValue("Mel");
      $("#userEmail").setValue("tanya12345@gmail.com");
      $("#genterWrapper").$(byText("Female")).click();
      $("#userNumber").setValue("8900333111");
      $("#dateOfBirthInput").click();
      $(".react-datepicker__month-select").selectOption("September");
      $(".react-datepicker__year-select").selectOption("2004");
      $(".react-datepicker__day--028").click();
      $("#subjectsInput").setValue("English").pressEnter();
      $("#hobbies-checkbox-2").parent().click();
      $("#uploadPicture").uploadFile(new File("src/DataTest/dog.jpg"));
      $("#currentAddress").setValue("Some street 1");
      $("#state input").setValue("NCR").pressEnter();
      $("#city input").setValue("Delhi").pressEnter();
      $("#submit").click();
    });

      // метод "step" - делает шаги в тесте более читаемыми
      step("Verify results", () -> {
      $(".modal-content").should(appear);
      $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
      $(".table-responsive").shouldHave(text("Tatiana"), text("Mel"));
    });
  }
  }


