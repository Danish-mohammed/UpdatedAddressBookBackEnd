package com.cg.addressbook.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.addressbook.model.AddressBookData;

@Repository
public interface AddressBookRepository extends CrudRepository<AddressBookData, Long> {

}