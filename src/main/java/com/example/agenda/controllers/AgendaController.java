package com.example.agenda.controllers;
import com.example.agenda.exceptions.AgendaNotFoundException;
import com.example.agenda.models.Agenda;
import com.example.agenda.repositories.AgendaRepository;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AgendaController {

    private final AgendaRepository agendaRepository;

    public AgendaController(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }

    @PostMapping("agenda")
    Agenda crearAgenda(@RequestBody Agenda agenda){
        return agendaRepository.save(agenda);
    }

    @PostMapping("agendas")
        List<Agenda> agendas(@RequestBody Agenda agenda){

        LocalTime start_hour = agenda.getStart_hour();
        List<Agenda> agendas = new ArrayList<Agenda>();
        int num = 0;

        int rango = 0;
        for (int i = 0; i < 12; i++) {
            agendas.add(i,new Agenda(agenda.getId(), agenda.getDoctor(), start_hour.plusMinutes(num*30L), agenda.getStart_date()));
            num++;
        }
        agendaRepository.saveAll(agendas);

        return agendaRepository.findAll();

    }

//     return agendaRepository.findById(id_doctor)
//            .orElseThrow(() -> new AgendaNotFoundException("No se encontró la agenda"));

    @GetMapping("/agendas-doctor/{doctor}")
    List<Agenda> obtenerAgendasDoctor(@PathVariable String doctor){
        return agendaRepository.findByDoctor(doctor);
    }

    @GetMapping("/agenda/{id}")
    Agenda obtenerAgenda(@PathVariable ObjectId id){
        return agendaRepository.findById(id.toString()).orElseThrow(() -> new AgendaNotFoundException("No se encontró la agenda"));
    }

    @DeleteMapping("/agenda/{id}")
    String deleteAgenda(@PathVariable String id){
        Agenda user = agendaRepository.findById(id).orElseThrow(() -> new AgendaNotFoundException("No se encontró la agenda para eliminar"));
        agendaRepository.deleteById(id);
        return "La agenda se elimino correctamente agenda del doctor con id: "+user.getDoctor();
    }

    @PutMapping("/agenda/{id}")
    Agenda updateAgenda(@PathVariable String id, @RequestBody Agenda agenda){
        Agenda old_agenda = agendaRepository.findById(id).orElse(null);
        old_agenda.setStart_hour(agenda.getStart_hour());
        old_agenda.setStart_date(agenda.getStart_date());
        return agendaRepository.save(old_agenda);
    }
}
