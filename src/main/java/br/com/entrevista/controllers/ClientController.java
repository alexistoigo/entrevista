package br.com.entrevista.controllers;

import br.com.entrevista.Services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {

    private ClientService clientService;


    @GetMapping("/list")
    public String list(Model model) {

        model.addAttribute("client", clientService.findAll());

        return "client/list";
    }

    @GetMapping("/new_client")
    public String newClient(Model model) {

        return "client/form";
    }

}
