package br.com.entrevista.controllers;

import br.com.entrevista.Services.CitiesService;
import br.com.entrevista.Services.ClientService;
import lombok.extern.slf4j.Slf4j;
import br.com.entrevista.entities.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;

    private final CitiesService citiesService;


    @GetMapping("/list")
    public String list(Model model) {

        model.addAttribute("client", clientService.findAll());

        return "client/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {

        model.addAttribute("client", clientService.findById(id));
        model.addAttribute("cities", citiesService.findAll());

        return "/client/form";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {

        clientService.removeById(id);

        return "redirect:/client/list";
    }

    @GetMapping("/new")
    public String newClient(Model model) {

        model.addAttribute("client", new Client());
        model.addAttribute("cities", citiesService.findAll());

        return "/client/form";
    }

    @PostMapping("/save")
    public String save(Client client) {

        clientService.save(client);

        return "redirect:/client/list";
    }

    @GetMapping("/{id}/listId")
    public String findById(@PathVariable("id") Long id, Model model) {

        model.addAttribute("client", clientService.findById(id));

        return "/client/list";
    }

    @GetMapping("/{name}/listName")
    public String findByName(@PathVariable("name") String name, Model model) {

        model.addAttribute("client", clientService.findByName(name));

        return "/client/list";
    }

}
