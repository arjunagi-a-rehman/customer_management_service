package com.example.Customer_Managment_service.controller;

import com.example.Customer_Managment_service.model.Customer;
import com.example.Customer_Managment_service.sevice.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v0/customer",produces = {MediaType.APPLICATION_JSON_VALUE})
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
        return new ResponseEntity<>("created customer", HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<Customer>> getAllCustomer(){
         List<Customer> customers=customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id){
        Customer customer=customerService.getCustomerId(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomerPage(@RequestParam(defaultValue = "0") Integer pageNo,@RequestParam(defaultValue = "10") Integer pageSize){
        List<Customer> customers=customerService.getAllByPage(pageNo,pageSize);
        return ResponseEntity.ok(customers);
    }
    @GetMapping("/search/n")
    public ResponseEntity<List<Customer>> getByName(@RequestParam String name){
        List<Customer> customers=customerService.getByName(name);
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/search/e")
    public ResponseEntity<List<Customer>> getByEmail(@RequestParam String email){
        List<Customer> customers=customerService.getByEmail(email);
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/search/c")
    public ResponseEntity<List<Customer>> getByCity(@RequestParam String city) {
        List<Customer> customers = customerService.getByCity(city);
        return ResponseEntity.ok(customers);
    }
    @GetMapping("/search/p")
    public ResponseEntity<List<Customer>> getByPhone(@RequestParam String phone) {
        List<Customer> customers = customerService.getByPhone(phone);
        return ResponseEntity.ok(customers);
    }
    @PutMapping("/")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer){
        Boolean isUpdated=customerService.updateCustomer(customer);
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
