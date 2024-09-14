package khly.codelean.project2.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    @Column(name = "order_date")
    private LocalDate   orderDate;

    @Column(name = "total_amount")
    private BigDecimal  totalAmount;

    @Column(name = "status")
    private String status;

    public Order() {}

    public Order(Customer customer, List<OrderDetail> orderDetails, LocalDate  orderDate, BigDecimal totalAmount, String status) {
        this.customer = customer;
        this.orderDetails = orderDetails;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public Order(Customer customer, LocalDate  orderDate, BigDecimal  totalAmount, String status) {
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public Order(int id, Customer customer, LocalDate  orderDate, BigDecimal  totalAmount, String status) {
        this.id = id;
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public LocalDate  getOrder_date() {
        return orderDate;
    }

    public void setOrder_date(LocalDate  order_date) {
        this.orderDate = order_date;
    }

    public BigDecimal  getTotal_amount() {
        return totalAmount;
    }

    public void setTotal_amount(BigDecimal  total_amount) {
        this.totalAmount = total_amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /*@Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", orderDetails=" + orderDetails +
                ", orderDate=" + orderDate +
                ", totalAmount='" + totalAmount + '\'' +
                ", status='" + status + '\'' +
                '}';
    }*/
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                '}';
    }

}
