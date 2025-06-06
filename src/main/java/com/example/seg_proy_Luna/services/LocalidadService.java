package com.example.seg_proy_Luna.services;

import com.example.seg_proy_Luna.entities.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LocalidadService extends baseService<Localidad, Long> {
    List<Localidad> search(String filtro) throws Exception;

    Page<Localidad> search(String filtro, Pageable pageable) throws Exception;
}
