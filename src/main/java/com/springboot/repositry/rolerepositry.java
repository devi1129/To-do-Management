package com.springboot.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Roles;

public interface rolerepositry extends JpaRepository<Roles,Long> {

}
