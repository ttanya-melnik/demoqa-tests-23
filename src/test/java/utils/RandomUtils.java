package utils;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

  public static void main(String[] args) {
    System.out.println(getRandomString(10));
    System.out.println(getRandomEmail());
    System.out.println(getRandomAddress());
    System.out.println(getRandomInt(111, 99999999));
    System.out.println(getRandomNumber());
    System.out.println(getRandomGender());
    System.out.println(getRandomSubjectsInput());

  }


  public static String getRandomString(int len) {
    String AB = "123456789QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
    AB = "123456789QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
    SecureRandom rnd = new SecureRandom();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < len; i++) {
      sb.append(AB.charAt(rnd.nextInt(AB.length())));
    }
    return sb.toString();
  }


  public static String getRandomEmail() {
    return getRandomString(10) + "@qa.guru";
  }


  public static String getRandomAddress() {
    return getRandomString(10) + " " + getRandomString(10) + " " + getRandomString(10);
  }


  public static int getRandomInt(int min, int max) {
    return ThreadLocalRandom.current()
        .nextInt(min, max + 1);
  }

  // +8 (662) 533 - 21 - 40
  public static String getRandomNumber() {

    return String.format("+%s (%s) %s - %s - %s", getRandomInt(1, 9), getRandomInt(111, 999), getRandomInt(111, 999), getRandomInt(11, 99),
        getRandomInt(11, 99));
  }


  public static String getRandomGender() {

    String[] genders = {"Male", "Female", "Other"};
    return getRandomItemFormArray(genders);
  }

  public static String getRandomItemFormArray(String[] array) {
    int index = getRandomInt(0, array.length - 1);
    return array[index];
  }

  public static String getRandomSubjectsInput() {
    String[] subjects = {"English", "Maths", "Physics", "Chemistry", "History", "Biology", "Arts", "Commerce"};
    return subjects[new Random().nextInt(subjects.length)];

  }

}
