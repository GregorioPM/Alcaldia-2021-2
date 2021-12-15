package com.web.repository.servicesImpl;

import com.web.entities.Alcalde;
import com.web.entities.Alcaldia;
import com.web.entities.Evento;
import com.web.repository.dao.IAlcaldeDao;
import com.web.repository.dao.IAlcaldiaDao;
import com.web.repository.services.AlcaldeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlcaldeServiceImpl implements AlcaldeService {

    @Autowired
    private IAlcaldeDao iAlcaldeDao;

    @Autowired
    private IAlcaldiaDao alcaldiaDao;


    @Override
    public Alcalde save(Alcalde alcalde) {
        System.out.println(alcalde.getAlcaldia().getIdAlcaldia());
        Alcaldia alcaldia= alcaldiaDao.findById(alcalde.getAlcaldia().getIdAlcaldia());
        System.out.println(alcaldia.getNombre());
        try{
            if(alcaldia!=null){
                return  iAlcaldeDao.save(alcalde);
            }else{
                return  null;
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            return  null;
        }
    }

    @Override
    public Alcalde update(Alcalde alcalde) {
        try{
            return  iAlcaldeDao.save(alcalde);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return  null;
        }
    }

    @Override
    public String remove(int id) {
        try {
            iAlcaldeDao.deleteById(id);
            return  "Alcalde eliminado";
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Alcalde> findAll() {
        try {
            return (List<Alcalde>) iAlcaldeDao.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return  null;
        }

    }

    @Override
    public Alcalde findById(int id) {
        try {
            return  iAlcaldeDao.findById(id).orElse(null);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return  null;
        }
    }
}
