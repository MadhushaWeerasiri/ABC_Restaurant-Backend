package com.abc.backend.Service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.backend.Model.gallery;
import com.abc.backend.Repository.galleryRepository;

@Service
public class galleryService {

    @Autowired
    private galleryRepository galleryRepository;

    public List<gallery> allGallery() {
        return galleryRepository.findAll();
    }

    public gallery addGallery(gallery gallery) {
        return galleryRepository.save(gallery);
    }

    public Optional<gallery> singleGallery(ObjectId id) {
        return galleryRepository.findById(id);
    }

    public gallery updateGallery(ObjectId id, gallery galleryDetails) {
        Optional<gallery> optionalGallery = galleryRepository.findById(id);
        if (optionalGallery.isPresent()) {
            gallery gallery = optionalGallery.get();
            gallery.setImgName(galleryDetails.getImgName());
            gallery.setImgPath(galleryDetails.getImgPath());
            gallery.setImgDescription(galleryDetails.getImgDescription());
            gallery.setImgType(galleryDetails.getImgType());
            gallery.setUploadedBy(galleryDetails.getUploadedBy());
            gallery.setUploadedDate(galleryDetails.getUploadedDate());
            return galleryRepository.save(gallery);
        }
        return null;
    }

    public void deleteGallery(ObjectId id) {
            galleryRepository.deleteById(id);
    }
    
}
