package com.abc.backend.Controller;

import java.util.List;
import java.util.Map;
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

import com.abc.backend.Model.role;
import com.abc.backend.Model.user;
import com.abc.backend.Service.userService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class userController {

    @Autowired
    private userService userService;

    @GetMapping("/user/allUsers")
    public ResponseEntity<List<user>> getAllUsers() {
        return new ResponseEntity<>(userService.allUsers(), HttpStatus.OK);
    }

    @PostMapping("/user/addUser")
    public ResponseEntity<user> addUser(@RequestBody user user) {
        user newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<user>> singleUser(@PathVariable ObjectId id) {
        Optional<user> user = userService.singleUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/user/byEmail/{email}")
    public ResponseEntity<Optional<user>> singleUserByEmail(@PathVariable String email) {
        Optional<user> user = userService.singleUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<user> updateUser(@PathVariable ObjectId id, @RequestBody user userDetails) {
        user updatedUser = userService.updateUser(id, userDetails);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/user/{id}/password")
    public ResponseEntity<?> updatePassword(@PathVariable ObjectId id,
            @RequestBody Map<String, String> passwordDetails) {
        String newPassword = passwordDetails.get("newPassword");
        user updatedUser = userService.updatePassword(id, newPassword);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable ObjectId id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // --------------------------------------------------------------------------------------------------

    @GetMapping("/role/allRoles")
    public ResponseEntity<List<role>> getAllRoles() {
        return new ResponseEntity<>(userService.allRoles(), HttpStatus.OK);
    }

    @GetMapping("/role/{roleID}")
    public ResponseEntity<Optional<role>> singleUser(@PathVariable int roleID) {
        Optional<role> role = userService.singleRole(roleID);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

}