package com.abc.backend.Controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.backend.Model.payment;
import com.abc.backend.Model.reservation;
import com.abc.backend.Service.reservationService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/reservation")
public class reservationController {

    @Autowired
    private reservationService reservationService;

    @GetMapping("/allReservations")
    public ResponseEntity<List<reservation>> getAllReservations() {
        return new ResponseEntity<>(reservationService.allReservations(), HttpStatus.OK);
    }

    @PostMapping("/addReservation")
    public ResponseEntity<reservation> addReservation(@RequestBody reservation reservation) {
        reservation newReservation = reservationService.addReservation(reservation);
        return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<reservation>> singleReservation(@PathVariable ObjectId id){
        Optional<reservation> reservation = reservationService.singleReservation(id);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @GetMapping("/byCustomer/{customerId}")
    public ResponseEntity<Optional<reservation>> singleReservationByCustomer(@PathVariable String customerId){
        Optional<reservation> reservation = reservationService.singleReservationByCusromerId(customerId);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<reservation> updateReservation(@PathVariable ObjectId id, @RequestBody reservation reservationDetails) {
        reservation updatedReservation = reservationService.updateReservation(id, reservationDetails);
        if (updatedReservation != null) {
            return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable ObjectId id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // -------------------------------------------------------------------------------------------

    @GetMapping("/allPayments")
    public ResponseEntity<List<payment>> getAllPayments() {
        return new ResponseEntity<>(reservationService.allPayments(), HttpStatus.OK);
    }

    @PostMapping("/addPayment")
    public ResponseEntity<payment> addPayment(@RequestBody payment payment) {
        payment newPayment = reservationService.addPayment(payment);
        return new ResponseEntity<>(newPayment, HttpStatus.CREATED);
    }

}