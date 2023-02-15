package com.eandl.parking.services.implement;

import com.eandl.parking.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImp {
    @Autowired
    private RecordRepository recordRepository;
}
