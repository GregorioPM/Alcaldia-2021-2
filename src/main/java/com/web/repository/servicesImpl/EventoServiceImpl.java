package com.web.repository.servicesImpl;

import com.web.entities.Evento;
import com.web.repository.dao.IEventoDao;
import com.web.repository.services.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServiceImpl implements IEventoService {
    @Autowired
    private IEventoDao eventoDao;

    @Override
    public Evento save(Evento evento) {
        try{
            return  eventoDao.save(evento);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return  null;
        }
    }

    @Override
    public String remove(int id) {
        try {
        eventoDao.deleteById(id);
            return  "Evento eliminado";
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Evento> findAll() {
        try {
            return eventoDao.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return  null;
        }

    }

    @Override
    public Evento findById(int id) {
        try {
            return  eventoDao.findById(id).orElse(null);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return  null;
        }
    }
}
