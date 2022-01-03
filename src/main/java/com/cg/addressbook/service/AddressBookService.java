package com.cg.addressbook.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.addressbook.dto.AddressBookDTO;
import com.cg.addressbook.dto.LoginDTO;
import com.cg.addressbook.dto.UserDTO;
import com.cg.addressbook.exceptions.AddressBookException;
import com.cg.addressbook.model.AddressBookData;
import com.cg.addressbook.model.User;
import com.cg.addressbook.repository.AddressBookRepository;
import com.cg.addressbook.repository.UserLoginRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressBookService implements IAddressBookService {

	@Autowired
	private AddressBookRepository addressBookRepository;

	@Autowired
	private UserLoginRepository userLoginRepository;

	@Override
	public List<AddressBookData> getAddressBookContactData() {
		return (List<AddressBookData>) addressBookRepository.findAll();
	}

	@Override
	public AddressBookData getAddressBookContactDataById(Long id) {		
			AddressBookData contactData = addressBookRepository.findById(id)
											.orElseThrow(() -> new AddressBookException("Address Book Contact Not Found"));
			return contactData;	
	}

	@Override
	public AddressBookData createAddressBookContactData(AddressBookDTO addressBookDTO) {		
		AddressBookData contactData = null;
		contactData = new AddressBookData(addressBookDTO);
		log.debug("AddressBookData"+contactData.toString());
		return addressBookRepository.save(contactData);
	}

	@Override
	public AddressBookData updateAddressBookContactData(Long id, AddressBookDTO addressBookDTO) {
		AddressBookData contactData = this.getAddressBookContactDataById(id);
		BeanUtils.copyProperties(addressBookDTO, contactData);
		return addressBookRepository.save(contactData);
	}

	@Override
	public void deleteAddressBookContactData(Long id) {
		if(this.getAddressBookContactDataById(id) != null)
			addressBookRepository.deleteById(id);
	}

	@Override
	public User saveUser(@Valid UserDTO userDTO) {
		User userData= new User(userDTO);
		return userLoginRepository.save(userData);
	}

	@Override
	public Optional<User> loginByEmailAndPassword(LoginDTO loginDTO) {
		Optional<User> userLogin = userLoginRepository.findByEmailIdAndPassword(loginDTO.email, loginDTO.password);
		log.info("User Data",userLogin);
		if (userLogin.isPresent()) {
            log.info("user logged in successfully");
            return userLogin;
        } else {
            log.error("User not Found Exception:");
            return null;
        }
	}
}