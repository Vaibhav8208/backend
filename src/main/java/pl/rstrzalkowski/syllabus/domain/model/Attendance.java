package pl.rstrzalkowski.syllabus.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ATTENDANCE")
public class Attendance extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "student_id")
    private User student;

    @ManyToOne
    @JoinColumn(name = "school_class_id")
    private SchoolClass schoolClass;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "is_present")
    private boolean isPresent;

    @Column(name = "date")
    private LocalDate date;

    // Additional fields can be added as needed (e.g., remarks or session details)
}
