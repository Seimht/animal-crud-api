package com.example.demo.Animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public Animal getAnimalById(int animalId) {
        return animalRepository.findById(animalId).orElse(null);
    }

    public Animal addAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal updateAnimal(int animalId, Animal updatedAnimal) {
        Animal existingAnimal = animalRepository.findById(animalId).orElse(null);
        if (existingAnimal != null) {
            existingAnimal.setName(updatedAnimal.getName());
            existingAnimal.setScientificName(updatedAnimal.getScientificName());
            existingAnimal.setSpecies(updatedAnimal.getSpecies());
            existingAnimal.setHabitat(updatedAnimal.getHabitat());
            existingAnimal.setDescription(updatedAnimal.getDescription());
            return animalRepository.save(existingAnimal);
        }
        return null;
    }

    public void deleteAnimal(int animalId) {
        animalRepository.deleteById(animalId);
    }

    public List<Animal> getAnimalsBySpecies(String species) {
        return animalRepository.findBySpecies(species);
    }

    public List<Animal> searchAnimalsByName(String name) {
        return animalRepository.findByNameContaining(name);
    }
}
