package com.example.Customer_Managment_service.controller;

import com.example.Customer_Managment_service.dto.CustomerDto;
import com.example.Customer_Managment_service.model.Customer;
import com.example.Customer_Managment_service.sevice.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v0/customer",produces = {MediaType.APPLICATION_JSON_VALUE})
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/")
    public ResponseEntity<String> createCustomer(@RequestBody CustomerDto customerDto){
        customerService.createCustomer(customerDto);
        return new ResponseEntity<>("created customer", HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<CustomerDto>> getAllCustomer(){
         List<CustomerDto> customers=customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable String id){
        CustomerDto customerDto=customerService.getCustomerId(id);
        return ResponseEntity.ok(customerDto);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getCustomerPage(@RequestParam(defaultValue = "0") Integer pageNo,@RequestParam(defaultValue = "10") Integer pageSize){
        List<CustomerDto> customerDtos=customerService.getAllByPage(pageNo,pageSize);
        return ResponseEntity.ok(customerDtos);
    }
    @GetMapping("/search/n")
    public ResponseEntity<List<CustomerDto>> getByName(@RequestParam String name){
        List<CustomerDto> customers=customerService.getByName(name);
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/search/e")
    public ResponseEntity<List<CustomerDto>> getByEmail(@RequestParam String email){
        List<CustomerDto> customers=customerService.getByEmail(email);
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/search/c")
    public ResponseEntity<List<CustomerDto>> getByCity(@RequestParam String city) {
        List<CustomerDto> customers = customerService.getByCity(city);
        return ResponseEntity.ok(customers);
    }
    @GetMapping("/search/p")
    public ResponseEntity<List<CustomerDto>> getByPhone(@RequestParam String phone) {
        List<CustomerDto> customers = customerService.getByPhone(phone);
        return ResponseEntity.ok(customers);
    }
    @PutMapping("/")
    public ResponseEntity<String> updateCustomer(@RequestBody CustomerDto customerDto){
        Boolean isUpdated=customerService.updateCustomer(customerDto);
        if(isUpdated){
            return ResponseEntity.ok("updated successfully");
        }
        return new ResponseEntity<>("Some thing went wrong try later",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String id){
        customerService.deletCustomerById(id);
        return ResponseEntity.ok("deleted successfully");
    }
}
