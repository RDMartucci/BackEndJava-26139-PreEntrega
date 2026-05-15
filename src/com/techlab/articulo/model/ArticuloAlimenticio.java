package com.techlab.articulo.model;

/**
 * CONSIGNA DE ESTA CLASE
 * ------------------------------------------------------------
 * Esta clase debe heredar de Articulo.
 *
 * Representa un artículo alimenticio.
 *
 * ATRIBUTO ESPECÍFICO
 * ------------------------------------------------------------
 * - diasParaVencimiento : int
 *
 * ESTA CLASE DEBE
 * ------------------------------------------------------------
 * - tener constructor
 * - tener getters y setters
 * - sobrescribir getTipoArticulo()
 * - sobrescribir calcularPrecioFinal()
 *
 * IDEA DIDÁCTICA PARA calcularPrecioFinal()
 * ------------------------------------------------------------
 * Podés definir una regla propia, por ejemplo:
 * - si faltan pocos días para vencer, aplicar descuento
 * - si no, mantener el precio
 */
public class ArticuloAlimenticio extends Articulo {

    private int diasParaVencer;

    // TODO:
    // Crear constructor.
    public ArticuloAlimenticio(int codigo, 
                               String nombre, 
                               double precio, 
                               Categoria categoria, 
                               int diasParaVencer) {
                                
        super(codigo, nombre, precio, categoria);
        this.diasParaVencer = diasParaVencer;
    }

    // TODO:
    // Crear getters y setters.
    public int getDiasParaVencer() {
        return this.diasParaVencer;
    }

    public void setDiasParaVencer(int diasParaVencer) {
        this.diasParaVencer = diasParaVencer;
    }

    @Override
    public String getTipoArticulo() {
        // TODO:
        return "Alimenticio";
    }

    @Override
    public String getDetalleEspecifico() {
        return "Vencimiento en: " + diasParaVencer + " días";
    }

    @Override
    public double calcularPrecioFinal() {
        // TODO:
        // Implementar lógica propia del artículo alimenticio.
        if (diasParaVencer <= 3) {
            return getPrecio() * 0.75;
        }

        if (diasParaVencer <= 7) {
            return getPrecio() * 0.85;
        }

        return getPrecio();
    }
}
