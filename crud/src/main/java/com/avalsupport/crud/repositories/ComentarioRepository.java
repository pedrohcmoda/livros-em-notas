package com.avalsupport.crud.repositories;

import com.avalsupport.crud.models.ComentarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ComentarioRepository extends JpaRepository<ComentarioModel, UUID> {
}
