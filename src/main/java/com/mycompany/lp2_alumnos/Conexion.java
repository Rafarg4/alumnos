/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lp2_alumnos;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class Conexion {
    Connection conectar=null;
    String usuario ="root";
    String contrasenia ="";
    String bd ="sistema"; 
    String ip ="localhost";
    String puerto ="3306";
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
        public Connection establecreConexcion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar =DriverManager.getConnection(cadena,usuario,contrasenia);
           
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Error en la conexion,error:"+e.toString()); 
        }
            return conectar;
        
        }
        
    
}
