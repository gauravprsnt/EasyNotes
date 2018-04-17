package com.prashant.demo.repository;

import com.prashant.demo.modal.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository <UserProfile,Long>{
}
