package pl.javastart.streamstask;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


public class ExampleTest {

    private final StreamsTask streamsTask = new StreamsTask();
    private final List<User> users = listOfUsers();
    private final List<Expense> expenseList = listOfExpenses();

    private List<User> listOfUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1L, "Wanda", 30));
        userList.add(new User(2L, "Roman", 18));
        userList.add(new User(3L, "Stefan", 22));
        userList.add(new User(4L, "Zaosia", 10));
        userList.add(new User(5L, "Magda", 82));
        userList.add(new User(6L, "Pioter", 37));
        return userList;
    }

    private List<Expense> listOfExpenses() {
        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense(1L, "Buty", new BigDecimal("149.99"), ExpenseType.WEAR));
        expenses.add(new Expense(1L, "Sałatka", new BigDecimal("14.99"), ExpenseType.FOOD));
        expenses.add(new Expense(2L, "Bluza", new BigDecimal("100"), ExpenseType.WEAR));
        expenses.add(new Expense(2L, "Skarpetki", new BigDecimal("39"), ExpenseType.WEAR));
        expenses.add(new Expense(2L, "Zapiekanka", new BigDecimal("15"), ExpenseType.FOOD));
        expenses.add(new Expense(3L, "Spodnie", new BigDecimal("199.99"), ExpenseType.WEAR));
        expenses.add(new Expense(5L, "Opony", new BigDecimal("1550"), ExpenseType.CAR));
        expenses.add(new Expense(6L, "Wycieraczki", new BigDecimal("120.59"), ExpenseType.CAR));
        return expenses;
    }

    @Test
    public void shouldReturnCorrectNumberOfFemaleUsers() {
        //given
        //when
        Collection<User> women = streamsTask.findWomen(users);
        //then

        Assertions.assertEquals(3, women.size());
    }

    @Test
    public void shouldReturnAverageOfManUsersAge() {
        //given
        //when
        double menAverageAge = streamsTask.averageMenAge(listOfUsers());

        //then
        Assertions.assertEquals(25.67, menAverageAge);
    }

    @Test
    public void shouldGroupExpensesByUserId() {
        //given
        //when
        Map<Long, List<Expense>> longListMap = streamsTask.groupExpensesByUserId(expenseList);

        //then
        Assertions.assertEquals(5, longListMap.size());
    }

    @Test
    public void shouldGroupExpensesByUser() {
        //given
        //when
        Map<User, List<Expense>> userListMap = streamsTask.groupExpensesByUser(users, expenseList);

        //then

        Assertions.assertEquals(5, userListMap.size());
    }
}
