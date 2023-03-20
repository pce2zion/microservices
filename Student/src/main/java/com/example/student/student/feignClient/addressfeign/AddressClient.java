package com.example.student.student.feignClient.addressfeign;

import com.example.student.student.dto.AddressDto;
import com.example.student.student.models.responsemodel.AddressResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "address-service",  url = "http://address-service" , path = "/address-app/api/")
public interface AddressClient {


    @GetMapping("/address/{studentId}")
    AddressDto getAddressById (@PathVariable String studentId);
}
