package helpers;

import static com.codeborne.selenide.Selenide.sessionId;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Attach {


  /* "screenshotAs" - Делает скриншот всего окна браузера прямо в момент вызова.
     Возвращает байты картинки (png).
     Allure благодаря @Attachment автоматически кладёт этот скрин в отчёт с именем, которое передали
     Полезно: всегда видно, как выглядела страница в момент падения или в конце теста. */
  @Attachment(value = "{attachName}", type = "image/png")
  public static byte[] screenshotAs(String attachName) {
    return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
  }


  /* "pageSource" - Берёт весь HTML-код страницы (как "Просмотреть код страницы" в браузере).
     Прикрепляет его как текстовый файл в Allure. */
  @Attachment(value = "Page source", type = "text/plain")
  public static byte[] pageSource() {
    return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
  }


 // "attachAsText" - Крепит любой текст (логи, JSON, сообщение об ошибке и т.д.).
  @Attachment(value = "{attachName}", type = "text/plain")
  public static String attachAsText(String attachName, String message) {
    return message;
  }


/* "browserConsoleLogs" - Собирает все сообщения из консоли браузера за время сессии.
   Selenide умеет их получать через getWebDriverLogs(LogType.BROWSER).
   Прикрепляет как текст "Browser console logs". */
  public static void browserConsoleLogs() {
    attachAsText(
        "Browser console logs",
        String.join("\n", Selenide.getWebDriverLogs(BROWSER))
    );
  }


/* Selenoid (удалённый сервер, где запускаются браузеры) умеет записывать видео выполнения каждого теста.
   Видео сохраняется по адресу:
   https://selenoid.autotests.cloud/video/<sessionId>.mp4
   где sessionId() — уникальный ID текущей сессии браузера (Selenide его знает).
   Но Allure не умеет напрямую прикреплять внешние видео-файлы как видео.
   Поэтому хитрость: прикрепляем маленький HTML-файл, внутри которого лежит тег <video src="...">.
   Когда ты открываешь отчёт Allure →
   нажимаешь на attachment "Video" → браузер открывает этот HTML →
   и сразу показывает видео с сервера Selenoid */
  @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
  public static String addVideo() {
    return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
        + getVideoUrl()
        + "' type='video/mp4'></video></body></html>";
  }

  public static URL getVideoUrl() {
    String videoUrl = "https://selenoid.autotests.cloud/video/" + sessionId() + ".mp4";
    try {
      return new URL(videoUrl);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return null;
  }

}
