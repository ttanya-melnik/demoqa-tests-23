package pages.components;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;


public class CalendarComponent {


  private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");


  public CalendarComponent dateOfBirthInput(String day, String month, String year) {
    dateOfBirthInput.setValue(day + " " + month + " " + year);
    return this;

  }


}
