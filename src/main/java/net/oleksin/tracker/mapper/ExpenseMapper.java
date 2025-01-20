package net.oleksin.tracker.mapper;

import net.oleksin.tracker.dto.ExpenseRequestDto;
import net.oleksin.tracker.dto.ExpenseResponseDto;
import net.oleksin.tracker.model.Expense;
import org.mapstruct.Mapper;

@Mapper
public interface ExpenseMapper {
    ExpenseResponseDto fromEntity(Expense expense);
    Expense toEntity(ExpenseRequestDto expenseRequestDto);
    Expense toEntityWithId(Long id, ExpenseRequestDto expenseRequestDto);
}
