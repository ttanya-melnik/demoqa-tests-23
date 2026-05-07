package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;


public class ModalContent {

  private SelenideElement checkModalContent = $(".modal-content");


  public ModalContent checkModalContent() {
    checkModalContent.shouldBe(appear);
    return this;

  }


}
