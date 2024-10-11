package com.example.demo.Animal;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findBySpecies(String species);
    List<Animal> findByNameContaining(String name);
}
