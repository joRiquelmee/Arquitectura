/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author Kon
 */
public class Producto {
    private int IdProducto;
    private String nombreProducto;
    private String fabricante;
    private int cantidad;
    private int precio;
    private String descripcion;
    private int sucursal;

    public Producto()
    {
        this.IdProducto = 0;
        this.nombreProducto = "";
        this.fabricante = "";
        this.cantidad = 0;
        this.precio = 0;
        this.descripcion = "";
        this.sucursal=0;
    }

    public Producto(int IdProducto, String nombreProducto, String fabricante, int cantidad, int precio, String descripcion, int sucursal) {
        this.IdProducto = IdProducto;
        this.nombreProducto = nombreProducto;
        this.fabricante = fabricante;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.sucursal = sucursal;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    
    
    
}
