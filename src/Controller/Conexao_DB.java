
package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Conexao_DB {
    

    
    public static void conectaDriver(){
         try { // Conecttando o driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            JOptionPane.showMessageDialog(null,"Sistema em funcionamento");




       } catch (Exception ex) { // Erro driver não encontrado
            JOptionPane.showMessageDialog(null,"ERRO D001\nDriver ou Banco de Dados Ausente\nContate o suporte (11) 3423-8976" , "Erro no sistema", 0);
        }
    }
    
         public ResultSet retornarDados(){
        String comandoSql = "select * from aprende";
        ResultSet resp = null;
        Statement stmt = null;
        
        try{
            resp = stmt.executeQuery(comandoSql);
        }catch(SQLException e){
            System.out.println("Erro SQL: "+e.getMessage());
        }
        return (resp);
    }
   
    
}
