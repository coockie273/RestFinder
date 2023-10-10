package org.example.abstraction.sevice;

import org.example.repository.User;
import org.example.repository.UserRepo;

public interface UserService {
	UserDto getById(Long id);

	record UserDto(
		Long id,
		String first_name,
		String second_name,
		String login,
		String password

	){
		public static UserDto fromDbEntity(User user){
			return new UserDto(
				user.getId(),
				user.getFirst_name(),
				user.getSecond_name(),
				user.getLogin(),
				user.getPassword()
			);
		}
	}
}
