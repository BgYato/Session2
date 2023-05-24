package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVO.SEMVO;
import util.Conexion;
import util.Crud;

public class SEMDAO extends Conexion implements Crud{

    //Se crean los atributos propios de la clase y los objetos.
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet rs;
    private boolean operacion = false;
    private boolean validacion = false;
    private String sql;
    private String empId = "", empNombre = "", empApellido = "", empPhone = "", empAdmin = "", empUsu = "", empPwd = "";

    public SEMDAO(SEMVO semVO) {
        super();
        
        try {
            
        } catch (Exception e) {
            Logger.getLogger(SEMDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public SEMDAO() {
        
    }

    @Override
    public boolean crearRegistro() {
        //a
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
    
    public ArrayList<SEMVO> mostrarSolicitudes(){
        ArrayList<SEMVO> listaSolicitudes = new ArrayList<>();
        
        try {
            conexion = this.obtenerConexion();
            sql = "CALL r_SEM()";
            puente = conexion.prepareCall(sql);
            
            rs = puente.executeQuery();
            while(rs.next()){
                SEMVO sem = new SEMVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));                
                listaSolicitudes.add(sem);
            }
        } catch (SQLException e) {
            Logger.getLogger(SEMDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaSolicitudes;
    }
    
    //public ArrayList<SEMVO> mostrarSeleccion () {
        
    //}
    
    /*public EmpleadoVO mostrarEmpleado(){
        EmpleadoVO empleado = null;
        
        try {
            conexion = this.obtenerConexion();
            sql = "CALL r_employee()";
            puente = conexion.prepareCall(sql);
            
            rs = puente.executeQuery();
            if(rs.next()){
                empleado = rs.getNString(1);
            }
        } catch (Exception e) {
            System.out.println("modeloDAO.EmpleadoDAO.mostrarEmpleado()");
        }
        return empleado;
    }*/
}
