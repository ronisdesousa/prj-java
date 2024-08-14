package com.agenda.agenda.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.agenda.agenda.domain.model.Agenda;

@Repository
public interface  AgendaRepository extends JpaRepository<Agenda, Long>{

    List<Agenda> findByClienteId(Long clienteId);

    @Query("select a from agenda a where a.dataHorario = CURRENT_DATE")
    List<Agenda> findToday();    
}
