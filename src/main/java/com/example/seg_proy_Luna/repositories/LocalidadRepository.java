package com.example.seg_proy_Luna.repositories;

import com.example.seg_proy_Luna.entities.Localidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadRepository extends BaseRepository<Localidad, Long>{

    //Anotacion Metodo de Query
    List<Localidad> findByDenominacionContaining(String denominacion);

    Page<Localidad> findByDenominacionContaining(String denominacion, Pageable pageable);


    //Anotacion JPQL parametros indexados
    @Query(value = "SELECT l FROM Localidad l WHERE l.denominacion LIKE '%?filtro%'")
    List<Localidad> search(@Param("filtro") String filtro);

    @Query(value = "SELECT l FROM Localidad l WHERE l.denominacion LIKE '%?filtro%'")
    Page<Localidad> search(@Param("filtro") String filtro, Pageable pageable);

    //Anotacion JPQL parametros nombrados
    //@Query(value = "SELECT l FROM Localidad l WHERE l.denominacion LIKE '%:filtro%'")
    //List<Localidad> search(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM localidad WHERE localidad.denominacion LIKE '%?filtro%'",
            nativeQuery = true
    )
    List<Localidad> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM localidad WHERE localidad.denominacion LIKE '%?filtro%'",
            countQuery = "SELECT count(*) FROM localidad",
            nativeQuery = true
    )
    Page<Localidad> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}