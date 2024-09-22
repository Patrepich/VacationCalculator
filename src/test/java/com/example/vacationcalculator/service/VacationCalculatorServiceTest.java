package com.example.vacationcalculator.service;

import com.example.vacationcalculator.model.VacationRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VacationCalculatorServiceTest {

    @Test
    public void testCalculateVacationPay() {
        VacationCalculatorService service = new VacationCalculatorService();

        // Без дат
        VacationRequest request = new VacationRequest();
        request.setAverageSalary(60000);
        request.setVacationDays(10);

        double expected = 20000.0; // 60000 / 30 * 10
        assertEquals(expected, service.calculateVacationPay(request), 0.01);

        // С конкретными датами
        request.setVacationDates(Arrays.asList(
                LocalDate.of(2024, 9, 25), // Рабочий день
                LocalDate.of(2024, 9, 26), // Рабочий день
                LocalDate.of(2024, 9, 27), // Рабочий день
                LocalDate.of(2024, 9, 28), // Выходной
                LocalDate.of(2024, 9, 29), // Выходной
                LocalDate.of(2024, 1, 1)   // Праздник
        ));

        expected = 6000.0; // 60000 / 30 * 3
        assertEquals(expected, service.calculateVacationPay(request), 0.01);
    }
}
