package com.example.seg_proy_Luna.services;

import com.example.seg_proy_Luna.entities.Persona;
import com.example.seg_proy_Luna.repositories.BaseRepository;
import com.example.seg_proy_Luna.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends baseServiceImpl<Persona,Long> implements PersonaService{
    @Autowired
    private PersonaRepository personaRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository, PersonaRepository personaRepository) {
        super(baseRepository);
    }


//    public PersonaService(PersonaRepository personaRepository){
//        this.personaRepository = personaRepository;
//
//    }
//
//    @Override
//    @Transactional
//    public List<Persona> findAll() throws Exception {
//        try {
//            List<Persona> entities = personaRepository.findAll();
//            return entities;
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//
//        }
//    }
//
//    @Override
//    @Transactional
//    public Persona findById(Long id) throws Exception {
//        try {
//            Optional<Persona> entityOpcional = personaRepository.findById(id);
//            return entityOpcional.get();
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//    }
//
//    @Override
//    @Transactional
//    public Persona save(Persona entity) throws Exception {
//        try {
//            entity = personaRepository.save(entity);
//            return entity;
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//    }
//
//    @Override
//    @Transactional
//    public Persona update(Long id, Persona entity) throws Exception {
//        try {
//            Optional<Persona> entityOptional = personaRepository.findById(id);
//            Persona persona = entityOptional.get();
//
//            persona = personaRepository.save(persona);
//            return persona;
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//    }
//
//    @Override
//    @Transactional
//    public boolean delete(Long id) throws Exception {
//        try {
//            if(personaRepository.existsById(id)){
//                personaRepository.deleteById(id);
//                return true;
//            }else{
//                throw new Exception();
//            }
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//    }

    @Override
    public List<Persona> search(String filtro) throws Exception {
        try {
            List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            //List<Persona> personas = personaRepository.search(filtro);
            //List<Persona> personas = personaRepository.searchNativo(filtro);
            return personas;
        } catch (Exception e) {
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
            //Page<Persona> personas = personaRepository.search(filtro, pageable);
            //Page<Persona> personas = personaRepository.searchNativo(filtro, pageable);
            return personas;
        } catch (Exception e) {
            throw  new Exception(e.getMessage());
        }
    }
}
