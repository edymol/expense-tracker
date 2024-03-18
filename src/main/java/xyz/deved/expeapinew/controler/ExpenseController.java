package xyz.deved.expeapinew.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.deved.expeapinew.entity.Expense;

import java.util.List;


@RestController
@RequestMapping("api/auth")
public class ExpenseController {
    @GetMapping("/expenses")
    public List<Expense> getAllExpenses(){
        return getAllExpenses();
    }
}
