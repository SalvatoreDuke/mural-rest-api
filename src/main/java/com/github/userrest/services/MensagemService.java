package com.github.userrest.services;

import com.github.userrest.domain.dtos.MensagemAddForm;
import com.github.userrest.domain.dtos.MensagemListForm;
import com.github.userrest.domain.entities.Mensagem;
import com.github.userrest.repositories.MensagemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MensagemService {

    private final MensagemRepository mensagemRepository;

    public MensagemService(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }


    public List<MensagemListForm> listarTodas() {
        return mensagemRepository.findAll().stream()
                .map(this::toListForm)
                .toList();
    }


    public MensagemListForm buscarPorId(Long id) {
        Mensagem mensagem = mensagemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mensagem não encontrada com id: " + id));
        return toListForm(mensagem);
    }


    public MensagemListForm salvar(MensagemAddForm form) {
        Mensagem mensagem = new Mensagem();
        mensagem.setAutor(form.getAutor());
        mensagem.setTexto(form.getTexto());
        mensagem = mensagemRepository.save(mensagem);
        return toListForm(mensagem);
    }


    public MensagemListForm atualizar(Long id, MensagemAddForm form) {
        Mensagem mensagem = mensagemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mensagem não encontrada com id: " + id));

        mensagem.setAutor(form.getAutor());
        mensagem.setTexto(form.getTexto());

        mensagem = mensagemRepository.save(mensagem);
        return toListForm(mensagem);
    }


    public void deletar(Long id) {
        Mensagem mensagem = mensagemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mensagem não encontrada com id: " + id));
        mensagemRepository.delete(mensagem);
    }


    private MensagemListForm toListForm(Mensagem mensagem) {
        MensagemListForm form = new MensagemListForm();
        form.setId(mensagem.getId());
        form.setAutor(mensagem.getAutor());
        form.setTexto(mensagem.getTexto());
        form.setDataHora(mensagem.getDataHora());
        return form;
    }
}
