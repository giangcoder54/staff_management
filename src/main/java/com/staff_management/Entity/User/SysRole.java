package com.staff_management.Entity.User;

import com.staff_management.Contraints.ERole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "sys_role")
public class SysRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleID;
    @Enumerated(EnumType.STRING)
    // ánh xạ đến csdl , EnumType.String lưu dạng String trong csdl
    //Enum.ORDINAL thì lưu dạng số nguyên
    private ERole roleName;
}
