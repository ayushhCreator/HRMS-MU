package com.magadhUniversity.repository;

import com.magadhUniversity.model.Timetable;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {
    
    // Find all timetables for a given department
    List<Timetable> findByDepartment(String department);
}
