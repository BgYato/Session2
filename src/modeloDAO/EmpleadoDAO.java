package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVO.EmpleadoVO;
import util.Conexion;
import util.Crud;

public class EmpleadoDAO extends Conexion implements Crud{

    //Se crean los atributos propios de la clase y los objetos.
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet rs;
    private boolean operacion = false;
    private boolean validacion = false;
    private String sql;
    private int valor_id;
    private String sValor_id;    
    private String empId = "", empNombre = "", empApellido = "", empPhone = "", empAdmin = "", empUsu = "", empPwd = "";

    public EmpleadoDAO(EmpleadoVO empVO) {
        super();
        
        try {
            conexion = this.obtenerConexion();
            empId = empVO.getEmpId();
            empNombre = empVO.getEmpNombre();
            empApellido = empVO.getEmpApellido();
            empPhone = empVO.getEmpPhone();
            empAdmin = empVO.getEmpAdmin();
            empUsu = empVO.getEmpUsu();
            empPwd = empVO.getEmpPwd();
        } catch (Exception e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public int getValor_id() {
        return valor_id;
    }

    public void setValor_id(int valor_id) {
        this.valor_id = valor_id;
    }  
    
    public EmpleadoDAO() {
        
    }

    @Override
    public boolean crearRegistro() {
        try {
            //CALL c_employee("nombre", "apellido", tel, admin, "username", "pwd");
            sql = "CALL c_employees(?, ?, ?, ?, ?, ?)";
            puente = conexion.prepareCall(sql);
            puente.setString(1, empNombre);
            puente.setString(2, empApellido);
            puente.setString(3, empPhone);
            puente.setString(4, empAdmin);
            puente.setString(5, empUsu);
            puente.setString(6, empPwd);
            puente.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        //CALL u_employee(32, "Eris", "Yate", "320", null, "eris", "1234");
        try {
            sql = "CALL u_employee(?, ?, ?, ?, ?, ?, ?)";
            puente = conexion.prepareCall(sql);
            puente.setString(1, empId);
            puente.setString(2, empNombre);
            puente.setString(3, empApellido);
            puente.setString(4, empPhone);
            puente.setString(5, empAdmin);
            puente.setString(6, empUsu);
            puente.setString(7, empPwd);
            puente.executeUpdate();
            operacion = true;
        } catch (Exception e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    @Override
    public boolean eliminarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean inicioSesion(String usuario, String password){
        try {
            conexion = this.obtenerConexion();
            sql = "CALL r_login(?, ?)";
            puente = conexion.prepareCall(sql);
            puente.setString(1, usuario);
            puente.setString(2, password);
            rs = puente.executeQuery();
            if(rs.next()){
                this.validarAdmin(usuario, password);
                operacion = true;
            }
        } catch (Exception e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null,e);
        } finally {
            try {
                //this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return operacion;
    }

    public boolean validarAdmin(String usuario, String password){
        try {
            conexion = this.obtenerConexion();
            sql = "SELECT isAdmin FROM employees WHERE username = ? AND password = ?";
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuario);
            puente.setString(2, password);
            rs = puente.executeQuery();
            if(rs.next()){
                int isAdmin = rs.getInt("isAdmin");
                System.out.println("Ha ingresado con tipo de rol No." + isAdmin);
                if (isAdmin == 1) {
	validacion = true;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null,e);
        } finally {
            try {
             //  this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return validacion;
    }
    
    public ArrayList<EmpleadoVO> mostrarEmpleados(){
        ArrayList<EmpleadoVO> listaEmpleados = new ArrayList<>();
        
        try {
            conexion = this.obtenerConexion();
            sql = "CALL r_employees()";
            puente = conexion.prepareCall(sql);
            
            rs = puente.executeQuery();
            while(rs.next()){
                EmpleadoVO empleado = new EmpleadoVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                listaEmpleados.add(empleado);
            }
        } catch (SQLException e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaEmpleados;
    }
    
    public ArrayList<EmpleadoVO> mostrarEmpleadoUnico(int ID){
        ArrayList<EmpleadoVO> listaEmpleado = new ArrayList<>();

        try {
            conexion = this.obtenerConexion();
            sql = "SELECT * FROM employees WHERE ID = ?";
            puente = conexion.prepareStatement(sql);
            puente.setInt(1, ID);
            
            rs = puente.executeQuery();
            if (rs.next()) {
                EmpleadoVO empleado = new EmpleadoVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                listaEmpleado.add(empleado);
            } 

        } catch (SQLException e) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaEmpleado;
    }

          
}
