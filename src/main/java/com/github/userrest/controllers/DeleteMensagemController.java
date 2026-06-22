package com.github.userrest.controllers;

import com.github.userrest.services.MensagemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/mensagens")
@Tag(name = "Mural de Recados", description = "Operação de remoção do mural")
public class DeleteMensagemController {

    private static final Logger logger = LoggerFactory.getLogger(DeleteMensagemController.class);

    private final MensagemService mensagemService;

    public DeleteMensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Remover uma mensagem do mural")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        logger.info("DELETE /api/mensagens/{}", id);
        mensagemService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
