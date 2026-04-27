
import Classes.DBConnect;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import net.proteanit.sql.DbUtils;

public class DVD extends javax.swing.JFrame {

     public DVD() {
        initComponents();
        Connect();
        Category();
        DVD_Load();
    }
     public class CategoryItem
    {
        int id;
        String name;
        
        
        public CategoryItem(int id,String name)
        {
           this.id = id;
           this.name= name;
        }
        
        public String toString()
        {
            return name;
            
        }
        
    } 
     
   Connection conn;
   PreparedStatement pst;
   ResultSet rs;

    public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    public void Category()
   {
        try {
            pst = conn.prepareStatement("select * from category");
             rs = pst.executeQuery();
             txtcategory.removeAllItems();
             
             while(rs.next())
             {
                 txtcategory.addItem(new CategoryItem(rs.getInt(1),rs.getString(2)));
             }
            
        } catch (SQLException ex) {
            Logger.getLogger(DVD.class.getName()).log(Level.SEVERE, null, ex);
        }      
   }
 public void DVD_Load()
   {
       
       
       int c;
       
        try {
            pst = conn.prepareStatement("select d.id,d.dtitle,c.catname,d.duration,d.direction from dvd d JOIN category c On d.category = c.id ");
            rs = pst.executeQuery();
            
            java.sql.ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
            d.setRowCount(0);
            
            
            
            while(rs.next())
            {
                Vector v2 = new Vector();
                
                for(int i= 1; i<=c; i++)
                {
                   v2.add(rs.getString("d.id"));
                    v2.add(rs.getString("d.dtitle"));
                    v2.add(rs.getString("c.catname"));
                    v2.add(rs.getString("d.duration"));                
                    v2.add(rs.getString("d.direction"));
                }
                
                d.addRow(v2);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtduration = new javax.swing.JTextField();
        txtdirection = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtcategory = new javax.swing.JComboBox();
        txtupdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cambria Math", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setText("DVD");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 167, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setText("Director");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 194, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 255));
        jLabel3.setText("DVD Title");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 165, 194, -1));

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 91, -1));

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 500, -1, -1));

        jButton4.setBackground(new java.awt.Color(204, 204, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, -1, -1));

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "DVD Title", "Category", "Duration", "Director"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 660, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/image1.jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 570, 640, 102));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/image1.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 571, 677, 102));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 255));
        jLabel6.setText("Category");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 194, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 255));
        jLabel7.setText("Duration");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 194, -1));

        txtduration.setBackground(new java.awt.Color(204, 204, 255));
        txtduration.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel1.add(txtduration, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 320, 240, -1));

        txtdirection.setBackground(new java.awt.Color(204, 204, 255));
        txtdirection.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel1.add(txtdirection, new org.netbeans.lib.awtextra.AbsoluteConstraints(263, 390, 240, -1));

        txtname.setBackground(new java.awt.Color(204, 204, 255));
        txtname.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel1.add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 165, 240, -1));

        txtcategory.setBackground(new java.awt.Color(204, 204, 255));
        txtcategory.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel1.add(txtcategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 240, 40));

        txtupdate.setBackground(new java.awt.Color(204, 204, 255));
        txtupdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtupdate.setText("Update");
        txtupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtupdateActionPerformed(evt);
            }
        });
        jPanel1.add(txtupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 500, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Add button
         String dtitle =txtname.getText();
       
        CategoryItem citem = (CategoryItem)txtcategory.getSelectedItem();
    
      
        String duration = txtduration.getText();
       String direction = txtdirection.getText();
      
        
        try {
            pst = conn.prepareStatement("insert into dvd(dtitle,category,duration,direction)values(?,?,?,?)");
            pst.setString(1, dtitle);
            pst.setInt(2, citem.id);         
            pst.setString(3, duration);
            pst.setString(4, direction);            
           
            
            int k = pst.executeUpdate();
            
            
            if(k==1)
            {
               JOptionPane.showMessageDialog(this, "DVD Created");
               
               txtname.setText("");
               txtcategory.setSelectedIndex(-1);
               txtduration.setText("");
               txtdirection.setText("");
               
              DVD_Load();
                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Errorr");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DVD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // table mouse click
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
     int selectIndex = jTable1.getSelectedRow();
         
      int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
      
        
      txtname.setText(d1.getValueAt(selectIndex, 1).toString());
      txtcategory.setSelectedItem(d1.getValueAt(selectIndex, 2).toString());
      txtduration.setText(d1.getValueAt(selectIndex, 3).toString());
      txtdirection.setText(d1.getValueAt(selectIndex, 4).toString());          
   
       
      jButton1.setEnabled(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Dellete button
        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
      int selectIndex = jTable1.getSelectedRow();
         
      int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
        
        
        try {
            pst = conn.prepareStatement("delete from dvd where id = ?");
          
            pst.setInt(1, id);
          
            int k = pst.executeUpdate();
            
            
            if(k==1)
            {
               JOptionPane.showMessageDialog(this, "DVD Deleted");
               
              txtname.setText("");
              txtcategory.setSelectedIndex(-1);
              txtduration.setText("");
              txtdirection.setText("");           
              
             
              txtname.requestFocus(); 
              jButton1.setEnabled(true);
              
             DVD_Load();
              
                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Errorr");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DVD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // cancel button
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtupdateActionPerformed
        // update button
      DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
      int selectIndex = jTable1.getSelectedRow();
         
      int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
        
       String dtitle =txtname.getText();
       CategoryItem citem = (CategoryItem)txtcategory.getSelectedItem();
       String duration =txtduration.getText();
       String direction = txtdirection.getText();
       
        try {
            pst = conn.prepareStatement("update dvd set dtitle = ?,category = ?,duration = ?,direction = ? where id = ?");
            pst.setString(1, dtitle);
            pst.setInt(2, citem.id);
            pst.setString(3, duration);
            pst.setString(4, direction);
            pst.setInt(5, id);
            
            int k = pst.executeUpdate();
            
            
            if(k==1)
            {
               JOptionPane.showMessageDialog(this, "dvd Updated");
               
               txtname.setText("");
               txtcategory.setSelectedIndex(-1);          
               txtduration.setText("");
               txtdirection.setText("");
               txtname.requestFocus();
               
             DVD_Load();
              jButton1.setEnabled(true);
                   
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Errorr");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }//GEN-LAST:event_txtupdateActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Category().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox txtcategory;
    private javax.swing.JTextField txtdirection;
    private javax.swing.JTextField txtduration;
    private javax.swing.JTextField txtname;
    private javax.swing.JButton txtupdate;
    // End of variables declaration//GEN-END:variables

  
}
    

