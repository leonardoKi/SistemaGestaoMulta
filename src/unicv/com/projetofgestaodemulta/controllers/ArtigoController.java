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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import unicv.com.projetofgestaodemulta.model.Artigo;
import unicv.com.projetofgestaodemulta.service.IArtigoServices;
import unicv.com.projetofgestaodemulta.service.ServiceManager;
/**
 * FXML Controller class
Disciplina: PROGRAMAÇÃO ORIENTADA A OBJETOS
Projeto: Sistema de Gestão de Multa
Data Criação:‎28‎ de ‎junho‎ de ‎2023, ‏‎18:06:26
Data de Modificação:26 de julho de 2023
Versão:final
Autor: Leonardo Fonseca
Faculdade de Ciências e Tecnologias
Universidade de Cabo Verde
*/
public class ArtigoController implements Initializable {

    @FXML
    private TableView<Artigo> tblArtigo;
    @FXML
    private TableColumn<Artigo, Integer> tcolidArtigo;
    @FXML
    private TableColumn<Artigo, Float> tcolValorMulta;
    @FXML
    private TableColumn<Artigo, Integer> tcolnumartigo;
    @FXML
    private TableColumn<Artigo, Integer> tcolPontos;
    @FXML
    private TextField txtnumArtigo;
    @FXML
    private TextField txtValorMulta;
    @FXML
    private TextField txtPontos;
    @FXML
    private Button btnAdicionar;
    @FXML
    private RadioButton rbidArtigo;
    @FXML
    private RadioButton rbValor;
    @FXML
    private RadioButton rbTodos;
    @FXML
    private TextField txtBuscar;
    
    private ObservableList<Artigo> listaArtigos;
    
    private final List<Artigo> oldListaArtigos = new ArrayList<>();
    
    private final List<Artigo> toRemoveListaArtigos = new ArrayList<>();
    
    private IArtigoServices artigoService;

    // limpa o handle buscar por conteudo
    public void handleRadioButtonAction() {
        txtBuscar.clear();
    }
// buscar por uma determinada opção
    public void handleBuscarArtigoButtonAction() {
    try {
        listaArtigos.clear();
        if (rbTodos.isSelected()) {
            txtBuscar.clear();
            oldListaArtigos.clear();
            listaArtigos.setAll(artigoService.findAll());
            oldListaArtigos.addAll(listaArtigos);
        } else if (!txtBuscar.getText().isBlank()) {
            if (rbidArtigo.isSelected()) {
                Optional<Artigo> artigo = artigoService.findById(Integer.parseInt(txtBuscar.getText()));
                if (artigo.isPresent()) {
                    listaArtigos.setAll(artigo.get());
                }
            } else if (rbValor.isSelected()) {
                listaArtigos.setAll(artigoService.findByValor(Float.parseFloat(txtBuscar.getText())));
            } else {
                int ID_Artigo = Integer.parseInt(txtBuscar.getText());
                Optional<Artigo> optionalArtigo = artigoService.findById(ID_Artigo);
                optionalArtigo.ifPresent((artigo) -> {
                    listaArtigos.add(artigo);
                });
            }
        }
    } catch (NumberFormatException ex) {
        String mssg = "O valor inserido não tem o formato correto";
        showAlertMessage(Alert.AlertType.ERROR, "Erro",
                "Erro buscando um artigo", mssg);
    } catch (ServiceException ex) {
        showAlertMessage(Alert.AlertType.ERROR, "Erro",
                "Erro buscando um artigo", ex.getMessage());
    }
}


    public void handleAdicionarButtonAction() {// metodo adicionar 
        Artigo novoartigo = new Artigo();
        listaArtigos.add(novoartigo);
        tblArtigo.getSelectionModel().select(novoartigo);
        tblArtigo.scrollTo(novoartigo);
        tblArtigo.setDisable(true);
        btnAdicionar.setDisable(true);
        tblArtigo.setOpacity(1);
    }

    public void handleExcluirButtonAction() {// metodo excluir 
        if (tblArtigo.getSelectionModel().isEmpty()) {
            showAlertMessage(Alert.AlertType.ERROR, "Error",
                    "Error excluindo o artigo", "Deve selecionar um artigo");
        } else {
            toRemoveListaArtigos.add(tblArtigo.getSelectionModel().getSelectedItem());
            listaArtigos.remove(tblArtigo.getSelectionModel().getSelectedItem());
        }

    }

public void handleAtualizarButtonAction() {
    if (tblArtigo.getSelectionModel().isEmpty()) {
        showAlertMessage(Alert.AlertType.ERROR, "Error",
                "Error atualizando o artigo", "Deve selecionar um artigo");
    } else {
        try {
            Artigo selectedArtigo = tblArtigo.getSelectionModel().getSelectedItem();
            selectedArtigo.setNum_Artigo(Integer.parseInt(txtnumArtigo.getText()));
            selectedArtigo.setNum_Pontos(Integer.parseInt(txtPontos.getText()));
            selectedArtigo.setValorMulta(Float.valueOf(txtValorMulta.getText()));
            if (selectedArtigo.getID_Artigo()== 0) {
                artigoService.add(selectedArtigo);
                  showAlertMessage(Alert.AlertType.INFORMATION, "Informação",
                    "Artigo Adicionado", "O artigo foi atualizado com sucesso!");
            } else {
                artigoService.update(selectedArtigo);
                  showAlertMessage(Alert.AlertType.INFORMATION, "Informação",
                    "Atualização do Artigo", "O artigo foi atualizado com sucesso!");
            }
            for (Artigo artigo : toRemoveListaArtigos) {
                artigoService.remove(artigo.getID_Artigo());
            }
            oldListaArtigos.clear();
            oldListaArtigos.addAll(listaArtigos);
            tblArtigo.setDisable(false);
            btnAdicionar.setDisable(false);
        } catch (NumberFormatException ex) {
            String mssg = "Um dos valores inseridos não tem o formato correto";
            showAlertMessage(Alert.AlertType.ERROR, "Error",
                    "Erro atualozando um artigo", mssg);
        } catch (ServiceException ex) {
            showAlertMessage(Alert.AlertType.ERROR, "Error",
                    "Error atualizando o artigo", ex.getMessage());
        }
    }
}

    public void handleCancelarButtonAction() {
        listaArtigos.clear();
        listaArtigos.setAll(oldListaArtigos);
        tblArtigo.setDisable(false);
        btnAdicionar.setDisable(false);
        toRemoveListaArtigos.clear();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        artigoService = ServiceManager.getServiceManager().getArtigoService();
        listaArtigos = FXCollections.emptyObservableList();
        try {
            listaArtigos = FXCollections.observableList(artigoService.findAll());
            oldListaArtigos.addAll(listaArtigos);
        } catch (ServiceException ex) {
            showAlertMessage(Alert.AlertType.ERROR, "Erro",
                    "Erro carregando os Artigos", ex.getMessage());
        }
        tblArtigo.setItems(listaArtigos);
        tcolidArtigo.setCellValueFactory(new PropertyValueFactory<>("ID_Artigo"));
        tcolValorMulta.setCellValueFactory(new PropertyValueFactory<>("ValorMulta"));
        tcolPontos.setCellValueFactory(new PropertyValueFactory<>("Num_Pontos"));
        tcolnumartigo.setCellValueFactory(new PropertyValueFactory<>("Num_Artigo"));
        tblArtigo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Artigo>() {
            @Override
            public void changed(ObservableValue<? extends Artigo> ov, Artigo oldValue, Artigo newValue) {
                if (oldValue != null) {
                    txtnumArtigo.clear();
                    txtValorMulta.clear();
                    txtPontos.clear();
                }
                if (newValue != null) {
                    txtnumArtigo.setText(Integer.toString(newValue.getNum_Artigo()));
                    txtValorMulta.setText(Float.toString(newValue.getValorMulta()));
                    txtPontos.setText(Integer.toString(newValue.getNum_Pontos()));
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
