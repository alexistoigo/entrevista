package br.com.entrevista.entities;

import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String gender;

    private String dateBirth;

    private Integer age;

    @ManyToOne
    private Cities city;

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", dateBirth=" + dateBirth + ", age=" + age + ", cities=" + city + '}';
    }

}
