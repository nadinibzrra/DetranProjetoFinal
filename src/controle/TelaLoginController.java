/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import modelo.Usuario;
import persistencia.UsuarioDAO;

/**
 * FXML Controller class
 *
 * @author Clara
 */
public class TelaLoginController implements Initializable {

    @FXML
    private JFXTextField campoLogin;
    @FXML
    private JFXPasswordField campoSenha;
    @FXML
    private JFXButton botaoEntrar;
    @FXML
    private JFXButton botaoCadastrar;
    @FXML
    private AnchorPane anchorPrincipal;
    @FXML
    private BorderPane borderPrincipal;

    private Usuario u;
    private UsuarioDAO uDAO = new UsuarioDAO();
    private ArrayList<Usuario> listaUsuario = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listaUsuario = uDAO.listUsuario();
        System.out.println(listaUsuario);

    }

    //Troca para tela Usuario
    @FXML
    private void usuario() {
        try {
            URL url = getClass().getResource("/visao/TelaUsuario.fxml");
            Parent TelaUsuario = FXMLLoader.load(url);
            borderPrincipal.setCenter(TelaUsuario);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void prova() {
        try {
            URL url = getClass().getResource("/visao/TelaProva.fxml");
            Parent TelaProva = FXMLLoader.load(url);
            borderPrincipal.setCenter(TelaProva);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void entrar() {    
        for(int i = 0 ; i <  listaUsuario.size() ; i++){
            if(listaUsuario.get(i).getLogin().contains(campoLogin.getText().toUpperCase()) &&
                    listaUsuario.get(i).getSenha().contains(campoSenha.getText().toUpperCase()) &&
                    !campoLogin.getText().isEmpty() && !campoSenha.getText().isEmpty()){
                    prova();
                    break;
            }
        }      
    }
}
