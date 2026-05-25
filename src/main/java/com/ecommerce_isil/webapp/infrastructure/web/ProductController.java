package com.ecommerce_isil.webapp.infrastructure.web;

import com.ecommerce_isil.webapp.core.usecase.dto.response.UploadProductImageResponse;
import com.ecommerce_isil.webapp.core.usecase.port.in.UploadProductImageCase;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final UploadProductImageCase uploadProductImageCase;

    public ProductController(UploadProductImageCase uploadProductImageCase) {
        this.uploadProductImageCase = uploadProductImageCase;
    }

    @PostMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<UploadProductImageResponse> uploadImage(
            @PathVariable UUID id,
            @RequestParam("file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(uploadProductImageCase.uploadImage(id, file.getBytes(), file.getOriginalFilename()));
    }
}
