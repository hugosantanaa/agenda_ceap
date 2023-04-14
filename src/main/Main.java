
package main;

import View.Inicio_GUI;


public class Main {

    
    public static void main(String[] args) {
         Controller.Conexao_DB.conectaDriver();
         new Inicio_GUI().setVisible(true);
    }
    
}
