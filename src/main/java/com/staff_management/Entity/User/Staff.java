package com.staff_management.Entity.User;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "staff_id")
    private Integer staffID;
    @NotNull
    @Column(name = "staff_name")
    private String staffName;
    @NotNull
    @Column(name = "staff_email")
    private String email;

    @NotNull
    @Column(name = "staff_gender")
    private String gender;

    @Column(name = "position_id")
    private Integer position;
    @Column(name = "column_id")
    private Integer contract;

    @Column(name = "manager_id")
    private Integer manager;

    @NotNull
    @Column(name = "department_id", nullable = false)
    private Integer department;
    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "accountID")
    @JsonBackReference //@JsonBackReference được xem như phần phụ trợ, và nó sẽ bị lược bỏ trong serialization để tránh tình trạng lặp vô tận.
    private Account account;

}
