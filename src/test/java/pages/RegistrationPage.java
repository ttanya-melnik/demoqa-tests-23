package pages;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.SelenideElement;
import java.io.File;
import pages.components.CalendarComponent;

public class RegistrationPage { // класс — Page Object


  public static SelenideElement firstNameInput =$("#firstName");
  public static SelenideElement lastNameInput =$("#lastName");
  public static SelenideElement userEmailInput =$("#userEmail");
  public static SelenideElement genderWrapper =$("#genterWrapper");
  public static SelenideElement userNumberInput =$("#userNumber");
  public static SelenideElement calendarInput =$("#dateOfBirthInput");
  public static SelenideElement checkResult =$(".table-responsive");
  public static SelenideElement subjectsInput =$("#subjectsInput");
  public static SelenideElement hobbiesCheckbox =$("#hobbies-checkbox-2");
  public static SelenideElement uploadPictureInput =$("#uploadPicture");
  public static SelenideElement currentAddressInput =$("#currentAddress");
  public static SelenideElement stateInput =$("#state input");
  public static SelenideElement cityInput =$("#city input");
  public static SelenideElement clickSubmit =$("#submit");
  public static SelenideElement checkModalContent =$(".modal-content");
  public static SelenideElement checkModalSizesTitleLg =$("#example-modal-sizes-title-lg");




  public RegistrationPage openPage() {
    open("/automation-practice-form"); // открыли страницу
    $(".practice-form-wrapper").shouldHave(text("Student Registration Form")); // нашли по тексту
    return this;
  }


  public RegistrationPage setFirstName(String value) { // set - бизнес-язык
    firstNameInput.setValue(value);
    return this;
  }

  public RegistrationPage setLastName(String value) {
    lastNameInput.setValue(value);
    return this;
  }

  public RegistrationPage setEmail(String value) {
    userEmailInput.setValue(value);
    return this;
  }

  public RegistrationPage setGender(String value) {
    genderWrapper.$(byText(value))
        .click();
    return this;
  }


  public RegistrationPage setNumber(String value) {
    userNumberInput.setValue(value);
    return this;  // данный метод не ведет на другую страницу, код становится более читаемым
  }


  CalendarComponent calendarComponent = new CalendarComponent();

  public RegistrationPage setDateOfBirth(String day, String month, String year) {
    calendarInput.click();
    calendarComponent.setDate(day, month, year);
    return this;
  }

  public RegistrationPage checkResult(String firstName, String lastName) {
    checkResult.shouldHave(text(firstName), text(lastName));
    return this;
  }
  public RegistrationPage setSubjects(String value) {
  subjectsInput.setValue(value).pressEnter();
  return this;
  }

  public RegistrationPage setHobbies() {
    hobbiesCheckbox.parent().click();
    return this;
  }

  public RegistrationPage UploadPicture(File file) {
    uploadPictureInput.uploadFile(file);
    return this;
  }
  public RegistrationPage setCurrentAddress(String value) {
    currentAddressInput.setValue(value);
    return this;
  }

  public RegistrationPage setState(String value) {
    stateInput.setValue(value).pressEnter();
    return this;
  }

  public RegistrationPage setCity(String value) {
    cityInput.setValue(value).pressEnter();
    return this;
  }

  public RegistrationPage clickSubmit() {
    clickSubmit.click();
    return this;
  }

  public RegistrationPage checkModalContent() {
    checkModalContent.should(appear);
    return this;
  }

  public RegistrationPage shouldHaveModalTitle(String expectedTitle) {
    checkModalSizesTitleLg.shouldHave(text(expectedTitle));
    return this;
  }
}





