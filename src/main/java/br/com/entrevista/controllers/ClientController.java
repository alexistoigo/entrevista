package br.com.entrevista.controllers;

import br.com.entrevista.Services.CitiesService;
import br.com.entrevista.Services.ClientService;
import br.com.entrevista.entities.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLOutput;
import java.util.Spliterator;

@Controller
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {

    private ClientService clientService;

    private CitiesService citiesService;


    @GetMapping("/list")
    public String list(Model model) {

        model.addAttribute("client", clientService.findAll());

        return "client/list";
    }

    @GetMapping("/new")
    public String newClient(Model model) {

        model.addAttribute("client", new Client());
        model.addAttribute("cities", citiesService.findAll());

        return "/client/form";
    }

    @PostMapping("/save")
    public String save(Client client) {

        System.out.println(client);

        clientService.save(client);

        return "redirect:/client/list";
    }

}
