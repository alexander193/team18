package sut.se.g18.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "ADMINACCOUNT")
public class AdminAccountEntity {
    @Id
    @SequenceGenerator(name="admin_seq",sequenceName="admin_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="admin_seq")
    @Column(name="adminId",unique = true, nullable = false)
    private @NonNull Long adminId;
    private @NonNull String username;
    private @NonNull String password;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
