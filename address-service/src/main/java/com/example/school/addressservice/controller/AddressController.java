package com.example.school.addressservice.controller;

import com.example.school.addressservice.Service.AddressService;
import com.example.school.addressservice.dto.AddressDto;
import com.example.school.addressservice.models.requestmodel.AddressRequest;
import com.example.school.addressservice.models.responsemodel.AddressResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    AddressService addressService;

    @PostMapping ("/register")
    public ResponseEntity<AddressResponse> createAddress (@RequestBody AddressRequest addressRequest){
        AddressResponse addressResponse = new AddressResponse();

        AddressDto addressDto = new AddressDto();
        BeanUtils.copyProperties(addressRequest, addressDto);

       AddressDto createdAddress = addressService.createAddress(addressDto);
        BeanUtils.copyProperties(createdAddress, addressResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressResponse);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<AddressResponse> getAddressByStudentId (@PathVariable String studentId){
        AddressResponse addressResponse = new AddressResponse();

      AddressDto returnedAddress = addressService.getAddressByStudentId(studentId);
      modelMapper.map(returnedAddress, addressResponse);

      return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
    }
}
