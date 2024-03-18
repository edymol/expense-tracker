package xyz.deved.expeapinew.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.deved.expeapinew.entity.Expense;
import xyz.deved.expeapinew.repository.ExpenseRepository;
import xyz.deved.expeapinew.security.ExpenseService;

import java.util.List;

@Component
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;
    @Override
    public List<Expense> getAll() {
        return expenseRepository.findAll();
    }
}
