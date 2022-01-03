package com.cg.addressbook.controller;

import java.util.Optional;

import javax.validation.Valid;

import com.cg.addressbook.dto.AddressBookDTO;
import com.cg.addressbook.dto.LoginDTO;
import com.cg.addressbook.dto.ResponseDTO;
import com.cg.addressbook.dto.UserDTO;
import com.cg.addressbook.model.User;
import com.cg.addressbook.service.IAddressBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:3001" })
@RestController
@RequestMapping(value = "/addressbookservice")
@Slf4j
public class AddressBookController {

	@Autowired
	private IAddressBookService addressBookService;

	
	@GetMapping(value = { "/getall" })
	public ResponseEntity<ResponseDTO> getAddressBookContactData() {
		ResponseDTO responseDTO = new ResponseDTO("Get Call Successful",
				addressBookService.getAddressBookContactData());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	
	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseDTO> getAddressBookContactData(@PathVariable("id") Long id) {
		ResponseDTO responseDTO = new ResponseDTO("Get Call Successfull for id: " + id, 
				addressBookService.getAddressBookContactDataById(id));
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookContactData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
		log.debug(addressBookDTO.toString());
		ResponseDTO responseDTO = new ResponseDTO("Created Address Book Contact Data Successfully",
				addressBookService.createAddressBookContactData(addressBookDTO));
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
	}

	@PostMapping("/user")
    public ResponseEntity<ResponseDTO> saveUser(@Valid @RequestBody UserDTO userDTO) {
        ResponseDTO responseDTO = new ResponseDTO("User Created.", addressBookService.saveUser(userDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }

	
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateAddressBookContactData(@PathVariable("id") Long id,
			@Valid @RequestBody AddressBookDTO addressBookDTO) {
		ResponseDTO responseDTO = new ResponseDTO("Updated Address Book Contact Data Successfully", 
				addressBookService.updateAddressBookContactData(id, addressBookDTO));
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddressBookContactData(@PathVariable("id") Long id) {
		addressBookService.deleteAddressBookContactData(id);
		ResponseDTO responseDTO = new ResponseDTO("Deleted Address Book Contact Data Successfully",
				"Deleted id: " + id);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/login")
    public ResponseEntity<ResponseDTO> loginByEmailAndPassword(@RequestBody LoginDTO loginDTO) {
		Optional<User> login = addressBookService.loginByEmailAndPassword(loginDTO);
		if (login != null) {
            ResponseDTO dto = new ResponseDTO("User login successfully:", login.get().getFirstName());
            return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
        } else {
            ResponseDTO dto = new ResponseDTO("User login not successfully:", login);
            return new ResponseEntity<>(dto, HttpStatus.ACCEPTED);
        }
    }
}