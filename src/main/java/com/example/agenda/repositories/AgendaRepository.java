package com.example.agenda.repositories;

import com.example.agenda.models.Agenda;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AgendaRepository extends MongoRepository<Agenda, String> {
    List<Agenda> findByDoctor (String doctor);
}
