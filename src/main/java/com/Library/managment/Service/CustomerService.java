package com.Library.managment.Service;

import com.Library.managment.Model.Customer;
import com.Library.managment.Repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }
}
