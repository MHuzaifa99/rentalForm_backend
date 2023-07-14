package com.road_runner.rental_form.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.road_runner.rental_form.model.RentalForm;

public interface IRentalForm extends JpaRepository<RentalForm, Long>{
    
}
