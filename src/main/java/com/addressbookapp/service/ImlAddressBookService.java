package com.addressbookapp.service;

import com.addressbookapp.builder.AddressBookBuilder;
import com.addressbookapp.constant.ExceptionConstants;
import com.addressbookapp.dto.AddressBookDTO;
import com.addressbookapp.entity.AddressBookEntity;
import com.addressbookapp.exception.CustomException;
import com.addressbookapp.repository.AddressBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImlAddressBookService implements IAddressBookService{

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    private AddressBookBuilder addressBookBuilder;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Purpose: Method to add the data to the AddressBook System.
     *
     * @param addressBookDTO This is an Object of the AddressBookDTO Class Which is passed from the controller which
     *                       holds all information which will user pass.
     * @return returns the response of the contains which response of the method.
     */

    @Override
    public AddressBookEntity createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookEntity addressBookEntity = addressBookBuilder.buildDO(addressBookDTO);
        return addressBookRepository.save(addressBookEntity);
    }

    /**
     * Purpose: This method is used to retrieve all the data from the database.
     *
     * @return return all the data from the database when get invoked.
     */
    @Override
    public List<AddressBookEntity> getAddressBookData() {
        return addressBookRepository.findAll().stream()
                .map(addressBookEntity -> modelMapper.map(addressBookEntity, AddressBookEntity.class))
                .collect(Collectors.toList());
    }

    /**
     * Purpose: This method is used to update the existing particular data of the AddressBook
     *          System with the help of id.
     *
     * @param id this is parameter is use update the information in the addressBook System for that particular id.
     *           Which is passed as path variable.
     *
     * @param addressBookDTO this is the Object of the AddressBookDTO Class which is passed form the  controller Class.
     *                       Which hold all the information which user will update.
     * @return returns Response of the method when it gets invoked.
     */

    @Override
    public AddressBookEntity updateAddressBookDataById(int id,
                                                       AddressBookDTO addressBookDTO) {
        AddressBookEntity addressBookEntity = addressBookRepository.findById(id)
                .orElseThrow(() -> new CustomException(ExceptionConstants.ID_NOT_FOUND.getMessage()));
        BeanUtils.copyProperties(addressBookDTO, addressBookEntity);
        addressBookRepository.save(addressBookEntity);
        return addressBookEntity;

//        if (Objects.nonNull(addressBookDTO.getName()) &&
//                !"".equalsIgnoreCase(addressBookDTO.getName())) {
//            addressBookEntity.setName(addressBookDTO.getName());
//        }
//
//        if (Objects.nonNull(addressBookDTO.getAddress()) &&
//                !"".equalsIgnoreCase(addressBookDTO.getAddress())) {
//            addressBookEntity.setAddress(addressBookDTO.getAddress());
//        }
//
//        if (Objects.nonNull(addressBookDTO.getCity()) &&
//                !"".equalsIgnoreCase(addressBookDTO.getCity())) {
//            addressBookEntity.setCity(addressBookDTO.getCity());
//        }
//
//        if (Objects.nonNull(addressBookDTO.getState()) &&
//             !"".equalsIgnoreCase(addressBookDTO.getState())) {
//            addressBookEntity.setState(addressBookDTO.getState());
//        }
//
//        if (Objects.nonNull(addressBookDTO.getZip()) &&
//                !"".equalsIgnoreCase(addressBookDTO.getZip()))
//            addressBookEntity.setZip(addressBookDTO.getZip());
//
//        if (Objects.nonNull(addressBookDTO.getEmail()) &&
//                !"".equalsIgnoreCase(addressBookDTO.getEmail()))
//        addressBookEntity.setEmail(addressBookDTO.getEmail());
//
//
//        if (Objects.nonNull(addressBookDTO.getPhoneNo()) &&
//                !"".equalsIgnoreCase(addressBookDTO.getPhoneNo()))
//        addressBookEntity.setPhoneNo(addressBookDTO.getPhoneNo());

//        return addressBookRepository.save(addressBookEntity);
    }

    /**
     * Purpose: This method is used to delete the particular data related to the id only form the
     *              addressBook Database.
     * @param id this id used to delete the data related for it, which is passed form the controller class. which is
     *           hold the information.
     * @return returns message as data deleted successfully and data as null.
     */
    @Override
    public AddressBookEntity deleteAddressBookById(int id) {
        addressBookRepository.deleteById(id);
        return null;
    }

    /**
     * Purpose: This is the method which is used to retrieve the data from the AddressBook DataBase
     *          Related to the particular id.
     * @param id this id is passed as path variable form the controller which is primary key in
     *           addressBook database
     * @return returns the response from of the method as data related to that id.
     */
    @Override
    public AddressBookEntity getAddressBookDataById(int id) {
        return addressBookRepository.findById(id).get();
    }
}