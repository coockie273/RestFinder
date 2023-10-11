package org.example.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.example.abstraction.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public record UserController(
	UserService userService
) {

	@GetMapping("/getUser/{id}")
	public UserService.UserDto findById(@PathVariable Long id) {
		return userService.getById(id);
	}

	@PostMapping("/singUp")
	public Long singUp(@RequestBody UserService.AddUserDto addUserDto) {return userService.addUser(addUserDto);}

	@PostMapping("/signIn")
	public Long signIn(@RequestBody UserService.SignInDto dto, HttpServletResponse response) {
		UserService.UserDto user = userService.signIn(dto);

		if (user != null) {
			// Создайте Cookie с ID пользователя
			Cookie userCookie = new Cookie("userId", String.valueOf(user.id()));

			// Установите дополнительные параметры куки
			userCookie.setMaxAge(3600); // Срок действия куки в секундах (здесь 1 час)
			userCookie.setPath("/");   // Путь, на котором кука доступна

			// Добавьте куку в HTTP-ответ
			response.addCookie(userCookie);
		}

		return user.id();
	}
}
