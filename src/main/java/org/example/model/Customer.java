package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Customer implements Comparable<Customer>{
    private String nif;
    private String name;
    private String surname;
    private List<Order> orders;

    @Override
    public int compareTo(Customer customer) {
        int compare = surname.compareTo(customer.surname);
        if (compare == 0){
            compare = name.compareTo(customer.name);
            if (compare == 0){
                compare = nif.compareTo(customer.nif);
            }
        }
        return compare;
    }

    public boolean isCustomer(String nif){
        return this.nif.equals(nif);
    }

    public Order findOrder(int id){
        for (Order o : orders){
            if (o.isOrder(id)){
                return o;
            }
        }
        return null;
    }

    public double totalSpend(){
        double spend = 0;
        for (Order o : orders){
            o.totalPrice();
            spend = spend + o.getPrice();
        }
        return spend;
    }
}
