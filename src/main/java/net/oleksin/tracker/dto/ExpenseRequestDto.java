package net.oleksin.tracker.dto;

import net.oleksin.tracker.model.ExpenseType;

import java.math.BigDecimal;
import java.sql.Timestamp;

public record ExpenseRequestDto(ExpenseType expenseType,
                                BigDecimal amount,
                                String description,
                                Timestamp timestamp) {
}
