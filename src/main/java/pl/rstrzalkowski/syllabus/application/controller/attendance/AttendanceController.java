package pl.rstrzalkowski.syllabus.application.controller.attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import pl.rstrzalkowski.syllabus.application.handler.activity.ActivityCommandHandler;
import pl.rstrzalkowski.syllabus.domain.model.Attendance;
import pl.rstrzalkowski.syllabus.domain.service.attendance.AttendanceService;
import pl.rstrzalkowski.syllabus.domain.shared.AccessGuard;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;


    // Fetch attendance for a specific class and subject
    @Secured({"TEACHER", "OFFICE", "DIRECTOR", "ADMIN"})
    @GetMapping("/class/{schoolClassId}/subject/{subjectId}")
    public ResponseEntity<List<Attendance>> getAttendanceForClassAndSubject(
            @PathVariable Long schoolClassId,
            @PathVariable Long subjectId) {
        List<Attendance> attendanceList = attendanceService.getAttendanceByClassAndSubject(schoolClassId, subjectId);
        return new ResponseEntity<>(attendanceList, HttpStatus.OK);
    }

    // Fetch attendance for a specific student in a class
    @Secured({"TEACHER", "OFFICE", "DIRECTOR", "ADMIN"})
    @GetMapping("/student/{studentId}/class/{schoolClassId}")
    public ResponseEntity<List<Attendance>> getAttendanceForStudent(
            @PathVariable Long studentId,
            @PathVariable Long schoolClassId) {
        List<Attendance> attendanceList = attendanceService.getAttendanceForStudent(studentId, schoolClassId);
        return new ResponseEntity<>(attendanceList, HttpStatus.OK);
    }

    // Mark attendance for a list of students
    @Secured({"TEACHER", "OFFICE", "DIRECTOR", "ADMIN"})
    @PostMapping("/mark")
    public ResponseEntity<String> markAttendance(@RequestBody List<Attendance> attendanceList) {
        attendanceService.markAttendance(attendanceList);
        return new ResponseEntity<>("Attendance marked successfully.", HttpStatus.OK);
    }
}
