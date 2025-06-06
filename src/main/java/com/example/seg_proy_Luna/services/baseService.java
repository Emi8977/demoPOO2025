package com.example.seg_proy_Luna.services;

import com.example.seg_proy_Luna.entities.Base;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface baseService<E extends Base, ID extends Serializable> {
    public List<E> findAll() throws Exception;

    public Page<E> findAll(Pageable pageable) throws Exception;

    public E findById(ID id) throws  Exception;
    public E save(E entity) throws  Exception;
    public E update(ID id, E entity) throws Exception;

    public boolean delete(ID id) throws  Exception;

}
