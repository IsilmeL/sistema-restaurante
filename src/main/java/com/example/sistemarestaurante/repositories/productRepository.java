package com.example.sistemarestaurante.repositories;

import com.example.sistemarestaurante.models.productId;
import com.example.sistemarestaurante.models.productModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends JpaRepository<productModel, productId> {

    boolean existsByproductName(String ProductName);
    boolean existsByproductCode(int ProductCode);
}
