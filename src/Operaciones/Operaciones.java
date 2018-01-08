/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Datos.Producto;
import java.util.ArrayList;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
        

/**
 *
 * @author Kon
 */
public class Operaciones {
    Conexion con = new Conexion();
    public String agregar(String id,String pass)
    {
       String status="";
        if(con.AgregarUser(id, pass)==true)
        {
        status="Usuario agregado correctamente";
        }else{
        status="Error al agregar";
        }
       return status;
    }
    public boolean login(String id,String pass)
    {
    boolean status=false;
        if(con.login(id, pass)==true)
        {
        status=true;
        }
       return status;
    }
    public String AgregarProducto(String prod,String fab,int cant,int precio,String desc,int suc)
    {
    String status = "";
        if(con.AgregarProducto(prod, fab, cant, precio, desc, suc)==true)
        {
        status="Producto Agregado correctamente";
        }else{
            status="Error al agregar";
        }
        return status;
    }
    public String BorrarProducto(int id)
    {
        String status = "";
        if(con.EliminarProducto(id)==true)
        {
        status="Producto Eliminado correctamente";
        }else{
            status="Id Inexistente";
        }
        return status;
    }
    public StringBuilder ListaProductos()
    {
      ArrayList<Producto> lista=con.ListaProductos();
      StringBuilder build= new StringBuilder();
        for (Producto nuevo:lista) {
           build.append(String.format("ID de producto: %s, \n Nombre producto: %s, \n Fabricante: %s, \n Cantidad de producto: %s, \n Precio: %s, \n Descripcion: %s, \n Id Sucursal: %s, \n \n \n,",
                   nuevo.getIdProducto(),nuevo.getNombreProducto(),nuevo.getFabricante(),nuevo.getCantidad(),nuevo.getPrecio(),nuevo.getDescripcion(),nuevo.getSucursal()));
        }      
      
      return build;      
    }
    public StringBuilder BuscarProducto(int id)
    {
    Producto nuevo=con.BuscarProducto(id);
      StringBuilder build= new StringBuilder();
      build.append(String.format("ID de producto: %s, \n Nombre producto: %s, \n Fabricante: %s, \n Cantidad de producto: %s, \n Precio: %s, \n Descripcion: %s, \n Id Sucursal: %s, \n \n \n,",
                   nuevo.getIdProducto(),nuevo.getNombreProducto(),nuevo.getFabricante(),nuevo.getCantidad(),nuevo.getPrecio(),nuevo.getDescripcion(),nuevo.getSucursal()));
      return build;
    }
    public ArrayList<Producto> Listado()
    {        
      ArrayList<Producto> lista=con.ListaProductos();
      
      return lista;
    }
    public Producto Producto(int id)
    {
       return con.BuscarProducto(id);
    }
    public String ModificarProducto(int id,String prod,String fab,int cant,int precio,String desc,int suc)
    {
    String status = "";
        if(con.ModificarProducto(id,prod, fab, cant, precio, desc, suc)==true)
        {
        status="Producto Modificado correctamente";
        }else{
            status="Error al Modificar";
        }
        return status;
    }
}
