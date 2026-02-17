package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

@Data
@AllArgsConstructor
public class Shop {
    private String name;
    private Map<Integer, Product> productsById;
    private TreeSet<Customer> customers;

    public Customer findCustomerByNif(String nif){
        for (Customer c : customers){
            if (c.isCustomer(nif)){
                return c;
            }
        }
        return null;
    }

    public Order findOrder(int id, String nif){
        Customer c = findCustomerByNif(nif);
        if (c != null){
            return c.findOrder(id);
        }
        return null;
    }

    public List<Product> getProducts(String tag){
        List<Product> products = new ArrayList<>();
        for (Product p : productsById.values()){
            if (p.isProduct(tag)){
                products.add(p);
            }
        }
        return products;
    }

    public double totalSpend(String nif){
        return findCustomerByNif(nif).totalSpend();
    }
}
