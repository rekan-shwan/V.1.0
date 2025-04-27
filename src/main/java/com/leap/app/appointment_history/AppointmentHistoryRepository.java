package com.leap.app.appointment_history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
// import org.springframework.data.jpa.repository.Modifying;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

// import jakarta.transaction.Transactional;

public interface AppointmentHistoryRepository extends JpaRepository<AppointmentHistoryTable,Integer> {

    // @Transactional
    // @Modifying
    // @Query("DELETE FROM AppointmentHistoryTable a WHERE a.patient_ID = :patientId")
    // void deleteByPatientId(@Param("patientId") int patientId);

    @Modifying
    @Transactional
    @Query("DELETE FROM AppointmentHistoryTable a WHERE a.patientID = :patientID")
    void deleteAllByPatientID(@org.springframework.data.repository.query.Param("patientID") Integer patientID);
} 