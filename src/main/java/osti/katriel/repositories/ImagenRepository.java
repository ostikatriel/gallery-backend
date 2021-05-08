package osti.katriel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import osti.katriel.entities.Imagen;

import java.util.List;

public interface ImagenRepository extends JpaRepository<Imagen, Integer> {
    List<Imagen> findByOrderById();
}
