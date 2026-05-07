package tests.practiceFormTests;

import java.io.File;
import org.junit.jupiter.api.Test;
import pages.components.BaseAftTest;


public class RegistrationWithPageObjectsTests extends BaseAftTest {


  @Test
  void fillFormTest() {
    registrationPage.openPage();

    registrationPage.setFirstAndLastnameAndEmail("Tatiana", "Mel", "test12345@gmail.com")
        .setGender("Female")
        .userNumberInput("8900333111");
    calendarComponent.dateOfBirthInput("28", "September", "2004");
    registrationPage.setSubjects("English")
        .setHobbies()
        .UploadPicture(new File("src/DataTest/dog.jpg"))
        .currentAddressInput("Some street 1")
        .stateInput("NCR")
        .cityInput("Delhi");
    modalContent.checkModalContent();


  }
}


