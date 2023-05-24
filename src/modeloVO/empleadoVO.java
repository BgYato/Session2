package modeloVO;

/**
 *
 * @author yatwa
 */
public class EmpleadoVO{

    private String empId, empNombre, empApellido, empPhone, empAdmin, empUsu, empPwd;
    private int ID;

    public EmpleadoVO() {
    }

    public EmpleadoVO(String empId, String empNombre, String empApellido, String empPhone, String empAdmin, String empUsu, String empPwd) {
        this.empId = empId;
        this.empNombre = empNombre;
        this.empApellido = empApellido;
        this.empPhone = empPhone;
        this.empAdmin = empAdmin;
        this.empUsu = empUsu;
        this.empPwd = empPwd;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpNombre() {
        return empNombre;
    }

    public void setEmpNombre(String empNombre) {
        this.empNombre = empNombre;
    }

    public String getEmpApellido() {
        return empApellido;
    }

    public void setEmpApellido(String empApellido) {
        this.empApellido = empApellido;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpAdmin() {
        return empAdmin;
    }

    public void setEmpAdmin(String empAdmin) {
        this.empAdmin = empAdmin;
    }

    public String getEmpUsu() {
        return empUsu;
    }

    public void setEmpUsu(String empUsu) {
        this.empUsu = empUsu;
    }

    public String getEmpPwd() {
        return empPwd;
    }

    public void setEmpPwd(String empPwd) {
        this.empPwd = empPwd;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    
    
}
