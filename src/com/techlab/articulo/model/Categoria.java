package com.techlab.articulo.model;

import com.techlab.articulo.interfaces.Identificable;

/**
 * CONSIGNA DE ESTA CLASE
 * ------------------------------------------------------------
 * Esta clase representa una categoría del sistema.
 *
 * Se utilizará como atributo dentro de Articulo.
 *
 * ATRIBUTOS OBLIGATORIOS
 * ------------------------------------------------------------
 * - codigo : int
 * - nombre : String
 * - descripcion : String
 *
 * ESTA CLASE DEBE
 * ------------------------------------------------------------
 * - implementar Identificable
 * - tener constructor
 * - tener getters y setters
 * - tener toString()
 *
 * IMPORTANTE
 * ------------------------------------------------------------
 * Luego esta clase tendrá su propio CRUD desde MenuCategorias.
 */
public class Categoria implements Identificable {

    private int codigo;
    private String nombre;
    private String descripcion;

    // TODO:
    // Crear constructor.
    public Categoria(int codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;

    }
    // Crear getters.
    public int getCodigo() {
        return this.codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    // Crear setters.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
//        System.out.println("| Código: " + this.codigo + "\n| nombre: " + this.nombre + "\n| Descripción: " + this.descripcion + "\n|----------------------------------------|");
        return"| Código: " + this.codigo + 
            "\n| nombre: " + this.nombre + 
            "\n| Descripción: " + this.descripcion + 
            "\n|-----------------------------------------------------------|";

    }
}
