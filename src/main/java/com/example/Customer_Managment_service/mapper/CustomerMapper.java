package com.example.Customer_Managment_service.mapper;

import com.example.Customer_Managment_service.dto.CustomerDto;
import com.example.Customer_Managment_service.model.Customer;

public class CustomerMapper {
    public static Customer CustomerDtoToCustomer(CustomerDto customerDto, Customer customer){
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        customer.setCity(customerDto.getCity());
        customer.setAddress(customerDto.getAddress());
        customer.setState(customerDto.getState());
        customer.setStreet(customerDto.getStreet());
        return customer;
    }
    public static CustomerDto CustomerToCustomerDto(Customer customer, CustomerDto customerDto){
        customerDto.setUuid(customer.getUuid());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhone(customer.getPhone());
        customerDto.setCity(customer.getCity());
        customerDto.setAddress(customer.getAddress());
        customerDto.setState(customer.getState());
        customerDto.setStreet(customer.getStreet());
        return customerDto;
    }
}
