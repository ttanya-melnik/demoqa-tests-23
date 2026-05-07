package tests.simple;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.SelenideElement;



public class TextBoxRegistration {



 public static SelenideElement userNameInput = $("#userName");
 public static SelenideElement userEmailInput = $("#userEmail");
 public static SelenideElement currentAddressInput = $("#currentAddress");
 public static SelenideElement permanentAddressInput = $("#permanentAddress");
 public static SelenideElement submitClick = $("#submit");
 public static SelenideElement checkUserName =$("#name");
 public static SelenideElement checkUserEmail =$("#email");
 public static SelenideElement checkCurrentAddress =$("#output #currentAddress");
 public static SelenideElement checkPermanentAddress =$("#output #permanentAddress");




 public TextBoxRegistration openPage() {
   open("/text-box");
   return this;
 }

 public TextBoxRegistration setUserName(String value) {
   userNameInput.setValue(value);
   return this;
 }

 public TextBoxRegistration setUserEmail(String value) {
   userEmailInput.setValue(value);
   return this;
 }

 public TextBoxRegistration setCurrentAddress(String value) {
   currentAddressInput.setValue(value);
   return this;
 }
 public TextBoxRegistration setPermanentAddress(String value) {
   permanentAddressInput.setValue(value);
   return this;
 }

 public TextBoxRegistration clickSubmit() {
   submitClick.click();
   return this;
 }

 public TextBoxRegistration checkUserName(String userName) {
   checkUserName.shouldHave(text(userName));
   return this;
 }

 public TextBoxRegistration checkUserEmail(String userEmail) {
   checkUserEmail.shouldHave(text(userEmail));
   return this;
 }

 public TextBoxRegistration checkCurrentAddress(String currentAddress) {
   checkCurrentAddress.shouldHave(text(currentAddress));
   return this;
 }

 public TextBoxRegistration checkPermanentAddress (String permanentAddress) {
   checkPermanentAddress.shouldHave(text(permanentAddress));
   return this;
 }
}
