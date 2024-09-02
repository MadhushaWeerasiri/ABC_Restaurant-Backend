package com.abc.backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.backend.Model.query;
import com.abc.backend.Repository.queryRepository;

@Service
public class queryService {

    @Autowired
    private queryRepository queryRepository;

    public List<query> allQueries() {
        return queryRepository.findAll();
    }

    public query addQuery(query query) {
        return queryRepository.save(query);
    }

}
