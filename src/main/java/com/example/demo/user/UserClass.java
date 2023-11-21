package com.example.demo.user;

import java.util.Objects;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
class UserClass {
  String fullName;
  Gender gender;
  Integer age;

  UserClass(String fullName, Gender gender, Integer age) {
    validateAge(age);
    this.fullName = fullName;
    this.gender = gender;
    this.age = age;
  }

  private static void validateAge(Integer age) {
    if (Objects.isNull(age) || age < 18) {
      throw new RuntimeException("Provided age is not valid");
    }
  }
}
