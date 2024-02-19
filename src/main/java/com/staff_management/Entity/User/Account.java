package com.staff_management.Entity.User;

import com.staff_management.Utils.UUIDUtil;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor // used to create constructor with no parameter
@AllArgsConstructor
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "account_id")
    private String accountId;
    @NotNull
    @Size(max = 50)
    @Column(name = "user_name", nullable = false)
    private String username;

    @NotNull
    @Size(min = 6, max = 100)
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Size(max = 20)
    @Column(name = "status", nullable = false)
    private String status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "account_roles",joinColumns = @JoinColumn(name = "account_id" ,referencedColumnName = "account_id")
            ,inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private Set<SysRole> roles = new HashSet<>();

    public Account(String username,String password){
        this.accountId = UUIDUtil.generateID();
        this.username =username;
        this.password = password;
    }
}
