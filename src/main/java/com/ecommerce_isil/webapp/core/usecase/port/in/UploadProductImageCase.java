package com.ecommerce_isil.webapp.core.usecase.port.in;

import com.ecommerce_isil.webapp.core.usecase.dto.response.UploadProductImageResponse;
import java.io.IOException;
import java.util.UUID;

public interface UploadProductImageCase {
    UploadProductImageResponse uploadImage(UUID productId, byte[] imageBytes, String filename) throws IOException;
}
