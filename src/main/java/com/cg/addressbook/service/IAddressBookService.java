package com.cg.addressbook.service;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import com.cg.addressbook.dto.AddressBookDTO;
import com.cg.addressbook.dto.LoginDTO;
import com.cg.addressbook.dto.UserDTO;
import com.cg.addressbook.model.AddressBookData;
import com.cg.addressbook.model.User;

public interface IAddressBookService {

	List<AddressBookData> getAddressBookContactData();

	AddressBookData getAddressBookContactDataById(Long id);

	AddressBookData createAddressBookContactData(AddressBookDTO addressBookDTO);

	AddressBookData updateAddressBookContactData(Long id, AddressBookDTO addressBookDTO);

	void deleteAddressBookContactData(Long id);

    User saveUser(@Valid UserDTO userDTO);

	Optional<User> loginByEmailAndPassword(LoginDTO loginDTO);
}