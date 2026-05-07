package tests.practiceFormTests;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import java.io.File;

public class RegistrationPage { // класс — Page Object


  private SelenideElement firstNameInput = $("#firstName");
  private SelenideElement lastNameInput = $("#lastName");
  private SelenideElement userEmailInput = $("#userEmail");

  private SelenideElement genderWrapper = $("#genterWrapper");
  private SelenideElement userNumberInput = $("#userNumber");

  private SelenideElement subjectsInput = $("#subjectsInput");
  private SelenideElement hobbiesCheckbox = $("#hobbies-checkbox-2");
  private SelenideElement uploadPictureInput = $("#uploadPicture");
  private SelenideElement currentAddressInput = $("#currentAddress");
  private SelenideElement stateInput = $("#state input");
  private SelenideElement cityInput = $("#city input");
  private SelenideElement clickSubmit = $("#submit");


  public RegistrationPage openPage() {
    open("/automation-practice-form"); // открыли страницу
    $(".practice-form-wrapper").shouldHave(text("Student Registration Form")); // нашли по тексту
    return this;
  }


  public RegistrationPage setFirstAndLastnameAndEmail(String firstname, String lastname, String email) {
    firstNameInput.setValue(firstname);
    lastNameInput.setValue(lastname);
    userEmailInput.setValue(email);
    return this;
  }

  public RegistrationPage setGender(String value) {
    genderWrapper.$(byText(value))
        .click();
    return this;
  }


  public RegistrationPage userNumberInput(String value) {
    userNumberInput.setValue(value);
    return this;
  }


  public RegistrationPage setSubjects(String value) {
    subjectsInput.setValue(value)
        .pressEnter();
    return this;
  }

  public RegistrationPage setHobbies() {
    hobbiesCheckbox.parent()
        .click();
    return this;
  }

  public RegistrationPage UploadPicture(File file) {
    uploadPictureInput.uploadFile(file);
    return this;
  }

  public RegistrationPage currentAddressInput(String value) {
    currentAddressInput.setValue(value);
    return this;
  }

  public RegistrationPage stateInput(String value) {
    stateInput.setValue(value)
        .pressEnter();
    clickSubmit.click();
    return this;
  }

  public RegistrationPage cityInput(String value) {
    cityInput.setValue(value)
        .pressEnter();
    return this;
  }


}





