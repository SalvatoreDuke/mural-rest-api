package com.github.userrest.controllers;

import com.github.userrest.domain.dtos.MensagemAddForm;
import com.github.userrest.domain.dtos.MensagemListForm;
import com.github.userrest.services.MensagemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/mensagens")
@Tag(name = "Mural de Recados", description = "Operações de escrita do mural")
public class SaveMensagemController {

    private static final Logger logger = LoggerFactory.getLogger(SaveMensagemController.class);

    private final MensagemService mensagemService;

    public SaveMensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }


    @PostMapping
    @Operation(summary = "Criar uma nova mensagem no mural")
    public ResponseEntity<MensagemListForm> criar(@RequestBody @Valid MensagemAddForm form) {
        logger.info("POST /api/mensagens - autor: {}", form.getAutor());
        var mensagemCriada = mensagemService.salvar(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagemCriada);
    }


    @PutMapping("/{id}")
    @Operation(summary = "Atualizar uma mensagem existente")
    public ResponseEntity<MensagemListForm> atualizar(@PathVariable Long id, @RequestBody @Valid MensagemAddForm form) {
        logger.info("PUT /api/mensagens/{} - autor: {}", id, form.getAutor());
        var mensagemAtualizada = mensagemService.atualizar(id, form);
        return ResponseEntity.ok(mensagemAtualizada);
    }
}
