package com.leap.app.patient;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PRepository extends JpaRepository<PTable,Integer> {

    List<PTable> findBypNameContainingIgnoreCase (String pName);

    PTable findBypPhone(String pPhone);

    @Query("SELECT p FROM PTable p JOIN p.nextAppointment a WHERE a.appointmentDate >= CURRENT_DATE ORDER BY a.appointmentDate ASC")
    List<PTable> findPatientsWithClosestAppointments();  
    

    
    
} 
