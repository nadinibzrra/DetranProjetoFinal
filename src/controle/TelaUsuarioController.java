/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.StringConverter;
import modelo.Usuario;
import persistencia.UsuarioDAO;

/**
 * FXML Controller class
 *
 * @author Clara
 */
public class TelaUsuarioController implements Initializable {

    @FXML
    private JFXTextField campoNome;
    @FXML
    private JFXTextField campoCPF;
    @FXML
    private JFXTextField campoLogin;
    @FXML
    private JFXDatePicker campoDN;
    @FXML
    private JFXPasswordField campoSenha;
    @FXML
    private Button botaoCadastrar;
    @FXML
    private Button botaoVoltar;
    @FXML
    private Button botaoLimpar;
    @FXML
    private AnchorPane anchorUsuario;
    @FXML
    private BorderPane borderUsuario;

    private Usuario u;
    private UsuarioDAO uDAO = new UsuarioDAO();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    //Troca para tela Login
    @FXML private void login(){
        try{
            URL url = getClass().getResource("/visao/TelaLogin.fxml");
            Parent TelaLogin = FXMLLoader.load(url);
            borderUsuario.setCenter(TelaLogin);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    @FXML private void limparUsuario(){
        campoNome.clear();
        campoCPF.clear();
        campoLogin.clear();
        campoSenha.clear();
    }
    
    @FXML private void addUsuario() throws SQLException{
         
        if(!campoSenha.getText().equals("") && !campoNome.getText().equals("") && !campoCPF.getText().equals("") && !campoLogin.getText().equals("")){
            Date dn = Date.valueOf(this.campoDN.getValue());
            u = new Usuario(
                    campoNome.getText(),
                    campoCPF.getText(),
                    dn, 
                    campoLogin.getText(), 
                    campoSenha.getText());
            System.out.println("criei objeto");
            uDAO.insertUsuario(u);
            limparUsuario();
            login();
        }else{
            System.out.println("ERRO NO CAMPO");
       }
    }
    
}
