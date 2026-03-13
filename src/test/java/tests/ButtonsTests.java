package tests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ButtonsTests {

  @BeforeAll
  static void beforeAll() { // void - не возвращает значения
    Configuration.browserSize = "1920x1080"; // Делаем окно большим, чтобы ничего не съезжало
    Configuration.baseUrl = "https://demoqa.com"; // url сайта
    Configuration.pageLoadStrategy = "eager"; // Тесты запускаются быстрее
    Configuration.timeout = 5000; // Если элемент не появится за 5 секунд, то тест упадёт
    Configuration.holdBrowserOpen = true;  // После выполнения теста, браузер не закрывается автоматически
  }


  @Test
  void testButtons() {
    // открыть сайт
    open("https://demoqa.com/buttons");

    // проверить отображение заголовка "Buttons"
   $("h1").shouldHave(text("Buttons"));

    // двойной клик на кнопку 1
    $("#doubleClickBtn").doubleClick();

    // клик на кнопку 2 (правой кнопкой мыши)
    $("#rightClickBtn").contextClick();

    // клик на кнопку 3
    Selenide.$(By.xpath("//button[text()='Click Me']"));

  }

}
