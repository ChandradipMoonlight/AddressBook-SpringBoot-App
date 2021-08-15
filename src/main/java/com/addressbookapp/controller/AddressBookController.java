package com.addressbookapp.controller;

import com.addressbookapp.dto.AddressBookDTO;
import com.addressbookapp.dto.ResponseDTO;
import com.addressbookapp.entity.AddressBookEntity;
import com.addressbookapp.service.IAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class AddressBookController {

    @Autowired
    IAddressBookService addressBookService;

    /**
     * Purpose:- this method is used to add the data into the AddressBook System.
     *
     * @param addressBookDTO this is Object of AddressBookDTO class which holds the all
     *                        the information which is coming from the user end. that will pass as argument
     *                        in the service class method which will stor it in the Address Book
     *                         Database.
     * @return returns the response of the method.
     */

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAddressBookData(@RequestBody AddressBookDTO addressBookDTO) {
        AddressBookEntity addressBookEntity = addressBookService.createAddressBookData(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Address Book Data Successfully!", addressBookEntity);
        log.info("Inside createAddressBookData() Method of AddressBookController Class");
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    /**
     * Purpose: this method is used to retrieve all the information form the AddressBook Database.
     *
     * @return returns the all the data from the addressBook System.
     */
    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        log.info("Inside getAddressBookData() Method of AddressBookController Class");
        List<AddressBookEntity> addressBookEntityList = addressBookService.getAddressBookData();
        ResponseDTO responseDTO = new ResponseDTO("Fetched all AddressBook Data Successfully!!", addressBookEntityList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose: this method is used to fetch the data form the AddressBook System Related to the particular id.
     *
     * @param id this is id which is passed as path variable in the url to get fetch the data form the AddressBook
     *           System.
     * @return response of the method as information related to the that id.
     */

    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDTO> getAddressBookDataById(@PathVariable("id") int id) {
        AddressBookEntity addressBookEntityList = (AddressBookEntity) addressBookService.getAddressBookDataById(id);
        ResponseDTO responseDTO = new ResponseDTO("Data Fetched SuccessFully!", addressBookEntityList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose: This method is used to update the existing data related to particular id.
     *
     * @param id this id is passed as path variable into the url which will help to update the data related to this id.
     *
     * @param addressBookDTO this is Object of the AddressBookDTO class. which will Store the updated data into
     *                       the AddressBook System. that data is coming form the user end.
     * @return returns the response of the method as updated data.
     */

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddressBookDataById(@PathVariable("id") int id,
                                                                 @RequestBody AddressBookDTO addressBookDTO) {
        AddressBookEntity addressBookEntity = addressBookService.updateAddressBookDataById(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Successfully", addressBookEntity);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose: - This is used to delete the data form the Address book system related to the particular id only.
     *
     * @param id this id is passed as path variable into the variable which helps to delete the data related to
     *           that id from the AddressBook System.
     * @return returns the message that data is deleted Successfully and data as null.
     */

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddressBookDataById(@PathVariable("id") int id) {
        AddressBookEntity addressBookEntity = addressBookService.deleteAddressBookById(id);
        ResponseDTO responseDTO = new ResponseDTO("Data Deleted Successfully!!", addressBookEntity);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
