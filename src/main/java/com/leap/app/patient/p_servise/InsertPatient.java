package com.leap.app.patient.p_servise;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leap.app.patient.PCommand;
import com.leap.app.patient.PDTO;
import com.leap.app.patient.PRepository;
import com.leap.app.patient.PTable;

@Service
public class InsertPatient implements PCommand<PTable,PDTO> {

    final PRepository pRepository;

    public InsertPatient(PRepository pRepository){
        this.pRepository=pRepository;
    }


    @Override
    public ResponseEntity<PDTO> execute(PTable input) {
        PTable pTable = pRepository.save(input);
        return ResponseEntity.ok().body(new PDTO(pTable));
    }
    
}
