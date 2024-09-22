package com.example.vacationcalculator.service;

import com.example.vacationcalculator.model.VacationRequest;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class VacationCalculatorService {

    // Список праздничных дней
    private final List<LocalDate> holidays = Arrays.asList(
            LocalDate.of(2024, 1, 1),
            LocalDate.of(2024, 5, 1),
            LocalDate.of(2024, 5, 9),
            LocalDate.of(2024, 6, 12),
            LocalDate.of(2024, 11, 4)
    );

    public double calculateVacationPay(VacationRequest request) {
        double dailySalary = request.getAverageSalary() / 30; // 30 дней в одном месяце
        if (request.getVacationDates() != null && !request.getVacationDates().isEmpty()) {
            return calculateWithDates(request, dailySalary);
        }
        return dailySalary * request.getVacationDays();
    }

    private double calculateWithDates(VacationRequest request, double dailySalary) {
        List<LocalDate> vacationDates = request.getVacationDates();
        double totalPay = 0.0;

        for (LocalDate date : vacationDates) {
            if (!isHolidayOrWeekend(date)) {
                totalPay += dailySalary;
            }
        }
        return totalPay;
    }

    private boolean isHolidayOrWeekend(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY || holidays.contains(date);
    }
}
