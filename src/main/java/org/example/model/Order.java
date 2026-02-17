package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class Order {
    private int id;
    private LocalDate date;
    private double price;
    private List<OrderItem> items;

    public boolean isOrder(int id){
        return this.id == id;
    }

    public void totalPrice(){
        for (OrderItem o : items){
            price = price + o.getAmount();
        }
    }
}
