package com.leap.app.patient.p_servise;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leap.app.patient.PDTO;
import com.leap.app.patient.PQuery;
import com.leap.app.patient.PTable;

@Service
public class getPatientsToday implements PQuery<PTable,List<PDTO>> {

    @Override
    public ResponseEntity<List<PDTO>> execute(PTable input) {
        
        throw new UnsupportedOperationException("Unimplemented method 'execute'");
    }
    
}
