package sut.se.g18.Entity;
<<<<<<< HEAD
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

=======

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

>>>>>>> fd9923720b60c030c03fc926827f4e0a2596b096
@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "COURSE")
public class CourseEntity {
    @Id
    @SequenceGenerator(name="course_seq",sequenceName="course_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
    @Column(name="courseId",unique = true, nullable = false)
    @NotNull
    private Long courseId;
    @NotNull
    private String courseTitle;
    @NotNull
    private String courseDetail;

    //Many To One with Company
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CompanyEntity.class)
    private CompanyEntity company;

    //Many To One with CourseType
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CourseTypeEntity.class)
    private CourseTypeEntity courseType;
}
