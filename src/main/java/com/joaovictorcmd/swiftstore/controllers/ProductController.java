package com.joaovictorcmd.swiftstore.controllers;

import com.joaovictorcmd.swiftstore.dto.ProductDTO;
import com.joaovictorcmd.swiftstore.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * @author joaovictorcmd
 * @date 2025 Jan 29
 */
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO productDTO) {
        productDTO = productService.insert(productDTO);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productDTO.id())
                .toUri();

        return ResponseEntity.created(uri).body(productDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable) {
        Page<ProductDTO> productDTOPage = productService.findAll(pageable);
        return ResponseEntity.ok(productDTOPage);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        ProductDTO productDTO = productService.findById(id);
        return ResponseEntity.ok(productDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        productDTO = productService.update(id, productDTO);
        return ResponseEntity.ok(productDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
