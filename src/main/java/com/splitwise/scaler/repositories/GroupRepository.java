package com.splitwise.scaler.repositories;

import com.splitwise.scaler.models_myself.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface GroupRepository extends JpaRepository<Group, Long> {
    @Override
    Optional<Group> findById(Long aLong);

    @Override
    List<Group> findAllById(Iterable<Long> longs);
}