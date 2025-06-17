package com.example.forMeiB2.controller;

import com.example.forMeiB2.model.TebelaPrincipal;
import com.example.forMeiB2.repository.CalculaPrecoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/")
//    public String mostrarPaginaInicial(Model model) {
//        model.addAttribute("tabela", new TebelaPrincipal());
//        return "index"; // Busca em templates/index.html
//    }



//    @GetMapping("/")
//    public String mostrarPaginaInicial(Model model) {
//        model.addAttribute("tabela", new TebelaPrincipal());
//        return "index"; // Isso renderiza o templates/index.html
//    }

//    @GetMapping("/")
//    public String index(Model model) {
//        model.addAttribute("tabela", new TebelaPrincipal());
//        return "index";
//    }

    @PostMapping("/calcular")
    public String calcular(@ModelAttribute TebelaPrincipal tabela, Model model) {
        double preco = ((tabela.getCustoUnit() * tabela.getQuant()) + tabela.getCustoFixo()) / tabela.getQuant();
        tabela.setPrecoVenda(preco);
        repository.save(tabela);
        model.addAttribute("tabela", tabela);
        return "index";
    }
}
