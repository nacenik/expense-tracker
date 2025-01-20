package net.oleksin.tracker.repository;

import net.oleksin.tracker.model.Expense;
import net.oleksin.tracker.model.ExpenseType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {

    List<Expense> findAllByCategory(ExpenseType category);
}
