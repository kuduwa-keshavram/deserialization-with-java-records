package com.example.demo.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
class UserController {
  @PostMapping("/create-with-class")
  UserClass create(@RequestBody UserClass user) {
    // Create User
    return user;
  }

  @PostMapping("/create-with-record")
  UserRecord create(@RequestBody UserRecord user) {
    // Create User
    return user;
  }
}
