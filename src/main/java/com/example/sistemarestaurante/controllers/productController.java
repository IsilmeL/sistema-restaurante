package com.example.sistemarestaurante.controllers;


import com.example.sistemarestaurante.dto.productDto;
import com.example.sistemarestaurante.models.productId;
import com.example.sistemarestaurante.models.productModel;
import com.example.sistemarestaurante.services.productService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/product")

public class productController {

    final productService ProductService;

    public productController(productService ProductService) {
        this.ProductService = ProductService;
    }

    @PostMapping
    public ResponseEntity<Object> saveProduct(@RequestBody @Valid productDto ProductDto){
        if (ProductService.existsByproductName(ProductDto.getProductName())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: product name is already in use!");
        }

        if (ProductService.existsByproductCode(ProductDto.getProductCode())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: product code is already in use!");
        }
        var ProductModel = new productModel();
        BeanUtils.copyProperties(ProductDto, ProductModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductService.save(ProductModel));
    }

    @GetMapping
    public ResponseEntity<List<productModel>> getAllProductSpots(){
        return ResponseEntity.status(HttpStatus.OK).body(ProductService.findAll());
    }

    @GetMapping("/name/{idName}")
    public ResponseEntity<Object> getOneProductName(@PathVariable(value = "idName") productId productName){
        Optional<productModel> productModelOptional = ProductService.findByIdN(productName);
        if(!productModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product name not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productModelOptional.get());
    }

    @GetMapping("/{idCode}")
    public ResponseEntity<Object> getOneProductCode(@PathVariable(value = "idCode") productId productCode){
        Optional<productModel> productModelOptional = ProductService.findByIdC(productCode);
        if(!productModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product name not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") productId productCode){
        Optional<productModel> productModelOptional = ProductService.findByIdC(productCode);
        if(!productModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product name not found.");
        }
        ProductService.delete(productModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully.");
    }
}
