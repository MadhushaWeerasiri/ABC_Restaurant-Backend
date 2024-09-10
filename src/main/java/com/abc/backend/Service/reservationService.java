package com.abc.backend.Service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.backend.Model.payment;
import com.abc.backend.Model.reservation;
import com.abc.backend.Repository.paymentRepository;
import com.abc.backend.Repository.reservationRepository;

@Service
public class reservationService {

    @Autowired
    private reservationRepository reservationRepository;

    public List<reservation> allReservations() {
        return reservationRepository.findAll();
    }

    public reservation addReservation(reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Optional<reservation> singleReservation(ObjectId id) {
        return reservationRepository.findById(id);
    }

    public Optional<reservation> singleReservationByCusromerId(String customerId) {
        return reservationRepository.findByCustomerId(customerId);
    }

    public reservation updateReservation(ObjectId id, reservation reservationDetails) {
        Optional<reservation> optionalreservation = reservationRepository.findById(id);
        if (optionalreservation.isPresent()) {
            reservation reservation = optionalreservation.get();
            reservation.setCustomerId(reservationDetails.getCustomerId());
            reservation.setReservationProducts(reservationDetails.getReservationProducts());
            reservation.setReservationType(reservationDetails.getReservationType());
            reservation.setReservationDate(reservationDetails.getReservationDate());
            reservation.setReservationTime(reservationDetails.getReservationTime());
            reservation.setReservationAddress(reservationDetails.getReservationAddress());
            reservation.setReservationNote(reservationDetails.getReservationNote());
            reservation.setReservationLocation(reservationDetails.getReservationLocation());
            reservation.setReservationPlacedTime(reservationDetails.getReservationPlacedTime());
            reservation.setReservtionTotal(reservationDetails.getReservtionTotal());
            reservation.setReservationStatus(reservationDetails.getReservationStatus());
            return reservationRepository.save(reservation);
        }
        return null;
    }

    public void deleteReservation(ObjectId id) {
            reservationRepository.deleteById(id);
    }

    // --------------------------------------------------------------------------------------

    @Autowired
    private paymentRepository paymentRepository;

    public List<payment> allPayments() {
        return paymentRepository.findAll();
    }

    public payment addPayment(payment payment) {
        return paymentRepository.save(payment);
    }

    public Optional<payment> singlePayment(ObjectId id) {
        return paymentRepository.findById(id);
    }

}
