package org.example.abstraction.seviceImpl;

import jakarta.persistence.EntityNotFoundException;
import org.example.abstraction.sevice.UserService;
import org.example.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Override
	public UserDto getById(Long id) {
		return UserDto.fromDbEntity(userRepo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("User with id " + id + " not found")));
	}
}
