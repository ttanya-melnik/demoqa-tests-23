package tests;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import java.io.File;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationWithJavaFakerTests {

  @BeforeAll
  static void beforeAll() {
    Configuration.browserSize = "1920x1080"; // Делаем окно большим, чтобы ничего не съезжало
    Configuration.baseUrl = "https://demoqa.com"; // url сайта
    Configuration.pageLoadStrategy = "eager"; // Тесты запускаются быстрее
    Configuration.timeout = 5000; // Если элемент не появится за 5 секунд, то тест упадёт
    Configuration.holdBrowserOpen = true;  // После выполнения теста, браузер не закрывается автоматически

  }

  @Test
  void fillFormTest() {

   // Java Faker — библиотека для генерации фиктивных данных в Java.
    // Она позволяет создавать данные, которые имитируют реальные,
    // что помогает тестировать разные аспекты приложения без использования реальных производственных данных.


    // применяем Java-Faker
    Faker faker = new Faker();
     String firstName = faker.name().firstName(); // firstName: "Shonna"
     String lastName = faker.name().lastName(); // lastName: "Hansen"
     String userEmail = faker.internet().emailAddress(); //userEmail: "cecila.beahan@gmail.com"
     String streetAddress = faker.address().streetAddress(); // streetAddress: "109 Larry Circles"
     String userNumber = "79" + faker.number().digits(9);
     String userGender = "Female";
     String subjectsInput = "English";





    open("/automation-practice-form");
    $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    $("#firstName").setValue(firstName);
    $("#lastName").setValue(lastName);
    $("#userEmail").setValue(userEmail);
    $("#genterWrapper").$(byText(userGender)).click();
    $("#userNumber").setValue(userNumber);
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").selectOption("September");
    $(".react-datepicker__year-select").selectOption("2004");
    $(".react-datepicker__day--028").click();
    $("#subjectsInput").setValue(subjectsInput).pressEnter();
    $("#hobbies-checkbox-2").parent().click();
    $("#uploadPicture").uploadFile(new File("src/DataTest/first.jpeg"));
    $("#currentAddress").setValue(streetAddress);
    $("#state input").setValue("NCR").pressEnter();
    $("#city input").setValue("Delhi").pressEnter();
    $("#submit").click();
    $(".modal-content").should(appear);
    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    $(".table-responsive").shouldHave(text(firstName), text(lastName));
  }
}


