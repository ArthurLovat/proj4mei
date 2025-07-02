package com.example.forMeiB2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.forMeiB2.model.TebelaPrincipal;
import com.example.forMeiB2.repository.CalculaPrecoRepository;

@Controller
public class CalculaPreco {

    private final CalculaPrecoRepository repository;

    public CalculaPreco(CalculaPrecoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tabelaprincipal", new TebelaPrincipal());
        return "index"; // Busca um arquivo chamado index.html em src/main/resources/templates/
    }
    
    @PostMapping("/pontor")
    public String ponto(@ModelAttribute TebelaPrincipal tabela, Model model) {

        double pe = ((tabela.getPrecoVenda() * tabela.getQuant()) / (tabela.getCustoFixo() + tabela.getCustoUnit() * tabela.getQuant())) * 100; 
        tabela.setPe(pe);
        repository.save(tabela);
        model.addAttribute("tabela", tabela);

        return "ponto";
    }
    @GetMapping("/ponto")
    public String mostrarPonto(Model model) {
        model.addAttribute("tabela", new TebelaPrincipal());
        return "ponto";
    }   

    @PostMapping("/calcular")
    public String calcular(@ModelAttribute TebelaPrincipal tabela, Model model) {
        double preco = ((tabela.getCustoUnit() * tabela.getQuant()) + tabela.getCustoFixo()) / tabela.getQuant();
        tabela.setPrecoVenda(preco);
        repository.save(tabela);
        model.addAttribute("tabela", tabela);
        return "calculo";
    }


    @GetMapping("/calculo")
    public String mostrarCalculo(Model model) {
        model.addAttribute("tabela", new TebelaPrincipal());
        return "calculo";
    }

    @GetMapping("/contato")
    public String contato(Model model) {
        model.addAttribute("tabela", new TebelaPrincipal());
        return "contato"; 
    }

}

