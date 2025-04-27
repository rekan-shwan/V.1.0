package com.leap.app.patient.p_servise;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.leap.app.patient.PDTO;
import com.leap.app.patient.PQuery;
import com.leap.app.patient.PRepository;
import com.leap.app.patient.PTable;

@Service
public class GetPatientByDate implements PQuery<Void,List<PDTO>>  {

    private final PRepository pRepository;
    public GetPatientByDate(PRepository pRepository){
        this.pRepository=pRepository;
    }

    @Override
    public ResponseEntity<List<PDTO>> execute(Void input) {
        List<PTable> list=pRepository.findPatientsWithClosestAppointments();
        List<PDTO> list2=list.stream().map(PDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(list2);
    }
    
}
