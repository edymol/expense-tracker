package xyz.deved.expeapinew.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "expenses", schema = "expensetracker")
public class Expense implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "expense_name")
    String expenseName;
    @Column(name = "expense_amount")
    BigDecimal expenseAmount;
    String category;
    Date date;
    String description;


}
