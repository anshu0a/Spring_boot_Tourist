package com.an.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.an.entity.Tourist;

public interface ITouristRepository extends JpaRepository<Tourist, Long> {

}
