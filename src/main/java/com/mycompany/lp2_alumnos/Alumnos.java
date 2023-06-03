/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lp2_alumnos;

import com.mysql.cj.xdevapi.Result;
import com.toedter.calendar.JDateChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javafx.scene.control.ComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Acer
 */
public class Alumnos {
    int id;
    String nombre;
    String apellido;
    String edad;
    String direccion;
    String sexo;
    String fechanac;
    String carrera;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
     public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.direccion = sexo;
    }
     public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }
     public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    public void InsertarAlumno(JTextField paramcamponombre,JTextField paramcampoapellido, JTextField paramcampoedad, JTextField paramcampodireccion, JDateChooser paramcampofechanac, ComboBox paramcampocarrera){
        setNombre(paramcamponombre.getText());
        setApellido(paramcampoapellido.getText());
        setEdad (paramcampoedad.getText());
        setDireccion(paramcampodireccion.getText());
        setFechanac (paramcampofechanac.getDateFormatString());
       
        Conexion  objetoConexion = new Conexion(); 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(paramcampofechanac.getDate());
        String Consulta= "INSERT INTO alumnos(nombre, apellido, edad, direccion,fechanac) VALUES (?,?,?,?,?);";
        try{
            
            CallableStatement cs = objetoConexion.establecreConexcion().prepareCall(Consulta);
            cs.setString(1,getNombre());
            cs.setString(2,getApellido());
            cs.setString(3,getEdad());
            cs.setString(4,getDireccion());
            cs.setString(5,date);
            cs.setString(6, getCarrera());
            cs.execute();
            JOptionPane.showMessageDialog(null,"Se inserto correctamente!");
        } catch(Exception e ){
            JOptionPane.showMessageDialog(null,"Error al isnertar registro!,error:"+e.toString());
        }
        
    }
    public void MostrarAlumnos(JTable paramtabla){
        Conexion  objetoConexion = new Conexion(); 
        DefaultTableModel model = new DefaultTableModel();
        TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<TableModel>(model);
        paramtabla.setRowSorter(OrdenarTabla);
        String sql="";
        model.addColumn("Id");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Edad");
        model.addColumn("Direccion");
        model.addColumn("Fecha de nacimineto");
        model.addColumn("Carrera");
        paramtabla.setModel(model);
        sql="select * from alumnos";
        String []  datos = new String[7];
        Statement st;
         try{
             st=objetoConexion.establecreConexcion().createStatement();
             ResultSet rs =st.executeQuery(sql);
             while(rs.next()){
             datos[0]=rs.getString(1);
             datos[1]=rs.getString(2);
             datos[2]=rs.getString(3);
             datos[3]=rs.getString(4); 
             datos[4]=rs.getString(5);
             datos[5]=rs.getString(6);
             datos[6]=rs.getString(7);
             model.addRow(datos);
         }
             paramtabla.setModel(model);
            
        } catch(Exception e ){
            JOptionPane.showMessageDialog(null,"Error al mostrar los registros"+e.toString());
        }
        
    }
    public void SelecionarAlumno(JTable paramtabla,JTextField paramid,JTextField paramnombre,JTextField paramapellido, JTextField paramedad,JTextField paramdireccion ){
        
        try{
            int fila = paramtabla.getSelectedRow();
            if (fila >=0){
                paramid.setText((paramtabla.getValueAt(fila,0).toString()));
                paramnombre.setText((paramtabla.getValueAt(fila,1).toString()));
                paramapellido.setText((paramtabla.getValueAt(fila,2).toString()));
                paramedad.setText((paramtabla.getValueAt(fila,3).toString()));
                paramdireccion.setText((paramtabla.getValueAt(fila,4).toString()));
            }
            else{
                JOptionPane.showMessageDialog(null,"Fila no selecionada");
            }
            
        }catch(Exception e ){
             JOptionPane.showMessageDialog(null,"Error de selecion, error:"+e.toString());
           
        }
    }
    public void Editar ( JTextField paracampomid,JTextField paramcamponombre,JTextField paramcampoapellido, JTextField paramcampoedad, JTextField paramcampodireccion){
        setId(Integer.parseInt(paracampomid.getText()));
        setNombre(paramcamponombre.getText());
        setApellido(paramcampoapellido.getText());
        setEdad(paramcampoedad.getText());
        setDireccion(paramcampodireccion.getText());
        Conexion objetoConexion = new Conexion();
        String editar ="UPDATE alumnos SET alumnos.nombre=?,alumnos.apellido=?,alumnos.edad=?,alumnos.Direccion=? where alumnos.id=?";
        try{
        CallableStatement cs = objetoConexion.establecreConexcion().prepareCall(editar);
        cs.setString(1,getNombre());
        cs.setString(2,getApellido());
        cs.setString(3,getEdad());
        cs.setString(4,getDireccion());
        cs.setInt(5,getId());
        cs.execute(); 
        JOptionPane.showMessageDialog(null,"Modificacion exitosa!");
        
        }catch (SQLException e){
             JOptionPane.showMessageDialog(null,"Error al intentar modificar, error:"+ e.toString()); 
        } 
    }
     public void eliminar(JTextField paramid){
       Conexion objetoConexion = new Conexion();
       setId(Integer.parseInt(paramid.getText()));
       String eliminar="DELETE FROM alumnos WHERE id= ?";
  try{
 CallableStatement cs = objetoConexion.establecreConexcion().prepareCall(eliminar);
       cs.setInt(1,getId());
       cs.execute();
        JOptionPane.showMessageDialog(null,"Eliminado correctamente");
  }catch(Exception e){
       JOptionPane.showMessageDialog(null,"Error al eliminar, error:"+e.toString());
      } 
    }
}
