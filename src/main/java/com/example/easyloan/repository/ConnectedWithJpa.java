package com.example.easyloan.repository;

import com.example.easyloan.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConnectedWithJpa extends JpaRepository<ClientEntity, Integer> {

}
