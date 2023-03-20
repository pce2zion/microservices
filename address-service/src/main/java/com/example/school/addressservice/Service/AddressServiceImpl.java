package com.example.school.addressservice.Service;

import com.example.school.addressservice.dto.AddressDto;
import com.example.school.addressservice.entity.Address;
import com.example.school.addressservice.models.requestmodel.AddressRequest;
import com.example.school.addressservice.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Random;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService{

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public AddressDto createAddress(AddressDto addressDto) {
        AddressDto returnValue = new AddressDto();
        Address createdAddress = new Address();
        modelMapper.map(addressDto, createdAddress);
        Random random = new Random();
        createdAddress.setAddressId("mu" + random.nextInt(10));
       addressRepository.save(createdAddress);
        modelMapper.map(createdAddress, returnValue);
        log.info("Address created");
        return null;
    }

    @Override
    public AddressDto getAddressByStudentId(String studentId) {
        AddressDto addressDto = new AddressDto();
        Address address = addressRepository.findByAddressId(studentId);
        BeanUtils.copyProperties(address, addressDto);
        log.info("single address found by addressId");
        return null;
    }



}
