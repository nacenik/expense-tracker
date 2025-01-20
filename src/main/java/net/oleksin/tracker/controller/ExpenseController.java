package net.oleksin.tracker.controller;

import lombok.RequiredArgsConstructor;
import net.oleksin.tracker.dto.ExpenseRequestDto;
import net.oleksin.tracker.dto.ExpenseResponseDto;
import net.oleksin.tracker.model.ExpenseType;
import net.oleksin.tracker.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/expense")
@RestController
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @GetMapping("/all")
    public ResponseEntity<List<ExpenseResponseDto>> getAllExpenses() {
        return new ResponseEntity<>(expenseService.getAllResponses(), HttpStatus.OK);
    }

    @GetMapping("/all/{category}")
    public ResponseEntity<List<ExpenseResponseDto>> getAllResponsesByCategory(@PathVariable ExpenseType category) {
        return new ResponseEntity<>(expenseService.getAllResponsesByCategory(category), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponseDto> getExpenseById(@PathVariable Long id) {
        return new ResponseEntity<>(expenseService.getExpenseById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> createExpense(@RequestBody ExpenseRequestDto expenseRequestDto) {
        Long id = expenseService.createExpense(expenseRequestDto);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateExpense(@PathVariable Long id, @RequestBody ExpenseRequestDto expenseRequestDto) {
        expenseService.updateExpense(id, expenseRequestDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
