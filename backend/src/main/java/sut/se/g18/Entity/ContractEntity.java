package sut.se.g18.Entity;
import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

import java.util.Date;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "CONTRACT")
public class ContractEntity {
    @Id
    @SequenceGenerator(name="contract_seq",sequenceName="contract_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="contract_seq")
    @Column(name="contractId",unique = true, nullable = false)
    @NotNull private Long contractId;
    @NotNull
    @Future
    private Date dateStart;
    @NotNull
    @Min(value = 3)
    @Max(value = 5)
    @Positive
    private int cost;

    //Many To One with Promotion
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PromotionEntity.class)
    private PromotionEntity promotion;

    //Many To One with Company
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CompanyEntity.class)
    private CompanyEntity company;

    //Many To One with PaymentStatus
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PaymentStatusEntity.class)
    private PaymentStatusEntity status;

    //Many To One with ContractType
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ContractTypeEntity.class)
    private ContractTypeEntity contractType;

    //Many To One with Customer
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CustomerEntity.class)
    private CustomerEntity customer;

    //One To One with MaidSelectEntity
    @OneToOne(fetch = FetchType.EAGER,targetEntity = MaidSelectEntity.class)
    private MaidSelectEntity maid;

}
