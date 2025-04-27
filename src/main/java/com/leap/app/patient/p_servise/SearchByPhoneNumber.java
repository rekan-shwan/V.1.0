package com.leap.app.patient.p_servise;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leap.app.patient.PDTO;
import com.leap.app.patient.PQuery;
import com.leap.app.patient.PRepository;
import com.leap.app.patient.PTable;

@Service
public class SearchByPhoneNumber implements PQuery<String,PDTO> {

    final PRepository pRepository;

    public SearchByPhoneNumber(
        PRepository pRepository
    ){
        this.pRepository=pRepository;
    }

    @Override
    public ResponseEntity<PDTO> execute(String input) {

        PTable ptable=pRepository.findBypPhone(input);

        PDTO pdto = new PDTO(ptable);

        return ResponseEntity.ok().body(pdto);
        
        
    }
    
}
