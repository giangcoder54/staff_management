package com.staff_management.Entity.User;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "refresh_token")
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer refreshTokenID;

    @OneToOne
    @JoinColumn(name = "account_id" ,referencedColumnName = "account_id")
    private Account account;
    @Column(name = "refresh_token", unique = true,nullable = false)

    private String refreshToken;
    @Column(name = "refresh_expire")
    private String refreshExpiredDate;

    @Column(name = "access_status", nullable = false)
    private String accessStatus;
}
