/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import Datos.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kon
 */
public class Conexion {
    private Connection con;
    private Statement state;
    //Agregar un producto a la base de datos
    
    public void conectar() {
        try {
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
            Class.forName("org.mariadb.jdbc.Driver");  

           //con = DriverManager.getConnection("jdbc:mariadb://192.168.194.131:3306/arquitectura", "root", "duocadmin");            
           con = DriverManager.getConnection("jdbc:mariadb://192.168.194.131:3306/arquitectura", "root", "duocadmin");
        state = con.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean AgregarUser(String id, String pass) {
        boolean status = false;
            int res = 0;
        try {
           conectar();
           res = state.executeUpdate("insert into login values('" + id + "','" + pass + "',now(),now());");
           con.close();
           if(res>=1)
           {
           status=true;
           }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
        }
    public boolean login(String id,String pass)
    {
        boolean status = false;
        try {
            conectar();
            ResultSet result = state.executeQuery("select * from login where username='" + id+ "' and pass='"+pass+"';");
            
            if (result.next() == true) {
                status = true;
            }
            con.close();
          
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    public boolean AgregarProducto(String nom,String fab,int cant,int precio,String desc,int sucursal) {
        boolean status=false;
        int res =0;
        int max=0;
        try {
            conectar(); 
            ResultSet result = state.executeQuery("select max(idproducto) from producto;");
            if(result.next())
            { 
                max=(int)result.getObject(1)+1;
            }
        res=state.executeUpdate("insert into producto values("+max+",'"+nom+"','"+fab+"',"+cant+","+precio+",'"+desc+"',"+sucursal+");");
        if(res>=1)
        {
        status=true;
        }
        con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    //Modificar un producto en la base de datos
    public boolean ModificarProducto(int id,String nom,String fab,int cant,int precio,String desc,int sucursal) {
        boolean status=false;
        int res =0;
        try {
            conectar();            
        res=state.executeUpdate("update producto set nombreproducto='"+nom+"', fabricante='"+fab+"',cantidad="+cant+",precio="+precio+",descripcion='"+desc+"',idsucursal="+sucursal+" where idproducto="+id+";");
        if(res>=1)
        {
        status=true;
        }
        con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    //eliminar un producto de la base de datos
    public boolean EliminarProducto(int id) {
        boolean status=false;
        int res =0;
        try {
            conectar();
        res=state.executeUpdate("delete from producto where idproducto="+id+";");
        
        if(res>=1){
        status=true;
        }
        con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }

    //traer la lista de productos 
    public ArrayList<Producto> ListaProductos() {
        ArrayList<Producto> list = new ArrayList<Producto>();
        
        try {
            conectar();
            ResultSet result = state.executeQuery("select * from producto;");
            while(result.next()) {
                Producto nuevo = new Producto();
                nuevo.setIdProducto((int)result.getObject(1));
                nuevo.setNombreProducto((String)result.getObject(2));
                nuevo.setFabricante((String)result.getObject(3));
                nuevo.setCantidad((int)result.getObject(4));
                nuevo.setPrecio((int)result.getObject(5));
                nuevo.setDescripcion((String)result.getObject(6));
                nuevo.setSucursal((int)result.getObject(7));
                list.add(nuevo);
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    //buscar un producto por id
    public Producto BuscarProducto(int id) {
        Producto nuevo = new Producto();
        try {
            conectar();
            ResultSet result = state.executeQuery("select * from producto where idproducto="+id+";");
            while(result.next()) {
                
                nuevo.setIdProducto((int)result.getObject(1));
                nuevo.setNombreProducto((String)result.getObject(2));
                nuevo.setFabricante((String)result.getObject(3));
                nuevo.setCantidad((int)result.getObject(4));
                nuevo.setPrecio((int)result.getObject(5));
                nuevo.setDescripcion((String)result.getObject(6));
                nuevo.setSucursal((int)result.getObject(7));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return nuevo;
    }
    
    }
    



    

