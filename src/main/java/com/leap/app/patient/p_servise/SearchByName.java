package com.leap.app.patient.p_servise;

import java.util.List;

import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leap.app.patient.PDTO;
import com.leap.app.patient.PQuery;
import com.leap.app.patient.PRepository;
import com.leap.app.patient.PTable;

@Service
public class SearchByName implements PQuery<String, List<PDTO>> {

    @Autowired
    private PRepository pRepository;

    @Override
    public ResponseEntity<List<PDTO>> execute(String input) {
        List<PTable> list=pRepository.findBypNameContainingIgnoreCase(input);
        List<PDTO> list2=list.stream().map(PDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(list2);
    }
    
}
