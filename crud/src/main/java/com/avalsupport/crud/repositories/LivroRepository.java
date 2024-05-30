package com.avalsupport.crud.repositories;

import com.avalsupport.crud.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LivroRepository extends JpaRepository <LivroModel, UUID>{
}
