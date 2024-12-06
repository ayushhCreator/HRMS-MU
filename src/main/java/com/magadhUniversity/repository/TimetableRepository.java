package com.magadhUniversity.repository;
import com.magadhUniversity.model.Timetable;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {

    List<Timetable> findByDepartment(String department);
}
