package com.example.demo.Animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    // 1. Get all animals
    @GetMapping("/all")
    public String getAllAnimals(Model model) {
        List<Animal> animals = animalService.getAllAnimals();
        model.addAttribute("animalList", animals);  // Attach the list of animals to the model
        return "animal-list";  // Return the view name (Thymeleaf template)
    }

    // 2. Get an animal by its ID
    @GetMapping("/{animalId}")
    public String getAnimalById(@PathVariable int animalId, Model model) {
        Animal animal = animalService.getAnimalById(animalId);
        model.addAttribute("animal", animal);  // Attach the specific animal to the model
        return "animal-details";  // Return the view name (Thymeleaf template)
    }

    // 3. Show the form for creating a new animal (GET method)
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("animal", new Animal());  // Add an empty animal object for the form
        return "animal-create";  // Return the form view
    }

    // 4. Create a new animal (POST method)
    @PostMapping("/new")
    public String addAnimal(@ModelAttribute Animal animal) {
        animalService.addAnimal(animal);
        return "redirect:/api/animals/all";  // Redirect to the list of animals after saving
    }

    // 5. Show the form for updating an existing animal (GET method)
    @GetMapping("/update/{animalId}")
    public String showUpdateForm(@PathVariable int animalId, Model model) {
        Animal animal = animalService.getAnimalById(animalId);
        model.addAttribute("animal", animal);  // Pre-fill the form with the current animal details
        return "animal-update";  // Show the form for updating the animal
    }

    // Update an existing animal (POST method)
    @PostMapping("/update/{animalId}")
    public String updateAnimal(@PathVariable int animalId, @ModelAttribute Animal updatedAnimal) {
        animalService.updateAnimal(animalId, updatedAnimal);
        return "redirect:/api/animals/all";  // Redirect to the list of animals after updating
    }

    // 7. Delete an existing animal
    @GetMapping("/delete/{animalId}")
    public String deleteAnimal(@PathVariable int animalId) {
        animalService.deleteAnimal(animalId);
        return "redirect:/api/animals/all";  // Redirect to the list of animals after deleting
    }

    // 8. Get all animals of a given class (species)
    @GetMapping("/species")
    public String getAnimalsBySpecies(@RequestParam String species, Model model) {
        List<Animal> animals = animalService.getAnimalsBySpecies(species);
        model.addAttribute("animalList", animals);  // Add the list of animals by species to the model
        return "animal-list";  // Return the animal list template
    }

    // 9. Get animals whose name contains a string
    @GetMapping("/search")
    public String searchAnimalsByName(@RequestParam String name, Model model) {
        List<Animal> animals = animalService.searchAnimalsByName(name);
        model.addAttribute("animalList", animals);  // Add the search results to the model
        return "animal-list";  // Return the animal list template
    }
}
