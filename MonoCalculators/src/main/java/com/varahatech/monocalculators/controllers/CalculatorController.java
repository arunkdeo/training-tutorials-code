package com.varahatech.monocalculators.controllers;

import com.varahatech.monocalculators.dto.AdditionRequestDTO;
import com.varahatech.monocalculators.dto.AdditionResponseDTO;
import com.varahatech.monocalculators.dto.SubtractionRequestDTO;
import com.varahatech.monocalculators.dto.SubtractionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping("")
    public ResponseEntity<?> healthCheck() {
        return new ResponseEntity<>("Calculator Service is up and running", HttpStatus.OK);
    }

    @PostMapping("/sum")
    public ResponseEntity<AdditionResponseDTO> addNumbers(@RequestBody AdditionRequestDTO request) {
        double sum = request.getAugend() + request.getAddend();
        var response = AdditionResponseDTO.builder()
                .addend(request.getAugend())
                .augend(request.getAddend())
                .sum(sum)
                .build();
        response.setOperation("Addition");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("/subtract")
    public ResponseEntity<SubtractionResponseDTO> subtractNumber(@RequestBody SubtractionRequestDTO request) {
        var diff = request.getMinuend() - request.getSubtrahend();
        var response = SubtractionResponseDTO.builder()
                .minuend(request.getMinuend())
                .subtrahend(request.getSubtrahend())
                .difference(diff).build();
        response.setOperation("Subtraction");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
