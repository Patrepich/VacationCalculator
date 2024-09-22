package com.example.vacationcalculator.model;

import java.time.LocalDate;
import java.util.List;

public class VacationRequest {
    private double averageSalary;
    private int vacationDays;
    private List<LocalDate> vacationDates;

    public double getAverageSalary() {
        return averageSalary;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public List<LocalDate> getVacationDates() {
        return vacationDates;
    }

    public void setAverageSalary(double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    public void setVacationDates(List<LocalDate> vacationDates) {
        this.vacationDates = vacationDates;
    }
}
