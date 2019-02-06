package sut.se.g18.Entity;
<<<<<<< HEAD
import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

=======

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
>>>>>>> fd9923720b60c030c03fc926827f4e0a2596b096
import java.util.Date;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "LEARNED")
public class LearnedEntity {
    @Id
    @SequenceGenerator(name="learned_seq",sequenceName="learned_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="learned_seq")
    @Column(name="learnedId",unique = true, nullable = false)
    @NotNull
    private Long learnedId;
    @FutureOrPresent
<<<<<<< HEAD
=======
    @Column(unique = true)
>>>>>>> fd9923720b60c030c03fc926827f4e0a2596b096
    private Date dateLearned;
    @NotNull
    @Size(min = 5,max = 50)
    @Pattern(regexp = "^คอร์ส([ก-ู]|[เ-์]| )+")
    private String detail;
    @AssertTrue
    private boolean checkObject;

    //Many To One with Company
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CompanyEntity.class)
    private CompanyEntity company;

    //Many To One with Course
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CourseEntity.class)
    private CourseEntity course;

    //Many To One with MaidRegister
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = MaidRegisterEntity.class)
    private MaidRegisterEntity maid;

    //Many To One with Skill
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = SkillEntity.class)
    private SkillEntity skill;

}
