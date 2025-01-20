package net.oleksin.tracker.service;

import lombok.RequiredArgsConstructor;
import net.oleksin.tracker.dto.ExpenseRequestDto;
import net.oleksin.tracker.dto.ExpenseResponseDto;
import net.oleksin.tracker.exception.ExpenseNotFoundException;
import net.oleksin.tracker.mapper.ExpenseMapper;
import net.oleksin.tracker.model.Expense;
import net.oleksin.tracker.model.ExpenseType;
import net.oleksin.tracker.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;

    public ExpenseResponseDto getExpenseById(Long id) {
        return expenseMapper.fromEntity(findById(id));
    }

    public List<ExpenseResponseDto> getAllResponses() {
        List<ExpenseResponseDto> expenses = new ArrayList<>();
        expenseRepository.findAll()
                .iterator()
                .forEachRemaining(expense -> expenses.add(expenseMapper.fromEntity(expense)));
        return expenses;
    }

    public List<ExpenseResponseDto> getAllResponsesByCategory(ExpenseType category) {
        return expenseRepository.findAllByCategory(category)
                .stream()
                .map(expenseMapper::fromEntity)
                .toList();
    }

    public Long createExpense(ExpenseRequestDto expenseRequestDto) {
        return expenseRepository.save(expenseMapper.toEntity(expenseRequestDto)).getId();
    }

    public void updateExpense(Long id, ExpenseRequestDto expenseRequestDto) {
        Long entityIdToUpdate = findById(id).getId();
        Expense entity = expenseMapper.toEntityWithId(entityIdToUpdate, expenseRequestDto);
        expenseRepository.save(entity);
    }

    private Expense findById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException(String.format("Expense with id %d not found", id)));
    }
}
