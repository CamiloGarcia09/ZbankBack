package com.zbank.data;

import com.zbank.entity.PerfilPrueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilData extends JpaRepository <PerfilPrueba, Long> {

}