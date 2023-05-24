# Session2
# Conexión
Se crean "driver, user, password, bdName, url" en donde se almacena X informacion, su sintaxis es:

public class Conexion {
    private String driver, user, password, bdName, url;
    private Connection conexion;
    
    public Conexion(){
        driver = "com.mysql.jdbc.Driver";
        user = "root";
        password = "";
        bdName = "session2";
        url = "jdbc:mysql://localhost:3306/" + bdName;
        
        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(url, user, password);            
            System.out.println("Conexión a la base de datos '"+bdName+"' es correcta.");            
        } catch (Exception e) {
            System.out.println("Conexión a la base de datos '"+bdName+"' erronea, error de tipo: " + e.toString());
        }   
    }
    
    public Connection obtenerConexion() {
        return conexion;
    }
    
    public Connection cerrarConexion() throws SQLException {
        if(!conexion.isClosed()){
            conexion.close();
            conexion = null;
        }        
        return conexion;
    }
    
    
  
}

# Modelo DAO
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
