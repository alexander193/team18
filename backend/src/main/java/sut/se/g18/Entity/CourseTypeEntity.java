package sut.se.g18.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

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
