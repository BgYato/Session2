package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVO.PartsVO;
import util.Conexion;
import util.Crud;

public class PartsDAO extends Conexion implements Crud{

    //Se crean los atributos propios de la clase y los objetos.
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet rs;
    private boolean operacion = false;
    private boolean validacion = false;
    private String sql;  
    private String pID = "", pName = "", pEffectiveLive = "";

    public PartsDAO(PartsVO partsVO) {
        super();
        
        try {
            conexion = this.obtenerConexion();
            pName = partsVO.getName();
            pID = partsVO.getID();
            pEffectiveLive = partsVO.getEffectiveLive();            
        } catch (Exception e) {
            Logger.getLogger(PartsDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public PartsDAO() {
        
    }

    @Override
    public boolean crearRegistro() {
        System.out.println("modeloDAO.PartsDAO.crearRegistro()");
        return operacion;
    }

    @Override
    public boolean actualizarRegistro() {
        //CALL u_employee(32, "Eris", "Yate", "320", null, "eris", "1234");
        System.out.println("modeloDAO.PartsDAO.actualizarRegistro()");
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
            Logger.getLogger(PartsDAO.class.getName()).log(Level.SEVERE, null,e);
        } finally {
            try {
                //this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(PartsDAO.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(PartsDAO.class.getName()).log(Level.SEVERE, null,e);
        } finally {
            try {
             //  this.cerrarConexion();
            } catch (Exception e) {
                Logger.getLogger(PartsDAO.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return validacion;
    }
    
    public ArrayList<PartsVO> mostrarPartes(){
        ArrayList<PartsVO> listaPartes = new ArrayList<>();
        
        try {
            conexion = this.obtenerConexion();
            sql = "CALL r_parts()";
            puente = conexion.prepareCall(sql);
            
            rs = puente.executeQuery();
            while(rs.next()){
                PartsVO partes = new PartsVO(rs.getString(1), rs.getString(2), rs.getString(3));
                listaPartes.add(partes);
            }
        } catch (SQLException e) {
            Logger.getLogger(PartsDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaPartes;
    }        

          
}
