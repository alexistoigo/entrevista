package br.com.entrevista.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Cities {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String city;

    private String uf;

    @OneToMany
    @JoinColumn(name = "cities_id")
    private List<Client> clients;

}
