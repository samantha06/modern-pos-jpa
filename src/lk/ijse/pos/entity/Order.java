package lk.ijse.pos.entity;

import java.time.LocalDate;

public class Order extends SuperEntity{
    private int id;
    private LocalDate date;
    private String customerId;

    public Order() {
    }

    public Order(int id, LocalDate date, String customerId) {
        this.id = id;
        this.date = date;
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
