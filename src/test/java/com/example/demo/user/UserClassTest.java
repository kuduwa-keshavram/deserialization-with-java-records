package com.example.demo.user;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

class UserClassTest {

  @Test
  void createUser() {
    String expectedMessage = "Provided age is not valid";
    Exception exception =
        assertThrows(RuntimeException.class, () -> new UserClass("Some Name", Gender.MALE, 10));

    String actualMessage = exception.getMessage();
    assertEquals(actualMessage, expectedMessage);
  }

  @Test
  void deserializeUser() {
    String userAsJson =
        """
        {
          "fullName": "Some Other Name",
          "gender": "FEMALE",
          "age": "8"
        }
        """;

    assertDoesNotThrow(
        () -> {
          UserClass userClass = new ObjectMapper().readValue(userAsJson, UserClass.class);
          System.out.println("Full Name: " + userClass.getFullName());
          System.out.println("Gender: " + userClass.getGender());
          System.out.println("Age: " + userClass.getAge());
        });
  }
}
