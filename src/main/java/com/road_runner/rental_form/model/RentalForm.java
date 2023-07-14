package com.road_runner.rental_form.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RentalForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long itemId;
    private String driverName;
    private String address;
    private String phoneNumber;
    private String driverLicenseNumber;
    private long totalPrice;
    private LocalDateTime pickDate;
    private LocalDateTime returnDate;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;

    public RentalForm(long itemId, String driverName, String address, String phoneNumber, String driverLicenseNumber,
            long totalPrice, LocalDateTime pickDate, LocalDateTime returnDate) {
                this.itemId = itemId;
                this.driverName = driverName;
                this.address = address;
                this.phoneNumber = phoneNumber;
                this.driverLicenseNumber = driverLicenseNumber; 
    }
}
