package com.ecommerce_isil.webapp.core.usecase.dto.response;

import lombok.Getter;
import java.util.UUID;

@Getter
public class UploadProductImageResponse {
    private final UUID productId;
    private final String imageUrl;

    public UploadProductImageResponse(UUID productId, String imageUrl) {
        this.productId = productId;
        this.imageUrl = imageUrl;
    }
}
