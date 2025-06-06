package com.example.seg_proy_Luna.services;

import com.example.seg_proy_Luna.entities.Autor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AutorService extends baseService<Autor, Long>{
    List<Autor> search(String filtro) throws Exception;

    Page<Autor> search(String filtro, Pageable pageable) throws Exception;
}
