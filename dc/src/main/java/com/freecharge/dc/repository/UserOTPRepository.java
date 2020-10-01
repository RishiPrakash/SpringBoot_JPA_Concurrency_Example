package com.freecharge.dc.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.freecharge.dc.entitymodel.UserOTP;

public interface UserOTPRepository extends JpaRepository<UserOTP, Integer> {

@Modifying	
@Query(value="Update UserOTP uo set uo.VerifiedOn=:VerifiedOn where uo.email=:email and uo.OTP=:OTP")	
public int updateOTP(@Param("VerifiedOn")Date date, @Param("OTP") int otp, @Param("email")String email);
}
