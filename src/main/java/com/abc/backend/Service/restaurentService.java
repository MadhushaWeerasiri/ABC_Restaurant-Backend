package com.abc.backend.Service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.backend.Model.facility;
import com.abc.backend.Model.restaurent;
import com.abc.backend.Repository.facilityRepository;
import com.abc.backend.Repository.restaurentRepository;

@Service
public class restaurentService {

    @Autowired
    private restaurentRepository restaurentRepository;

    public List<restaurent> allRestaurents() {
        return restaurentRepository.findAll();
    }

    public restaurent addRestaurent(restaurent restaurent) {
        return restaurentRepository.save(restaurent);
    }

    public Optional<restaurent> singleRestaurent(ObjectId id) {
        return restaurentRepository.findById(id);
    }

    public restaurent updateRestaurent(ObjectId id, restaurent restaurentDetails) {
        Optional<restaurent> optionalRestaurent = restaurentRepository.findById(id);
        if (optionalRestaurent.isPresent()) {
            restaurent restaurent = optionalRestaurent.get();
            restaurent.setLocationName(restaurentDetails.getLocationName());
            restaurent.setLocationAddress(restaurentDetails.getLocationAddress());
            restaurent.setLocationCity(restaurentDetails.getLocationCity());
            restaurent.setLocationDistrict(restaurentDetails.getLocationDistrict());
            restaurent.setLocationPhone(restaurentDetails.getLocationPhone());
            restaurent.setLocationFacilities(restaurentDetails.getLocationFacilities());
            return restaurentRepository.save(restaurent);
        }
        return null;
    }

    public void deleteRestaurent(ObjectId id) {
            restaurentRepository.deleteById(id);
    }


    @Autowired
    private facilityRepository facilityRepository;

    public List<facility> allFacilities() {
        return facilityRepository.findAll();
    }

    public facility addFacility(facility facility) {
        return facilityRepository.save(facility);
    }

    public Optional<facility> singleFacility(int facilityId) {
        return facilityRepository.findByFacilityId(facilityId);
    }

    public facility updateFacility(int facilityId, facility facilityDetails) {
        Optional<facility> optionalFacility = facilityRepository.findByFacilityId(facilityId);
        if (optionalFacility.isPresent()) {
            facility facility = optionalFacility.get();
            facility.setFacilityName(facilityDetails.getFacilityName());
            facility.setFacilityDescription(facilityDetails.getFacilityDescription());
            return facilityRepository.save(facility);
        }
        return null;
    }

    public void deleteFacility(int facilityId) {
        facilityRepository.deleteByFacilityId(facilityId);
    }
}
