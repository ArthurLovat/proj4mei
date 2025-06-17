package com.example.forMeiB2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TebelaPrincipal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double custoFixo;
    private double custoUnit;
    private double precoVenda;
    private double quant;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getCustoFixo() { return custoFixo; }
    public void setCustoFixo(double custoFixo) { this.custoFixo = custoFixo; }

    public double getCustoUnit() { return custoUnit; }
    public void setCustoUnit(double custoUnit) { this.custoUnit = custoUnit; }

    public double getPrecoVenda() { return precoVenda; }
    public void setPrecoVenda(double precoVenda) { this.precoVenda = precoVenda; }

    public double getQuant() { return quant; }
    public void setQuant(double quant) { this.quant = quant; }
}
