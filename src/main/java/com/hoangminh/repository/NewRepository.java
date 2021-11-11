package com.hoangminh.repository;

import com.hoangminh.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewRepository extends JpaRepository<NewEntity, Long> {
}
