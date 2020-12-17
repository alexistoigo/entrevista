package br.com.entrevista.controllers;

import br.com.entrevista.Services.CitiesService;
import br.com.entrevista.Services.ClientService;
import br.com.entrevista.entities.Cities;
import br.com.entrevista.entities.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cities")
@AllArgsConstructor
public class CitiesController {

    private final ClientService clientService;

    private final CitiesService citiesService;


    @GetMapping("/new")
    public String newCity(Model model) {

        model.addAttribute("cities", new Cities());

        return "/cities/form";
    }

    @PostMapping("/save")
    public String save(Cities city) {

        citiesService.save(city);

        return "redirect:/client/new";
    }

    @GetMapping("/{city}/listName")
    public String findByName(@PathVariable("city") String city, Model model) {

        model.addAttribute("cities", citiesService.findByCity(city));

        return "/cities/list";
    }

    @GetMapping("/{uf}/listUf")
    public String findByUf(@PathVariable("uf") String uf, Model model) {

        model.addAttribute("cities", citiesService.findByUf(uf));

        return "/cities/list";
    }


}
