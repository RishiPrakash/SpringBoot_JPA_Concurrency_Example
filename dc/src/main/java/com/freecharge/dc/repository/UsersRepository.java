package com.freecharge.dc.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.freecharge.dc.entitymodel.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

@Modifying	
@Query(value = "update Users u set Status='Active',isEmailVerified='Y',updatedOn=:updatedOn where u.email=:email")	
public int updateUser(@Param("email") String email, @Param("updatedOn")Date date);
}
