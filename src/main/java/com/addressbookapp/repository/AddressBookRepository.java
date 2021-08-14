package com.addressbookapp.repository;

import com.addressbookapp.entity.AddressBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBookEntity, Integer> {
}
