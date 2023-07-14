package com.road_runner.rental_form.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.road_runner.rental_form.model.RentalForm;
import com.road_runner.rental_form.repository.IRentalForm;

@CrossOrigin("*")
@RestController
@RequestMapping("/rentalform")
public class RentalFormController {
    
    @Autowired
    private IRentalForm rentalFormRepo;

    @PostMapping("/add")
    public ResponseEntity<RentalForm> addRentalForm(@RequestBody RentalForm body){
        return ResponseEntity.ok().body(rentalFormRepo.save(body));
    }

    @GetMapping("/get")
    public ResponseEntity<List<RentalForm>> getall(){
        return ResponseEntity.ok().body(rentalFormRepo.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<RentalForm> getById(@PathVariable long id){
        return ResponseEntity.ok().body(rentalFormRepo.findById(id).orElse(null));
    }
}
