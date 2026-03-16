package com.tugas.tugasktp.controller;

import com.tugas.tugasktp.model.Ktp;
import com.tugas.tugasktp.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ktp")
public class KtpController {

    @Autowired
    private KtpService ktpService;

    @PostMapping
    public ResponseEntity<?> addKtp(@RequestBody Ktp ktp) {
        try {
            Ktp result = ktpService.addKtp(ktp);
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "status", "success",
                    "data", result
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllKtp() {
        List<Ktp> result = ktpService.getAllKtp();
        return ResponseEntity.ok(Map.of(
                "status", "success",
                "data", result
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getKtpById(@PathVariable Integer id) {
        try {
            Ktp result = ktpService.getKtpById(id);
            return ResponseEntity.ok(Map.of("status", "success", "data", result));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateKtp(@PathVariable Integer id, @RequestBody Ktp ktp) {
        try {
            Ktp result = ktpService.updateKtp(id, ktp);
            return ResponseEntity.ok(Map.of("status", "success", "data", result));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteKtp(@PathVariable Integer id) {
        try {
            ktpService.deleteKtp(id);
            return ResponseEntity.ok(Map.of("status", "success deleted data with id " + id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", e.getMessage()));
        }
    }
}