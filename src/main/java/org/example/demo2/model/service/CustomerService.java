package org.example.demo2.model.service;

import org.example.demo2.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService {
//    Bieu dien logic nghiep vu
    private static Map<Integer, Customer> customerMap = new HashMap<>();
    static {
        customerMap.put(1, new Customer("Le Dang Phap", "12/4/2001", "Da Nang"));
        customerMap.put(2, new Customer("Huynh Tran Thanh Dung", "12/4/2001", "Da Nang"));
    }
// tra ve danh sach
    public List<Customer> findAll(){
        return new ArrayList<>(customerMap.values());
    }

    public void save(Customer customer){
        customerMap.put(customerMap.size()+1, customer);
    }
}
