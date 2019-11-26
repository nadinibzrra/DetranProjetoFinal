/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Clara
 */
public class TelaProvaController implements Initializable {

    @FXML
    private JFXDatePicker campoData;
    @FXML
    private JFXComboBox<?> campoCategoria;
    @FXML
    private TableView<?> tabelaListar;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
