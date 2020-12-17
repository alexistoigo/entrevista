package br.com.entrevista.controllers;

import br.com.entrevista.Services.CitiesService;
import br.com.entrevista.Services.ClientService;
import br.com.entrevista.entities.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
