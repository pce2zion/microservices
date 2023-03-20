package com.example.school.addressservice.repository;

import com.example.school.addressservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findByAddressId(String addressId);
}
