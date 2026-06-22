package com.github.userrest.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class MensagemAddForm {

    @NotBlank(message = "O nome do autor é obrigatório")
    @Size(min = 2, max = 100, message = "O autor deve ter entre 2 e 100 caracteres")
    private String autor;

    @NotBlank(message = "O texto da mensagem é obrigatório")
    @Size(min = 1, max = 1000, message = "O texto deve ter entre 1 e 1000 caracteres")
    private String texto;



    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
