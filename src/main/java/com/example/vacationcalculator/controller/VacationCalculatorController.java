package com.example.vacationcalculator.controller;

import com.example.vacationcalculator.model.VacationRequest;
import com.example.vacationcalculator.service.VacationCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VacationCalculatorController {

    @Autowired
    private VacationCalculatorService vacationCalculatorService;

    @GetMapping("/calculate")
    public double calculate(@RequestBody VacationRequest request) {
        return vacationCalculatorService.calculateVacationPay(request);
    }
}
