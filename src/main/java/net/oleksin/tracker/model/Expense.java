package net.oleksin.tracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private final ExpenseType expenseType;
    private final BigDecimal amount;
    private final String description;
    private final Timestamp timestamp;
}
