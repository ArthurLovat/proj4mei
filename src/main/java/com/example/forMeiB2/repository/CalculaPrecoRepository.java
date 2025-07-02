package com.example.forMeiB2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.forMeiB2.model.TebelaPrincipal;

public interface CalculaPrecoRepository extends JpaRepository<TebelaPrincipal, Long> {
}
