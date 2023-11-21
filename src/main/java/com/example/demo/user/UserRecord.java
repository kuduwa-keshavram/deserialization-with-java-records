package com.example.demo.user;

import java.util.Objects;

record UserRecord(String fullName, Gender gender, Integer age) {
  UserRecord {
    if (Objects.isNull(age) || age < 18) {
      throw new RuntimeException("Provided age is not valid");
    }
  }

  UserRecord(Integer age) {
    this("Some Full Name", Gender.OTHER, age);
  }
}
