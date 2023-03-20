package com.example.school.addressservice.Service;

import com.example.school.addressservice.dto.AddressDto;
import com.example.school.addressservice.models.requestmodel.AddressRequest;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {

    AddressDto createAddress(AddressDto addressDto);


    AddressDto getAddressByStudentId(String studentId);
}
