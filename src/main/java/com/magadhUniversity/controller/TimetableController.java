package com.magadhUniversity.controller;
import com.magadhUniversity.model.Timetable;
import com.magadhUniversity.service.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TimetableController {
    @Autowired
    private TimetableService timetableService;


    @GetMapping("/student/timetable/select")
    public String showDepartmentPage() {
        return "student-timetable-selectionform";
    }

    @GetMapping("/student/timetable/view")
    public String viewTimetable(@RequestParam String department, Model model) {
        // Fetch timetable for the selected department
        List<Timetable> timetables = timetableService.getTimetableByDepartment(department);
        model.addAttribute("department", department);
        model.addAttribute("timetables", timetables);

        return "student-timetable-view"; // The page where the timetable is displayed
    }


    @GetMapping("/timetable")
    public String showDepartmentSelectionPageforEmp() {
        return "timetable-form";
    }

    @GetMapping("/timetable/manage")
    public String manageTimetable(@RequestParam String department, Model model) {
        // Fetch the existing timetable for the department
        List<Timetable> timetables = timetableService.getTimetableByDepartment(department);
        model.addAttribute("department", department);
        model.addAttribute("timetables", timetables);
        return "timetable-management";
    }

    @PostMapping("/timetable/add")
    public String addTimetable(@RequestParam String department,
                               @RequestParam String day,
                               @RequestParam String sub1,
                               @RequestParam String sub2,
                               @RequestParam String sub3,
                               @RequestParam String sub4,
                               @RequestParam String sub5,
                               @RequestParam String sub6,
                               @RequestParam String sub7
    ) {

        Timetable timetable = new Timetable();
        timetable.setDepartment(department);
        timetable.setDay(day);
        timetable.setSub1(sub1);
        timetable.setSub2(sub2);
        timetable.setSub3(sub3);
        timetable.setSub4(sub4);
        timetable.setSub5(sub5);
        timetable.setSub6(sub6);
        timetable.setSub7(sub7);

        timetableService.saveTimetable(timetable);

        return "redirect:/timetable/manage?department=" + department;
    }

    @PostMapping("/timetable/update")
    public String updateTimetable(@RequestParam Long id,
                                  @RequestParam String day,
                                  @RequestParam String sub1,
                                  @RequestParam String sub2,
                                  @RequestParam String sub3,
                                  @RequestParam String sub4,
                                  @RequestParam String sub5,
                                  @RequestParam String sub6,
                                  @RequestParam String sub7) {
        Timetable timetable = timetableService.getTimetableById(id);
        if (timetable != null) {
            timetable.setDay(day);
            timetable.setSub1(sub1);
            timetable.setSub2(sub2);
            timetable.setSub3(sub3);
            timetable.setSub4(sub4);
            timetable.setSub5(sub5);
            timetable.setSub6(sub6);
            timetable.setSub7(sub7);
            timetableService.saveTimetable(timetable);
        }
        return "redirect:/timetable/manage?department=" + timetable.getDepartment();

    }

    @GetMapping("/timetable/delete")
    public String deleteTimetable(@RequestParam Long id, @RequestParam String department) {
        timetableService.deleteTimetable(id);

        return "redirect:/timetable/manage?department=" + department;
    }


}