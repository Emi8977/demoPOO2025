package com.example.seg_proy_Luna.services;

import com.example.seg_proy_Luna.entities.Autor;
import com.example.seg_proy_Luna.repositories.AutorRepository;
import com.example.seg_proy_Luna.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl extends baseServiceImpl<Autor, Long> implements AutorService {

    @Autowired
    private AutorRepository autorRepository;
    public AutorServiceImpl(BaseRepository<Autor, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Autor> search(String filtro) throws Exception {
        try {
            List<Autor> autores = autorRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            //List<Autor> autores = autorRepository.search(filtro);
            //List<Autor> autores = autorRepository.searchNativo(filtro);
            return autores;
        } catch (Exception e) {
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Autor> search(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Autor> autores = autorRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
            //Page<Autor> autores = autorRepository.search(filtro, pageable);
            //Page<Autor> autores = autorRepository.searchNativo(filtro, pageable);
            return autores;
        } catch (Exception e) {
            throw  new Exception(e.getMessage());
        }
    }
}