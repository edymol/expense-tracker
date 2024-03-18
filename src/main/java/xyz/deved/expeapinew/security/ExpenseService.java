package xyz.deved.expeapinew.security;

import org.springframework.stereotype.Service;
import xyz.deved.expeapinew.entity.Expense;

import java.util.List;

@Service
public interface ExpenseService {

    List<Expense> getAll();
}
