package com.magadhUniversity.service;

import com.magadhUniversity.model.Timetable;
import com.magadhUniversity.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
public class TimetableService {

    @Autowired
    private TimetableRepository timetableRepository;

    public Timetable saveTimetable(Timetable timetable) {
        return timetableRepository.save(timetable);
    }

    public List<Timetable> getTimetable(String department, String program, String semester, String academicYear) {
        return timetableRepository.findByDepartmentAndProgramAndSemesterAndAcademicYear(department, program, semester, academicYear);
    }
    public List<Timetable> getAllTimetables() {
        return timetableRepository.findAll();
    }

    // Dummy data fetching for now

        public String getTimetableforstudent(String department, String program, String academicYear, String semester) {
            // Logic to fetch timetable data from the database or other source
            return "Timetable for " + department + " - " + program + " for " + academicYear + " Semester " + semester;
        }

    public List<String> getDistinctDays() {
        return timetableRepository.findDistinctDays();
    }


    //exp

    public TimetableService(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }

    // Fetch all available departments
    public List<String> getAllDepartments() {
        return timetableRepository.findDistinctDepartments();
    }

    // Fetch all programs for a given department
    public List<String> getAllprograms() {
        return timetableRepository.findDistinctPrograms();
    }

    // Fetch all semester  for a given program

    public List<String> getAllsemsters() {
        return timetableRepository.findDistinctsemesters();
    }

    //Featch all the academicyears for a given program
    public List<String> getAllacademicyears() {
        return timetableRepository.findDistinctacademicYear();
    }




    // Fetch filtered timetables based on department, program, semester, and academic year
    public List<Timetable> getFilteredTimetables(String department, String program, String semester, String academicYear) {
        return timetableRepository.findByDepartmentAndProgramAndSemesterAndAcademicYear(
                department, program, semester, academicYear);
    }

}
