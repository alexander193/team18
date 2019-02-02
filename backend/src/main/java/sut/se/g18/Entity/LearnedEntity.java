package sut.se.g18.Entity;
import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import lombok.*;

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
    private Date dateLearend;
    @NotNull
    private String detail;

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
