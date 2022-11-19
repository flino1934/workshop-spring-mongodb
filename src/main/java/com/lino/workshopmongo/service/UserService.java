package com.lino.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lino.workshopmongo.dto.UserDTO;
import com.lino.workshopmongo.entity.User;
import com.lino.workshopmongo.repository.UserRepository;
import com.lino.workshopmongo.service.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {

		return userRepository.findAll();

	}

	public User findById(String id) {

		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}

	public User insert(User user) {

		return userRepository.insert(user);

	}

	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);

	}

	public User update(User user) {
		User updateUser = findById(user.getId());
		updateData(updateUser, user);
		return userRepository.save(updateUser);

	}

	private void updateData(User updateUser, User user) {

		updateUser.setName(user.getName());
		updateUser.setEmail(user.getEmail());

	}

	public User fromDTO(UserDTO userDTO) {

		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());

	}

}
