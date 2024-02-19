package com.staff_management.Entity.Security;

import com.staff_management.Entity.User.Account;
import com.staff_management.Repository.User.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            Optional<Account> account  = accountRepository.findByUsername(username);
            if(!account.isPresent()){
                throw new UsernameNotFoundException("User Not Found !!");

            }
        return UserDetailsImpl.build(account.get());

    }
}
