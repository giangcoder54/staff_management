package com.staff_management.Entity.Security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.staff_management.Entity.User.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//Spring Security use UserDetail object to authenticate and store infor from User
// Therefore, we need create UserDetailImpl to convert user to UserDetails
public class UserDetailsImpl implements UserDetails {

    private String id;

    private String username;

    //@JsonIgnore // ignore password in serialization processing
    private String password;
    private Collection<? extends  GrantedAuthority> authorities;

    public UserDetailsImpl(String id, String username,String password, Collection<? extends  GrantedAuthority> authorities){
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }
    //trả về danh sách các quyền của người dùng
    // GrandtedAuthority : cấp thẩm quyền
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
    public static UserDetailsImpl build(Account user){
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRoleName().name())).collect(Collectors.toList());
        return new UserDetailsImpl(user.getAccountId(), user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
