package org.example.abstraction.serviceImpl;

import jakarta.persistence.EntityNotFoundException;
import org.example.abstraction.service.UserService;
import org.example.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Override
	public UserDto getById(Long id) {
		return UserDto.fromDbEntity(userRepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found")));
	}

	@Override
	public UserDto signIn(SignInDto dto) {
		return UserDto.fromDbEntity(userRepo.signIn(dto.login(), dto.password()));
	}

	@Override
	public Long addUser(AddUserDto addUserDto) {
		return userRepo.save(addUserDto.toDbEntity(addUserDto)).getId();
	}

	public List<String> showKeywordPreference(Long id){
		return userRepo.showKeywordPreferences(id);
	}

	public List<String> showKitchenPreference(Long id){
		return userRepo.showKitchenPreferences(id);
	}

	public List<String> showVisitedRestaraunts(Long id) {
		return userRepo.showVisitedRestaraunts(id);
	}
}
