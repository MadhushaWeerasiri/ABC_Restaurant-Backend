package com.abc.backend.Service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.backend.Model.role;
import com.abc.backend.Model.user;
import com.abc.backend.Repository.roleRepository;
import com.abc.backend.Repository.userRepository;

@Service
public class userService {

    @Autowired
    private userRepository userRepository;

    public List<user> allUsers() {
        return userRepository.findAll();  
    }

    public user addUser(user user) {
        return userRepository.save(user); 
    }

    public Optional<user> singleUser(ObjectId id) {
        return userRepository.findById(id);
    }

    public Optional<user> singleUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public user updateUser(ObjectId id, user userDetails) {
        Optional<user> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            user user = optionalUser.get();
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setAddress(userDetails.getAddress());
            user.setEmail(userDetails.getEmail());
            user.setRole(userDetails.getRole());
            return userRepository.save(user);
        }
        return null;
    }

    public user updatePassword(ObjectId id, String newPassword) {
        Optional<user> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            user user = optionalUser.get();
            user.setPassword(newPassword); // Update the password
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(ObjectId id) {
            userRepository.deleteById(id);
    }

    public long getCount() {
        return userRepository.count();
    }

    // ----------------------------------------------------------------------------------

    @Autowired
    private roleRepository roleRepository;
    
    public List<role> allRoles() {
        return roleRepository.findAll();
    }

    public Optional<role> singleRole(int roleID) {
        return roleRepository.findByRoleID(roleID);
    }

}
