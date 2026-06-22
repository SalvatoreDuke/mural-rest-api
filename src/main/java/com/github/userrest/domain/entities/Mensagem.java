package com.github.userrest.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;


@Entity
@Table(name = "table_mensagens")
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do autor é obrigatório")
    @Size(min = 2, max = 100, message = "O autor deve ter entre 2 e 100 caracteres")
    @Column(nullable = false)
    private String autor;

    @NotBlank(message = "O texto da mensagem é obrigatório")
    @Size(min = 1, max = 1000, message = "O texto deve ter entre 1 e 1000 caracteres")
    @Column(nullable = false, length = 1000)
    private String texto;

    @Column(nullable = false)
    private LocalDateTime dataHora;


    public Mensagem() {
    }

    public Mensagem(String autor, String texto) {
        this.autor = autor;
        this.texto = texto;
    }


    @PrePersist
    protected void onCreate() {
        this.dataHora = LocalDateTime.now();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Mensagem{" +
                "id=" + id +
                ", autor='" + autor + '\'' +
                ", texto='" + texto + '\'' +
                ", dataHora=" + dataHora +
                '}';
    }
}
