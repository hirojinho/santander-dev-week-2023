package me.dio.domain.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Names {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String common;
    private String original;
    private List<String> alternatives;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommon() {
        return this.common;
    }

    public void setCommon(String common) {
        this.common = common;
    }

    public String getOriginal() {
        return this.original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public List<String> getAlternatives() {
        return this.alternatives;
    }

    public void setAlternatives(List<String> altenatives) {
        this.alternatives = altenatives;
    }
    
}
