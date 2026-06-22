package com.github.userrest.controllers;

import com.github.userrest.domain.dtos.MensagemListForm;
import com.github.userrest.services.MensagemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/mensagens")
@Tag(name = "Mural de Recados", description = "Operações de leitura do mural")
public class ListMensagemController {

    private static final Logger logger = LoggerFactory.getLogger(ListMensagemController.class);

    private final MensagemService mensagemService;

    public ListMensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }


    @GetMapping
    @Operation(summary = "Listar todas as mensagens do mural")
    public ResponseEntity<List<MensagemListForm>> listarTodas() {
        logger.info("GET /api/mensagens");
        var mensagens = mensagemService.listarTodas();
        return ResponseEntity.ok(mensagens);
    }


    @GetMapping("/{id}")
    @Operation(summary = "Buscar uma mensagem por ID")
    public ResponseEntity<MensagemListForm> buscarPorId(@PathVariable Long id) {
        logger.info("GET /api/mensagens/{}", id);
        var mensagem = mensagemService.buscarPorId(id);
        return ResponseEntity.ok(mensagem);
    }
}
