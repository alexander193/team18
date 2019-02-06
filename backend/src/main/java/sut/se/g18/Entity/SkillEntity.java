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
