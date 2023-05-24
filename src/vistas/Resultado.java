/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;
import java.awt.Color;
import util.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import modeloDAO.EmpleadoDAO;
import modeloVO.EmpleadoVO;

/**
 *
 * @author yatwa
 */
public class Resultado extends javax.swing.JFrame {
    EmpleadoVO empleado = new EmpleadoVO();
    EmpleadoDAO empleDAO = new EmpleadoDAO();
    Actualizar pActualizar = new Actualizar();
    ArrayList<EmpleadoVO> mostrarEmpleados = empleDAO.mostrarEmpleados();
    private ArrayList<Object[]> seleccionDatos = new ArrayList<>();  
    Principal pPrincipal = new Principal();
            
    private String nombre;
    private String pwd;
    private String empId, empNombre, empApellido, empPhone, empAdmin, empUsu, empPwd;
    String datos[] = new String[7];

    /**
     * Creates new form Resultado
     */
    public Resultado() {
        initComponents();
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Primer nombre");
        model.addColumn("Segundo nombre");
        model.addColumn("Telefono");
        model.addColumn("Admin");
        model.addColumn("Usuario");
        model.addColumn("Contraseña");
        tablaDatos.setModel(model);
        
        for (int i = 0; i < mostrarEmpleados.size(); i++) {
            empleado = mostrarEmpleados.get(i);
            empId = empleado.getEmpId();
            empNombre = empleado.getEmpNombre();
            empApellido = empleado.getEmpApellido();
            empPhone = empleado.getEmpPhone();
            empAdmin = empleado.getEmpAdmin();
            empUsu = empleado.getEmpUsu();
            empPwd = empleado.getEmpPwd();     
            
            datos[0] = empId;
            datos[1] = empNombre;
            datos[2] = empApellido;
            datos[3] = empPhone;
            datos[4] = empAdmin;
            datos[5] = empUsu;
            datos[6] = empPwd;
            
            model.addRow(datos);
        }
    }
    
   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        
        txtBienvenida.setText("Bienvenido "+nombre);
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        btnEM = new javax.swing.JToggleButton();
        btnAdd = new javax.swing.JToggleButton();
        btnModify = new javax.swing.JToggleButton();
        txtBienvenida = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "Nombre", "Apellido", "Usuario", "Contraseña", "Perfil"
            }
        ));
        jScrollPane1.setViewportView(tablaDatos);

        btnEM.setText("Request EM");
        btnEM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEMActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnModify.setText("Modify");
        btnModify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModifyMouseClicked(evt);
            }
        });
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEM, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEM, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        txtBienvenida.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtBienvenida.setForeground(new java.awt.Color(250, 250, 250));
        txtBienvenida.setText("Bienvenido de nuevo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBienvenida)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBienvenida)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEMActionPerformed
        this.dispose();
        
        EM pEm = new EM();
        pEm.setVisible(true);
        pEm.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnEMActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Insertar pInsertar = new Insertar();
        
        pInsertar.setVisible(true);
        pInsertar.setLocationRelativeTo(null);
        pInsertar.setTitle("Añadir usuarios");
        this.dispose();
    }//GEN-LAST:event_btnAddActionPerformed

    
    
    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        int selectedRow = tablaDatos.getSelectedRow();
        if (selectedRow != -1) {            
            tablaDatos.setSelectionBackground(Color.BLUE); 
            Object value = tablaDatos.getValueAt(selectedRow, 0);
            int ID = Integer.parseInt(value.toString());
            System.out.println("Fila seleccionada en Resultado: " + ID);
            pActualizar.obtenerId(ID);
            
            pActualizar.setVisible(true);
            pActualizar.setLocationRelativeTo(null);
            pActualizar.setTitle("Update employee");  
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila primero.");
        }                                          
    }//GEN-LAST:event_btnModifyActionPerformed

    /*
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Resultado().setVisible(true);
            }
        });
    }
    */
    private void btnModifyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModifyMouseClicked
/*        int selectedRow = tablaDatos.getSelectedRow();
        if (selectedRow != -1) {            
            tablaDatos.setSelectionBackground(Color.BLUE); 
            Object value = tablaDatos.getValueAt(selectedRow, 0);
            int ID = Integer.parseInt(value.toString());
            System.out.println("Fila seleccionada: " + ID);
            empleDAO.recibirID(ID);
        } else {
            System.out.println("No se ha seleccionado ninguna fila");
        }
        */
    }//GEN-LAST:event_btnModifyMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAdd;
    private javax.swing.JToggleButton btnEM;
    private javax.swing.JToggleButton btnModify;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablaDatos;
    private javax.swing.JLabel txtBienvenida;
    // End of variables declaration//GEN-END:variables
}