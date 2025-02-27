package com.example.springsecuritylearn.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springsecuritylearn.Model.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, String> {

}
