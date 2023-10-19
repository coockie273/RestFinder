package org.example.server.abstraction.service;

import org.example.server.repository.User;

import java.util.List;
import java.util.Random;

public interface UserService {
	UserDto getById(Long id);

	Long addUser(AddUserDto addUserDto);

	UserDto signIn(SignInDto dto);

	List<String> showKeywordPreference(Long id);

	List<String> showKitchenPreference(Long id);

	List<String> showVisitedRestaraunts(Long id);

	record SignInDto(
			String login,
			String password
	){}

	record AddUserDto(
			Long id,
			String first_name,
			String second_name,

			String login,

			String password
	){
		public static User toDbEntity(AddUserDto addUserDto){
			return new User(
					addUserDto.id(),
					addUserDto.first_name(),
					addUserDto.second_name(),
					addUserDto.login(),
					addUserDto.password(),
					new Random().nextInt(35,60),
					new Random().nextInt(25,45)
			);
		}
	}


	record UserDto(
		Long id,
		String first_name,
		String second_name,
		String login,
		String password,

		int coordinates_x,

		int coordinates_y

	){
		public static UserDto fromDbEntity(User user){
			return new UserDto(
				user.getId(),
				user.getFirst_name(),
				user.getSecond_name(),
				user.getLogin(),
				user.getPassword(),
				user.getCoordinates_x(),
				user.getCoordinates_y()
			);
		}
	}
}
