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
public class Sucursal {
    private int idSucursal;
    private String direccion;
    private String encargado;

    public Sucursal() {
        this.idSucursal=0;
        this.encargado="";
        this.direccion="";
    }

    
    public Sucursal(int idSucursal, String direccion, String encargado) {
        this.idSucursal = idSucursal;
        this.direccion = direccion;
        this.encargado = encargado;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }
    
    
}
