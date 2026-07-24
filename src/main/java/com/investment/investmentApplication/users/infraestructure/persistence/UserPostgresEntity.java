package com.investment.investmentApplication.users.infraestructure.persistence;

import com.investment.investmentApplication.shared.infraestructure.persistence.BasePostgresEntity;
import com.investment.investmentApplication.users.domain.Roles;
import com.investment.investmentApplication.users.domain.User;
import com.investment.investmentApplication.users.domain.UserId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static com.investment.investmentApplication.users.domain.Roles.ADMIN;

@Entity(name = "User")
@Table(name = "tb_users")
public class UserPostgresEntity extends BasePostgresEntity {

    @Id
    private UUID id;

    private String name;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    private String password;

    private LocalDate birthday;

    private Roles role;

    public UserPostgresEntity() {
    }

    private UserPostgresEntity(
            LocalDateTime createdDate,
            LocalDateTime updatedDate,
            boolean disabled,
            LocalDateTime disabledDate,
            UUID id,
            String name,
            String document,
            String email,
            String password,
            LocalDate birthday
    ) {
        super(createdDate, updatedDate, disabled, disabledDate);
        this.id = id;
        this.name = name;
        this.document = document;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.role = ADMIN;
    }

    public static UserPostgresEntity from(User anInput) {
        return new UserPostgresEntity(
                anInput.getCreatedAt(),
                anInput.getUpdatedAt(),
                anInput.isDisabled(),
                anInput.getDisabledAt(),
                anInput.getId().getValue(),
                anInput.getName(),
                anInput.getDocument(),
                anInput.getEmail(),
                anInput.getPassword(),
                anInput.getBirthday()
        );
    }

    public User toDomain(){
        return User.from(
                getCreatedDate(),
                getUpdatedDate(),
                getDisabledDate(),
                isDisabled(),
                UserId.from(getId()),
                getName(),
                getDocument(),
                getEmail(),
                getPassword(),
                getBirthday()
        );
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Roles getRole() {
        return role;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        final UserPostgresEntity that = (UserPostgresEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(document, that.document) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(birthday, that.birthday) && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, document, email, password, birthday, role);
    }
}
