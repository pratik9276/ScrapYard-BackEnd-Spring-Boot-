
package com.app.springboot.scrapyard.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.springboot.scrapyard.Repository.RoleRepository;
import com.app.springboot.scrapyard.Repository.UserRepository;
import com.app.springboot.scrapyard.config.AppConstants;
import com.app.springboot.scrapyard.entity.Role;
import com.app.springboot.scrapyard.entity.User;
import com.app.springboot.scrapyard.exceptions.ResourceNotFoundException;
import com.app.springboot.scrapyard.payloads.UserDto;
import com.app.springboot.scrapyard.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
			
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepository.save(user);
		return this.userToDto(savedUser);
	}
	

	@Override
	@Transactional
	public  void deleteUser(Integer userId) {
		User user=this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));
		this.userRepository.delete(user);
	}

	@Override
	public UserDto updateUser(UserDto userDto,Integer userID) {
		User user = this.userRepository.findById(userID)
				.orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userID));

		user.setFname(userDto.getFname());
		user.setLname(userDto.getLname());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setPhoneNumber(userDto.getPhoneNumber());

		User updatedUser = this.userRepository.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);
		return userDto1;
	}
	
	@Override
	@Transactional
	public UserDto registerNewCustomer(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		
		Role role=this.roleRepository.findById(AppConstants.CUSTOMER_USER).get();
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		user.getRoles().add(role);
		
		User newUser=this.userRepository.save(user);
		
		
		return this.modelMapper.map(newUser, UserDto.class);
	}

	
	@Override
	@Transactional
	public UserDto registerNewCollector(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		// encoded the password
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		
		Role role=this.roleRepository.findById(AppConstants.COLLECTOR_USER).get();
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		user.getRoles().add(role);
		
		User newUser=this.userRepository.save(user);
		
		
		return this.modelMapper.map(newUser, UserDto.class);
	}
	
	@Override
	@Transactional
	public UserDto getUserById(Integer userId) {

		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));

		return this.userToDto(user);
	}
	
	public User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);

		// user.setId(userDto.getId());
		// user.setName(userDto.getName());
		// user.setEmail(userDto.getEmail());
		// user.setAbout(userDto.getAbout());
		// user.setPassword(userDto.getPassword());
		return user;
	}
	
	public UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}


	
}