package com.example.demo.user;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import org.junit.jupiter.api.Test;

class UserRecordTest {

  public static final String EXPECTED_MESSAGE = "Provided age is not valid";

  @Test
  void createUser() {
    Exception exception =
        assertThrows(RuntimeException.class, () -> new UserRecord("Some Name", Gender.MALE, 10));
    String actualMessage = exception.getMessage();
    assertEquals(actualMessage, EXPECTED_MESSAGE);

    exception = assertThrows(RuntimeException.class, () -> new UserRecord(10));
    actualMessage = exception.getMessage();
    assertEquals(actualMessage, EXPECTED_MESSAGE);
  }

  @Test
  void deserializeUser() {
    String userAsJson =
        """
        {
          "fullName": "Some Other Name",
          "gender": "OTHER",
          "age": "8"
        }
        """;

    Exception exception =
        assertThrows(
            ValueInstantiationException.class,
            () -> new ObjectMapper().readValue(userAsJson, UserRecord.class));
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(EXPECTED_MESSAGE));
  }
}
