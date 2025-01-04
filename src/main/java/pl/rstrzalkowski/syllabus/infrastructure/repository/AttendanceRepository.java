package pl.rstrzalkowski.syllabus.infrastructure.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rstrzalkowski.syllabus.domain.model.Attendance;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    // Find attendance by school class and subject ID
    List<Attendance> findBySchoolClassIdAndSubjectId(Long schoolClassId, Long subjectId);

    // Find attendance by student and subject ID (can be useful for individual attendance checks)
    List<Attendance> findByStudentIdAndSubjectId(Long studentId, Long subjectId);

    // Find attendance for a specific student in a particular class
    List<Attendance> findByStudentIdAndSchoolClassId(Long studentId, Long schoolClassId);
}

