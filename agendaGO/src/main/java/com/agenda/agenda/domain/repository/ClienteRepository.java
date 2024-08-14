package com.agenda.agenda.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenda.agenda.domain.model.Cliente;

@Repository
public interface  ClienteRepository extends JpaRepository<Cliente, Long>{

}
