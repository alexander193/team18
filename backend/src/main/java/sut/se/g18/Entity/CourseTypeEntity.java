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
@Table(name = "COURSE_TYPE")
public class CourseTypeEntity {
    @Id
    @SequenceGenerator(name="courseType_seq",sequenceName="courseType_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="courseType_seq")
    @Column(name="courseTypeId",unique = true, nullable = false)
    @NotNull
    private Long courseTypeId;
    @NotNull
    private String courseType;
}
