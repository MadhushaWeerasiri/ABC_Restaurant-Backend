package com.abc.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.backend.Model.query;
import com.abc.backend.Service.queryService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/query")
public class queryController {

    @Autowired
    private queryService queryService;

    @GetMapping("/allQueries")
    public ResponseEntity<List<query>> getAllQueries() {
        return new ResponseEntity<>(queryService.allQueries(), HttpStatus.OK);
    }

    @PostMapping("/addQuery")
    public ResponseEntity<query> addQuery(@RequestBody query query) {
        query newQuery = queryService.addQuery(query);
        return new ResponseEntity<>(newQuery, HttpStatus.CREATED);
    }
}
