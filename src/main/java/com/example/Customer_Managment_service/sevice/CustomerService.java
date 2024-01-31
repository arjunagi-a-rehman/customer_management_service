package com.example.Customer_Managment_service.sevice;

import com.example.Customer_Managment_service.dto.CustomerDto;
import com.example.Customer_Managment_service.mapper.CustomerMapper;
import com.example.Customer_Managment_service.model.Customer;
import com.example.Customer_Managment_service.repo.ICustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService {
    private ICustomerRepo customerRepo;

    public void createCustomer(CustomerDto customerDto) {
        customerRepo.save(CustomerMapper.CustomerDtoToCustomer(customerDto,new Customer()));
    }

    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers=customerRepo.findAll();
        return customers.stream().
                map(customer -> CustomerMapper.CustomerToCustomerDto(customer,new CustomerDto())).
                collect(Collectors.toList());
    }

    public CustomerDto getCustomerId(String id) {
        return CustomerMapper.CustomerToCustomerDto(customerRepo.findById(id).orElseThrow(),new CustomerDto());
    }

    public Boolean updateCustomer(CustomerDto customerDto) {
        Customer currentCustomer=customerRepo.findById(customerDto.getUuid()).orElseThrow();
        CustomerMapper.CustomerDtoToCustomer(customerDto,currentCustomer);
        customerRepo.save(currentCustomer);
        return true;
    }

    public void deletCustomerById(String id) {
        customerRepo.delete(customerRepo.findById(id).orElseThrow());
    }

    public List<CustomerDto> getAllByPage(Integer pageNo, Integer pageSize) {
        Pageable paging= PageRequest.of(pageNo,pageSize);
        Page<Customer> customerPage=customerRepo.findAll(paging);
        if(customerPage.hasContent())return customerPage.getContent().stream().map(customer -> CustomerMapper.CustomerToCustomerDto(customer,new CustomerDto())).collect(Collectors.toList());

        return new ArrayList<>();
    }

    public List<CustomerDto> getByName(String name) {
        return customerRepo.findByFirstName(name).stream().map(customer -> CustomerMapper.CustomerToCustomerDto(customer,new CustomerDto())).collect(Collectors.toList());
    }

    public List<CustomerDto> getByEmail(String email) {
        return customerRepo.findByEmail(email).stream().map(customer -> CustomerMapper.CustomerToCustomerDto(customer,new CustomerDto())).collect(Collectors.toList());
    }

    public List<CustomerDto> getByCity(String city) {
        return customerRepo.findByCity(city).stream().map(customer->CustomerMapper.CustomerToCustomerDto(customer,new CustomerDto())).collect(Collectors.toList());
    }

    public List<CustomerDto> getByPhone(String phone) {
    return customerRepo.findByPhone(phone).stream().map(customer -> CustomerMapper.CustomerToCustomerDto(customer,new CustomerDto())).collect(Collectors.toList());
    }
}
