package com.example.sistemarestaurante.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_Table")

public class waiterModel {

    @Id
    @NotNull
    @Column(nullable = false, unique = true, length = 20)

    private String name;

    @Id
    @NotNull
    @Column(nullable = false, unique = true, length = 4)

    private int tableNumber;

    private Long id;

    public waiterModel(String newName, int NewTableNumber) {
        this.tableNumber = NewTableNumber;
        this.name = newName;
    }

    public waiterModel() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setTableNumber(int NewTableNumber) {
        tableNumber = NewTableNumber;
    }

    int getTableNumber() {
        return tableNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
