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
@Table(name = "SKILL")
public class SkillEntity {
    @Id
    @SequenceGenerator(name="skill_seq",sequenceName="skill_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="skill_seq")
    @Column(name="skillId",unique = true, nullable = false)
    @NotNull
    private Long skillId;
    @NotNull
    private String skillRank;
}
