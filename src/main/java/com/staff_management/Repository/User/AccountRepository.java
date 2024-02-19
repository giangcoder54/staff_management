package com.staff_management.Repository.User;

import com.staff_management.Entity.User.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {

    Optional<Account> findByUsername(String username);
}
