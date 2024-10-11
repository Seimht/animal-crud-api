package com.example.demo.Animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    // 1. Get all animals
    @GetMapping("/all")
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    // 2. Get an animal by its ID
    @GetMapping("/{animalId}")
    public Animal getAnimalById(@PathVariable int animalId) {
        return animalService.getAnimalById(animalId);
    }

    // 3. Add a new animal
    @PostMapping("/new")
    public Animal addAnimal(@RequestBody Animal animal) {
        return animalService.addAnimal(animal);
    }

    // 4. Update an existing animal
    @PutMapping("/update/{animalId}")
    public Animal updateAnimal(@PathVariable int animalId, @RequestBody Animal updatedAnimal) {
        return animalService.updateAnimal(animalId, updatedAnimal);
    }

    // 5. Delete an existing animal
    @DeleteMapping("/delete/{animalId}")
    public void deleteAnimal(@PathVariable int animalId) {
        animalService.deleteAnimal(animalId);
    }

    // 6. Get all animals of a given class (species)
    @GetMapping("/species")
    public List<Animal> getAnimalsBySpecies(@RequestParam String species) {
        return animalService.getAnimalsBySpecies(species);
    }

    // 7. Get animals whose name contains a string
    @GetMapping("/search")
    public List<Animal> searchAnimalsByName(@RequestParam String name) {
        return animalService.searchAnimalsByName(name);
    }
}
