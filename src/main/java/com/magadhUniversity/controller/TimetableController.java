package com.magadhUniversity.controller;

import com.magadhUniversity.model.Timetable;
import com.magadhUniversity.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/timetable")
public class TimetableController {

    @Autowired
    private TimetableService timetableService;

    @GetMapping("/create")
    public String createTimetableForm(Model model) {
        model.addAttribute("timetable", new Timetable());
        return "create-timetable";
    }

    @PostMapping("/create")
    public String createTimetable(@ModelAttribute Timetable timetable) {
        timetableService.saveTimetable(timetable);
        return "redirect:/timetable/view";
    }



    //    @GetMapping("/view")
//    public String viewTimetable(
//            @RequestParam(required = false) String department,
//            @RequestParam(required = false) String program,
//            @RequestParam(required = false) String semester,
//            @RequestParam(required = false) String academicYear,
//            Model model) {
//
//        List<Timetable> timetables;
//        if (department != null && program != null && semester != null && academicYear != null) {
//            timetables = timetableService.getTimetable(department, program, semester, academicYear);
//        } else {
//            timetables = timetableService.getAllTimetables();
//        }
//        model.addAttribute("timetables", timetables);
//        return "view-timetable";
//    }
//
//
@GetMapping("/view")
public String viewTimetable(
        @RequestParam(required = false) String department,
        @RequestParam(required = false) String program,
        @RequestParam(required = false) String semester,
        @RequestParam(required = false) String academicYear,
        Model model) {

    List<Timetable> timetables;
    if (department != null && program != null && semester != null && academicYear != null) {
        timetables = timetableService.getTimetable(department, program, semester, academicYear);
    } else {
        timetables = timetableService.getAllTimetables();
    }

    // Group timetables

    Map<String, List<Timetable>> departmentWiseTimetables = timetables.stream()
            .collect(Collectors.groupingBy(Timetable::getSemester));

    Map<String, List<Timetable>> ProgramWiseTimetables = timetables.stream()
            .collect(Collectors.groupingBy(Timetable::getSemester));

    Map<String, List<Timetable>> semesterWiseTimetables = timetables.stream()
            .collect(Collectors.groupingBy(Timetable::getSemester));

    Map<String, List<Timetable>> yacademicyearWiseTimetables = timetables.stream()
            .collect(Collectors.groupingBy(Timetable::getSemester));


    model.addAttribute("departmentWiseTimetables", semesterWiseTimetables);
    model.addAttribute("semesterWiseTimetables", semesterWiseTimetables);
    return "view-timetable";
}



// for the students

    // Form page for selecting data
    @GetMapping("/student/select-data")
    public String selectdata(Model model) {
        model.addAttribute("timetable", new Timetable());
        return "select-data";
    }

    @PostMapping("/student/select-data")
    public String showselectedTimetable() {
        return "redirect:/timetable/student/view";
    }

    @GetMapping("/student/view")
    public String viewTimetables(
            @RequestParam(required = false) String department,
            @RequestParam(required = false) String program,
            @RequestParam(required = false) String semester,
            @RequestParam(required = false) String academicYear,
            Model model) {

        // Fetch distinct days from the database
        List<String> availableDays = timetableService.getDistinctDays();

        // Fetch timetables based on parameters or all if no filters are provided
        List<Timetable> timetables;
        if (department != null && program != null && semester != null && academicYear != null) {
            timetables = timetableService.getTimetable(department, program, semester, academicYear);
        } else {
            timetables = timetableService.getAllTimetables();
        }

        // Pass the distinct days and timetables to the model
        model.addAttribute("availableDays", availableDays);
        model.addAttribute("timetables", timetables);

        return "student-timetableview";
    }


    //exp
    // Show the form to choose department, program, semester, academic year
    @GetMapping("/viewexp")
    public String showTimetableForm(Model model) {
        // Add all departments and programs to the model
        model.addAttribute("departments", timetableService.getAllDepartments());
        model.addAttribute("program", timetableService.getAllprograms());
        model.addAttribute("semester", timetableService.getAllsemsters());
        model.addAttribute("academicYear", timetableService.getAllacademicyears());
        return "timetable-form";
    }
    @PostMapping("/viewexp")
    public String showsselectedTimetable() {
        return "redirect:/timetable/viewexpriment";
    }


    // Show timetable based on selected filters
    @GetMapping("/viewexpriment")
    public String viewTimetabless(
//            @RequestParam String department,
//            @RequestParam String program,
//            @RequestParam String semester,
//            @RequestParam String academicYear,
//            Model model) {
//
//        // Fetch timetable based on the filters
//        List<Timetable> timetables = timetableService.getFilteredTimetables(department, program, semester, academicYear);
//
//        // Add the timetable data to the model
//        model.addAttribute("timetables", timetables);
//        return "timetable-form-view"; // Show timetable view page
            @RequestParam("department") String department,
            @RequestParam("program") String program,
            @RequestParam("semester") String semester,
            @RequestParam("academicYear") String academicYear,
            Model model) {



      //  List<Timetable> timetables;
        List<Timetable> timetables = timetableService.getFilteredTimetables(department, program, semester, academicYear);
    // Add the timetable data to the model
        model.addAttribute("timetables", timetables);
//
        // Group timetables

//        Map<String, List<Timetable>> departmentWiseTimetables = timetables.stream()
//                .collect(Collectors.groupingBy(Timetable::getSemester));
//
//        Map<String, List<Timetable>> ProgramWiseTimetables = timetables.stream()
//                .collect(Collectors.groupingBy(Timetable::getSemester));
//
//        Map<String, List<Timetable>> semesterWiseTimetables = timetables.stream()
//                .collect(Collectors.groupingBy(Timetable::getSemester));
//
//        Map<String, List<Timetable>> yacademicyearWiseTimetables = timetables.stream()
//                .collect(Collectors.groupingBy(Timetable::getSemester));
//
//
//        model.addAttribute("departmentWiseTimetables", semesterWiseTimetables);
//        model.addAttribute("semesterWiseTimetables", semesterWiseTimetables);
        return "timetable-form-view"; // Show timetable view page

    }

}
