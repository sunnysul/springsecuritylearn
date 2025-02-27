package com.example.springsecuritylearn.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springsecuritylearn.Model.Authorities;

@Repository
public interface AuthoritiesRepo extends JpaRepository<Authorities, String> {
    
}
