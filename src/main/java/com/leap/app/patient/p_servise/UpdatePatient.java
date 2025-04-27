package com.leap.app.patient.p_servise;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leap.app.patient.PCommand;
import com.leap.app.patient.PDTO;
import com.leap.app.patient.PRepository;
import com.leap.app.patient.PTable;

@Service
public class UpdatePatient implements PCommand<UpdatePatientCommand,PDTO> {

    private PRepository pRepository;

    public UpdatePatient(
        PRepository pRepository
    ){
        this.pRepository=pRepository;
    }

    @Override
    public ResponseEntity<PDTO> execute(UpdatePatientCommand input) {
        Optional<PTable> pOptional=pRepository.findById(input.getPatientID());
        if (pOptional.isPresent()) {
            PTable pTable=input.getPTable();
            pTable.setPId(input.getPatientID());
            pRepository.save(pTable);
            return ResponseEntity.ok().body(new PDTO(pTable));
        }
        return ResponseEntity.notFound().build();
        
    }
}
