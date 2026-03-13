package tests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CheckBoxTests {

  @BeforeAll
  static void beforeAll() { // void - не возвращает значения
    Configuration.browserSize = "1920x1080"; // Делаем окно большим, чтобы ничего не съезжало
    Configuration.baseUrl = "https://demoqa.com"; // url сайта
    Configuration.pageLoadStrategy = "eager"; // Тесты запускаются быстрее
    Configuration.timeout = 5000; // Если элемент не появится за 5 секунд, то тест упадёт
    Configuration.holdBrowserOpen = true;  // После выполнения теста, браузер не закрывается автоматически
  }

  @Test
  void testCheckBox() {
    // открыть сайт
    open("https://demoqa.com/checkbox");

    // проверить заголовок
   $("h1").shouldHave(text("Check Box"));

    // клик на кнопку «Home»
    $(".rc-tree-checkbox").click();

    // проверка иконки expand (стрелка вправо)
    $("button[aria-label='Toggle']").click();

    // клик на кнопку Expand all "+"
    $("button[aria-label='Expand all']").click();

    // клик на кнопку Collapse all "-"
    $("button[aria-label='Collapse all']").click();

  }
}
