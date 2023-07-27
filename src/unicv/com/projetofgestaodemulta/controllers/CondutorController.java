/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package unicv.com.projetofgestaodemulta.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;
import unicv.com.projetofgestaodemulta.model.Condutor;
import unicv.com.projetofgestaodemulta.service.ICondutorServices;
import unicv.com.projetofgestaodemulta.service.ServiceManager;
/*
Disciplina: PROGRAMAÇÃO ORIENTADA A OBJETOS
Projeto: Sistema de Gestão de Multa
Data Criação:‎28‎ de ‎junho‎ de ‎2023, ‏‎18:06:26
Data de Modificação:26 de julho de 2023
Versão:final
Autor: Leonardo Fonseca
Faculdade de Ciências e Tecnologias
Universidade de Cabo Verde
*/
public class CondutorController implements Initializable {

    @FXML
    private TableView<Condutor>  tblcondutor;

    @FXML
    private TableColumn<Condutor, Integer>  tcolidcondutor;

    @FXML
    private TableColumn<Condutor, String>  tcolNome;

    @FXML
    private TableColumn<Condutor, String>  tcolcni;

    @FXML
    private TableColumn<Condutor, String>  tcolsexo;

    @FXML
    private TableColumn<Condutor, Integer>  tcolidade;

    @FXML
    private TableColumn<Condutor, Integer>  tcolcontato;

    @FXML
    private TableColumn<Condutor, String> tcolilharesidencia;

    @FXML
    private TextField txtsexo;

    @FXML
    private TextField txtcni;

    @FXML
    private TextField txtnome;

    @FXML
    private TextField txtidade;

    @FXML
    private TextField txtcontato;

    @FXML
    private TextField txtilharesidencia;

    @FXML
    private Button btnAdicionar;

    @FXML
    private RadioButton rbIdcondutor;

    @FXML
    private RadioButton rbcni;

    @FXML
    private RadioButton rbTodos;

    @FXML
    private TextField txtBuscar;
    
    private ObservableList<Condutor> listaCondutores;

    private final List<Condutor> oldListaCondutores = new ArrayList<>();

    private final List<Condutor> toRemoveListaCondutores = new ArrayList<>();

    private ICondutorServices condutorService;

    public void handleRadioButtonAction() {
        txtBuscar.clear();
    }

    public void handleBuscarCondutorButtonAction()  {
        try {
            listaCondutores.clear();
            if (rbTodos.isSelected()) {
                txtBuscar.clear();
                oldListaCondutores.clear();
                listaCondutores.setAll(condutorService.findAll());
                oldListaCondutores.addAll(listaCondutores);
            } else if (!txtBuscar.getText().isBlank()) {
                if (rbIdcondutor.isSelected()) {
                    Optional<Condutor> condutor = condutorService.findById(Integer.parseInt(txtBuscar.getText()));
                    if (condutor.isPresent()) {
                        listaCondutores.setAll(condutor.get());
                    }
                } else if (rbcni.isSelected()) {
                    Optional<Condutor> condutor = condutorService.findByCNI((txtBuscar.getText()));
                    if (condutor.isPresent()) {
                        listaCondutores.setAll(condutor.get());
                    }
                } else {
                    int ID_condutor = Integer.parseInt(txtBuscar.getText());
                    Optional<Condutor> optionalCondutor = condutorService.findById(ID_condutor);
                    optionalCondutor.ifPresent((veiculo) -> {
                        listaCondutores.add(veiculo);
                    });
                }
            }
        } catch (NumberFormatException ex) {
            String mssg = "O valor inserido não tem o formato correto";
            showAlertMessage(Alert.AlertType.ERROR, "Erro",
                    "Erro buscando um veiculo", mssg);
        } catch (ServiceException ex) {
            Logger.getLogger(CondutorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void handleAdicionarButtonAction() {
        Condutor novoCondutor = new Condutor();
        listaCondutores.add(novoCondutor);
        tblcondutor.getSelectionModel().select(novoCondutor);
        tblcondutor.scrollTo(novoCondutor);
        tblcondutor.setDisable(true);
        btnAdicionar.setDisable(true);
        tblcondutor.setOpacity(1);
    }

    public void handleExcluirButtonAction() {
        if (tblcondutor.getSelectionModel().isEmpty()) {
            showAlertMessage(Alert.AlertType.ERROR, "Erro",
                    "Erro excluindo o condutor", "Deve selecionar um condutor");
        } else {
            toRemoveListaCondutores.add((Condutor) tblcondutor.getSelectionModel().getSelectedItem());
            listaCondutores.remove((Condutor)tblcondutor.getSelectionModel().getSelectedItem());
        }
    }

public void handleAtualizarButtonAction() {
    if (tblcondutor.getSelectionModel().isEmpty()) {
        showAlertMessage(Alert.AlertType.ERROR, "Erro",
                "Erro atualizando o condutor", "Deve selecionar um condutor");
    } else {
        try {
            Condutor selectedCondutor =  (Condutor) tblcondutor.getSelectionModel().getSelectedItem();
            selectedCondutor.setNomeCondutor((txtnome.getText()));
            selectedCondutor.setCNI(txtcni.getText());
            selectedCondutor.setSexo(txtsexo.getText());
            selectedCondutor.setIdade(Integer.parseInt(txtidade.getText()));
            selectedCondutor.setContato(Integer.parseInt(txtcontato.getText()));
            selectedCondutor.setIlharesidencia(txtilharesidencia.getText());
            if (selectedCondutor.getID_Condutor() == 0) {
                condutorService.add(selectedCondutor);
                showAlertMessage(Alert.AlertType.INFORMATION, "Informação",
                    "Condutor Adicionado ", "O Condutor foi atualizado com sucesso!");
            } else {
                condutorService.update(selectedCondutor);
                showAlertMessage(Alert.AlertType.INFORMATION, "Informação",
                    "Atualização do Condutor", "O Condutor foi atualizado com sucesso!");
            }
            for (Condutor condutor : toRemoveListaCondutores) {
                condutorService.remove(condutor.getID_Condutor());
            }
            oldListaCondutores.clear();
            oldListaCondutores.addAll(listaCondutores);
            tblcondutor.setDisable(false);
            btnAdicionar.setDisable(false);
            
           
        } catch (NumberFormatException ex) {
            String mssg = "Um dos valores inseridos não tem o formato correto";
            showAlertMessage(Alert.AlertType.ERROR, "Erro",
                    "Erro atualizando um condutor", mssg);
        } catch (ServiceException ex) {
            showAlertMessage(Alert.AlertType.ERROR, "Erro",
                    "Erro atualizando o condutor", ex.getMessage());
        }
    }
}


    public void handleCancelarButtonAction() {
        listaCondutores.clear();
        listaCondutores.setAll(oldListaCondutores);
        tblcondutor.setDisable(false);
        btnAdicionar.setDisable(false);
        toRemoveListaCondutores.clear();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        condutorService = ServiceManager.getServiceManager().getCondutorService();
        listaCondutores = FXCollections.observableArrayList();
        try {
            listaCondutores.addAll(condutorService.findAll());
            oldListaCondutores.addAll(listaCondutores);
        } catch (ServiceException ex) {
            showAlertMessage(Alert.AlertType.ERROR, "Erro",
                    "Erro carregando os Condutores", ex.getMessage());
        }
        tblcondutor.setItems(listaCondutores);
        tcolidcondutor.setCellValueFactory(new PropertyValueFactory<>("ID_Condutor"));
        tcolNome.setCellValueFactory(new PropertyValueFactory<>("NomeCondutor"));
        tcolcni.setCellValueFactory(new PropertyValueFactory<>("CNI"));
        tcolsexo.setCellValueFactory(new PropertyValueFactory<>("Sexo"));
        tcolidade.setCellValueFactory(new PropertyValueFactory<>("Idade"));
        tcolcontato.setCellValueFactory(new PropertyValueFactory<>("Contato"));
        tcolilharesidencia.setCellValueFactory(new PropertyValueFactory<>("ilharesidencia"));
        tblcondutor.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Condutor>() {
            @Override
            public void changed(javafx.beans.value.ObservableValue<? extends Condutor> ov, Condutor oldValue, Condutor newValue) {

                if (oldValue != null) {

                    txtnome.clear();
                    txtcni.clear();
                    txtsexo.clear();
                    txtidade.clear();
                    txtcontato.clear();
                    txtilharesidencia.clear();

                }
                if (newValue != null) {
                    txtnome.setText((newValue.getNomeCondutor()));
                    txtcni.setText(newValue.getCNI());
                    txtsexo.setText(newValue.getSexo());
                    txtidade.setText(Integer.toString(newValue.getIdade()));
                    txtcontato.setText(Integer.toString(newValue.getContato()));
                    txtilharesidencia.setText(newValue.getilharesidencia());
                }
            }
        });
    }

    private Optional<ButtonType> showAlertMessage(Alert.AlertType type, String title,
            String headerText, String mssg) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(mssg);
        return alert.showAndWait();
    }

}
