package com.addressbookapp.dto;

import com.addressbookapp.entity.AddressBookEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {
    private String message;
    private Object data;

}
