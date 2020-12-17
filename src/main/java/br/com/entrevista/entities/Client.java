package br.com.entrevista.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String sex;

    private String dateBirth;

    private Integer age;

    @ManyToOne
    private Cities city;

}
