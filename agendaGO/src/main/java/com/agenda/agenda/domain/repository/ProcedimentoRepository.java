package com.agenda.agenda.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agenda.agenda.domain.model.Procedimento;

@Repository
public interface  ProcedimentoRepository extends JpaRepository<Procedimento, Long>{

}
