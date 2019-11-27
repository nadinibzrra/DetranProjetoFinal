/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import modelo.Prova;
import persistencia.ProvaDAO;


/**
 * FXML Controller class
 *
 * @author Clara
 */
public class TelaProvaController implements Initializable {

    @FXML
    private JFXDatePicker campoData;
    @FXML
    private JFXComboBox<String> campoCategoria;
    @FXML
    private TableView<Prova> tabelaListar;
    @FXML
    private TableColumn<?, ?> listarCategoria;
    @FXML
    private TableColumn<?, ?> listarData;
    @FXML
    private JFXButton botaoMarcar;
    @FXML
    private JFXButton botaoVoltar;
    @FXML
    private AnchorPane anchorProva;
    @FXML
    private BorderPane borderProva;
  
    private ObservableList<String> listCategoria = FXCollections.observableArrayList();
    private ObservableList<Prova> listProva;
    private Prova p;
    private ProvaDAO pDAO = new ProvaDAO();
    @FXML
    private JFXButton botaoDeletar;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        addCategoria();
        campoCategoria.setItems(listCategoria); 
        listaProva();
    }    
    
    //Troca para tela Login
    @FXML private void voltarProva(){
        try{
            URL url = getClass().getResource("/visao/TelaLogin.fxml");
            Parent TelaLogin = FXMLLoader.load(url);
            borderProva.setCenter(TelaLogin);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    @FXML private void addProva() throws SQLException{
       Date dn = Date.valueOf(this.campoData.getValue());
       p = new Prova(campoCategoria.getSelectionModel().getSelectedItem(),dn);
       pDAO.insertProva(p);
       limpar();
       recarrega();
    }
    
    private void addCategoria(){
        listCategoria.add("A");
        listCategoria.add("B");
        listCategoria.add("C");
        listCategoria.add("D");
        listCategoria.add("E");
    }
    
    private void limpar(){
     campoData.setValue(null);
     campoCategoria.setValue("Categoria");
    }
    
    @FXML private void listaProva(){
        listProva =  FXCollections.observableArrayList(pDAO.listProva());
        tabelaListar.getColumns().get(0).setCellValueFactory(new  PropertyValueFactory<>("categoria"));
        tabelaListar.getColumns().get(1).setCellValueFactory(new  PropertyValueFactory<>("dia_data"));
        tabelaListar.setItems(listProva);        
    }
  
    private void recarrega(){
        listProva.clear();
        listProva.addAll(pDAO.listProva());
        tabelaListar.setItems(listProva);
    }
    
    @FXML private void deletarProva() throws SQLException {      
        pDAO.deleteProva(tabelaListar.getSelectionModel().getSelectedItem().getId_prova());        
        recarrega();
        System.out.println("DELETEI");
    }
}
