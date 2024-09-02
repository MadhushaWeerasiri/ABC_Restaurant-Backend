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

import com.abc.backend.Model.facility;
import com.abc.backend.Model.restaurent;
import com.abc.backend.Service.restaurentService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class restaurentController {

    @Autowired
    private restaurentService restaurentService;

    @GetMapping("/restaurent/allRestaurents")
    public ResponseEntity<List<restaurent>> getAllRestaurents() {
        return new ResponseEntity<>(restaurentService.allRestaurents(), HttpStatus.OK);
    }

    @PostMapping("/restaurent/addRestaurent")
    public ResponseEntity<restaurent> addRestaurent(@RequestBody restaurent restaurent) {
        restaurent newRestaurent = restaurentService.addRestaurent(restaurent);
        return new ResponseEntity<>(newRestaurent, HttpStatus.CREATED);
    }

    @GetMapping("/restaurent/{id}")
    public ResponseEntity<Optional<restaurent>> singleRestaurent(@PathVariable ObjectId id) {
        Optional<restaurent> restaurent = restaurentService.singleRestaurent(id);
        return new ResponseEntity<>(restaurent, HttpStatus.OK);
    }

    @PutMapping("/restaurent/{id}")
    public ResponseEntity<restaurent> updateRestaurent(@PathVariable ObjectId id,
            @RequestBody restaurent restaurentDetails) {
        restaurent updateRestaurent = restaurentService.updateRestaurent(id, restaurentDetails);
        if (updateRestaurent != null) {
            return new ResponseEntity<>(updateRestaurent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/restaurent/{id}")
    public ResponseEntity<Void> deleteRestaurent(@PathVariable ObjectId id) {
        restaurentService.deleteRestaurent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // -------------------------------------------------------------------------------------------

    @GetMapping("/facility/allFacilities")
    public ResponseEntity<List<facility>> getFacilities() {
        return new ResponseEntity<>(restaurentService.allFacilities(), HttpStatus.OK);
    }

    @PostMapping("/facility/addFacility")
    public ResponseEntity<facility> addFacility(@RequestBody facility facility) {
        facility newFacility = restaurentService.addFacility(facility);
        return new ResponseEntity<>(newFacility, HttpStatus.CREATED);
    }

    @GetMapping("/facility/{facilityId}")
    public ResponseEntity<Optional<facility>> singleFacility(@PathVariable int facilityId) {
        Optional<facility> facility = restaurentService.singleFacility(facilityId);
        return new ResponseEntity<>(facility, HttpStatus.OK);
    }

    @PutMapping("/facility/{facilityId}")
    public ResponseEntity<facility> updateFacility(@PathVariable int facilityId,
            @RequestBody facility facilityDetails) {
        facility updateFacility = restaurentService.updateFacility(facilityId, facilityDetails);
        if (updateFacility != null) {
            return new ResponseEntity<>(updateFacility, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/facility/{facilityId}")
    public ResponseEntity<Void> deleteFacility(@PathVariable int facilityId) {
        restaurentService.deleteFacility(facilityId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
