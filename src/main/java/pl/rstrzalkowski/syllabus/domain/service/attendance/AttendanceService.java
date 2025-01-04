package pl.rstrzalkowski.syllabus.domain.service.attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rstrzalkowski.syllabus.domain.model.Attendance;
import pl.rstrzalkowski.syllabus.infrastructure.repository.AttendanceRepository;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    // Fetch attendance for a specific class and subject
    public List<Attendance> getAttendanceByClassAndSubject(Long schoolClassId, Long subjectId) {
        return attendanceRepository.findBySchoolClassIdAndSubjectId(schoolClassId, subjectId);
    }

    // Mark attendance for students
    public void markAttendance(List<Attendance> attendanceList) {
        attendanceRepository.saveAll(attendanceList);
    }

    // Fetch attendance for a specific student in a class (optional utility method)
    public List<Attendance> getAttendanceForStudent(Long studentId, Long schoolClassId) {
        return attendanceRepository.findByStudentIdAndSchoolClassId(studentId, schoolClassId);
    }
}
