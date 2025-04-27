package com.leap.app.patient.p_servise;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leap.app.patient.PDTO;
import com.leap.app.patient.PQuery;
import com.leap.app.patient.PRepository;
import com.leap.app.patient.PTable;

@Service
public class PFindByID implements PQuery<Integer, PDTO> {

    final PRepository pRepository;

    public  PFindByID(
        PRepository pRepository
    ){
        this.pRepository=pRepository;
    }

    @Override
    public ResponseEntity<PDTO> execute(Integer input) {
        
        Optional<PTable> geting= pRepository.findById(input);
        if (geting.isPresent()) {
            return ResponseEntity.ok().body(new PDTO(geting.get()));
        }
        return ResponseEntity.ok().body(null);
    }
    
}
