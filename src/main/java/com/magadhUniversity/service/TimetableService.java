package com.magadhUniversity.service;
import com.magadhUniversity.model.Timetable;
import com.magadhUniversity.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimetableService {

    @Autowired
    private TimetableRepository timetableRepository;


    public List<Timetable> getAllTimetables() {
        return timetableRepository.findAll();
    }


    // Save a new or updated timetable
    public void saveTimetable(Timetable timetable) {
        timetableRepository.save(timetable);
    }

    // Get timetable by department
    public List<Timetable> getTimetableByDepartment(String department) {
        return timetableRepository.findByDepartment(department);
    }

    // Get timetable by ID
    public Timetable getTimetableById(Long id) {
        return timetableRepository.findById(id).orElse(null);
    }

    public void deleteTimetable(Long id) {
        System.out.println("Attempting to delete timetable with ID: " + id);
        timetableRepository.deleteById(id);
        System.out.println("Deleted timetable with ID: " + id);
    }
}
