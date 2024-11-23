package com.magadhUniversity.repository;

import com.magadhUniversity.model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {
    List<Timetable> findByDepartmentAndProgramAndSemesterAndAcademicYear(
            String department, String program, String semester, String academicYear);

    @Query("SELECT DISTINCT t.day FROM Timetable t ORDER BY t.day")
    List<String> findDistinctDays();

    // Custom query method to fetch timetable by day
    List<Timetable> findByDay(String day);


    //exp
    // Fetch distinct departments
    @Query("SELECT DISTINCT t.department FROM Timetable t")
    List<String> findDistinctDepartments();

    // Fetch programs by department
    @Query("SELECT DISTINCT t.program FROM Timetable t")
    List<String>  findDistinctPrograms();

    // Fetch programs by department
    @Query("SELECT DISTINCT t.semester FROM Timetable t")
    List<String>  findDistinctsemesters();


    // Fetch programs by department
    @Query("SELECT DISTINCT t.academicYear FROM Timetable t")
    List<String>  findDistinctacademicYear();



}
