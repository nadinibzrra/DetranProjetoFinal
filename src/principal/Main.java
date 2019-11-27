/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author Clara
 */
public class Main extends Application {
    
    private static Stage stagePrincipal;
    
    @Override
    public void start(Stage stage) throws Exception {
        stagePrincipal = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/visao/TelaLogin.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Login");
 
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    } 
    
    public static Stage getStagePrincipal() {
        return stagePrincipal;
    }

    public static void setStagePrincipal(Stage stagePrincipal) {
        Main.stagePrincipal = stagePrincipal;
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        launch(args);
      
       // teste do banco
       /*
        Date data = new Date();
        Usuario u = new Usuario("U","0146452729", data,"login","senha");
        UsuarioDAO p = new UsuarioDAO();
        p.insertUsuario(u);
        System.out.println(p.listUsuario());
        */  
    }
    
}
