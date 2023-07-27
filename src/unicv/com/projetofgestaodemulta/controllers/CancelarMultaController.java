/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package unicv.com.projetofgestaodemulta.controllers;

import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;
import unicv.com.projetofgestaodemulta.model.Pagamento;
import unicv.com.projetofgestaodemulta.service.IPagamentoServices;
import unicv.com.projetofgestaodemulta.service.ServiceManager;

/**
 * FXML Controller class Disciplina: PROGRAMAÇÃO ORIENTADA A OBJETOS Projeto:
 * Sistema de Gestão de Multa Data Criação:‎28‎ de ‎junho‎ de ‎2023, ‏‎18:06:26
 * Data de Modificação:26 de julho de 2023 Versão:final Autor: Leonardo Fonseca
 * Faculdade de Ciências e Tecnologias Universidade de Cabo Verde
 */
public class CancelarMultaController implements Initializable {

    // Declara uma tabela de visualização para exibir as Pagamento
    @FXML
    private TableView<Pagamento> tblCancelamento;
    // Declara uma coluna para exibir o ID 
    @FXML
    private TableColumn<Pagamento, Integer> tcolidpagamento;
    // Declara uma coluna para exibir a valor pagamento
    @FXML
    private TableColumn<Pagamento, Float> tcolvalorpagar;
    // Declara uma coluna para exibir a data pagamento
    @FXML
    private TableColumn<Pagamento, LocalDate> tcoldata;
    // Declara uma coluna para exibir o estado do pagamento
    @FXML
    private TableColumn<Pagamento, Boolean> tcolestado;
    // Declara um botão para adicionar uma novo pagamento
    @FXML
    private Button btnAdicionar;
    // Declara um botão de rádio para buscar por id pagamento
    @FXML
    private RadioButton rbidpagamento;
    // Declara um botão de rádio para buscar data
    @FXML
    private RadioButton rbdata;
    // Declara um botão de rádio para buscar estado
    @FXML
    private RadioButton rbestado;
    // Declara um botão de rádio para buscar todos os pagamento
    @FXML
    private RadioButton rbTodos;
    // Declara um campo de texto para inserir o valor a ser buscado
    @FXML
    private TextField txtBuscar;
    // Declara um campo de texto para inserir estado
    @FXML
    private TextField txtestado;
    // Declara um campo de texto para inserir valor pagar
    @FXML
    private TextField txtvalorpagar;
    // Declara um campo de texto para buscar data
    @FXML
    private DatePicker dtpBuscar;
    // Declara um campo de texto para inserir data
    @FXML
    private DatePicker dtpdata;

    // Declara uma lista observável para armazenar
    private ObservableList<Pagamento> listapagamento;

    private final List<Pagamento> oldListapagamento = new ArrayList<>();

    private final List<Pagamento> toRemoveListapagamentos = new ArrayList<>();
    
    private IPagamentoServices pagamentoService;

    // limpa o handle buscar por conteudo
    public void handleRadioButtonAction() {
        txtBuscar.clear();
    }
// buscar por uma determinada opção

    public void handleBuscarPagamentoButtonAction() {
        try {
            listapagamento.clear();
            if (rbTodos.isSelected()) {
                txtBuscar.clear();
                oldListapagamento.clear();
                listapagamento.setAll(pagamentoService.findAll());
                oldListapagamento.addAll(listapagamento);
            } else if (!txtBuscar.getText().isBlank()) {
                if (rbidpagamento.isSelected()) {
                    Optional<Pagamento> pagamento = pagamentoService.findById(Integer.parseInt(txtBuscar.getText()));
                    if (pagamento.isPresent()) {
                        listapagamento.add(pagamento.get());
                    }
                } else if (rbdata.isSelected()) {
                    LocalDate data = dtpBuscar.getValue();
                    Optional<Pagamento> optionalPagamento = pagamentoService.findByDataPagamento(data);
                    if (optionalPagamento.isPresent()) {
                        listapagamento.add(optionalPagamento.get());
                    }
                } else if (rbestado.isSelected()) {
                    listapagamento.setAll(pagamentoService.findByEstado(Boolean.parseBoolean(txtBuscar.getText())));
                } else {
                    int ID_Pagamento = Integer.parseInt(txtBuscar.getText());
                    Optional<Pagamento> optionalpagamento = pagamentoService.findById(ID_Pagamento);
                    optionalpagamento.ifPresent((pagamento) -> {
                        listapagamento.add(pagamento);
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
        Pagamento novopagamento = new Pagamento();
        listapagamento.add(novopagamento);
        tblCancelamento.getSelectionModel().select(novopagamento);
        tblCancelamento.scrollTo(novopagamento);
        tblCancelamento.setDisable(true);
        btnAdicionar.setDisable(true);
        tblCancelamento.setOpacity(1);
    }

    public void handleExcluirButtonAction() {// metodo excluir 
        if (tblCancelamento.getSelectionModel().isEmpty()) {
            showAlertMessage(Alert.AlertType.ERROR, "Error",
                    "Error excluindo o artigo", "Deve selecionar um Pagamento");
        } else {
            toRemoveListapagamentos.add(tblCancelamento.getSelectionModel().getSelectedItem());
            listapagamento.remove(tblCancelamento.getSelectionModel().getSelectedItem());
        }

    }

    public void handleAtualizarButtonAction() {
        if (tblCancelamento.getSelectionModel().isEmpty()) {
            showAlertMessage(Alert.AlertType.ERROR, "Error",
                    "Error atualizando o artigo", "Deve selecionar um Pagamento");
        } else {
            try {
                Pagamento selectedPagamento = tblCancelamento.getSelectionModel().getSelectedItem();
                selectedPagamento.setValorPagar(Float.parseFloat(txtvalorpagar.getText()));
                selectedPagamento.setDataPagamento((dtpdata.getValue()));
                selectedPagamento.setEstado(Boolean.valueOf(txtestado.getText()));
                if (selectedPagamento.getID_Pagamento() == 0) {
                    pagamentoService.add(selectedPagamento);
                    showAlertMessage(Alert.AlertType.INFORMATION, "Informação",
                            "Pagamento Adicionado", "O pagamento foi atualizado com sucesso!");
                } else {
                    pagamentoService.update(selectedPagamento);
                    showAlertMessage(Alert.AlertType.INFORMATION, "Informação",
                            "Atualização do Pagamento", "O pagamento foi atualizado com sucesso!");
                }
                for (Pagamento pagamento : toRemoveListapagamentos) {
                    pagamentoService.remove(pagamento.getID_Pagamento());
                }
                oldListapagamento.clear();
                oldListapagamento.addAll(listapagamento);
                tblCancelamento.setDisable(false);
                btnAdicionar.setDisable(false);

            } catch (NumberFormatException ex) {
                String mssg = "Um dos valores inseridos não tem o formato correto";
                showAlertMessage(Alert.AlertType.ERROR, "Error",
                        "Erro atualozando um Pagamento", mssg);
            } catch (ServiceException ex) {
                showAlertMessage(Alert.AlertType.ERROR, "Error",
                        "Error atualizando o Pagamento", ex.getMessage());
            }
        }
    }

    public void handleCancelarButtonAction() {
        listapagamento.clear();
        listapagamento.setAll(oldListapagamento);
        tblCancelamento.setDisable(false);
        btnAdicionar.setDisable(false);
        toRemoveListapagamentos.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        pagamentoService = ServiceManager.getServiceManager().getPagamentoService();
        listapagamento = FXCollections.emptyObservableList();
        try {
            listapagamento = FXCollections.observableList(pagamentoService.findAll());
            oldListapagamento.addAll(listapagamento);
        } catch (ServiceException ex) {
            showAlertMessage(Alert.AlertType.ERROR, "Erro",
                    "Erro carregando os Pagamento", ex.getMessage());
        }
        tblCancelamento.setItems(listapagamento);
        tcolidpagamento.setCellValueFactory(new PropertyValueFactory<>("ID_Pagamento"));
        tcolvalorpagar.setCellValueFactory(new PropertyValueFactory<>("ValorPagar"));
        tcoldata.setCellValueFactory(new PropertyValueFactory<>("DataPagamento"));
        tcolestado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tblCancelamento.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pagamento>() {
            @Override
            public void changed(ObservableValue<? extends Pagamento> ov, Pagamento oldValue, Pagamento newValue) {
                if (oldValue != null) {
                    txtvalorpagar.clear();
                    dtpdata.setValue(null);
                    txtestado.clear();
                }
                if (newValue != null) {
                    txtvalorpagar.setText(Float.toString(newValue.getValorPagar()));
                    dtpdata.setValue(newValue.getDataPagamento());
                    txtestado.setText(Boolean.toString(newValue.getEstado()));
                }
            }
        }
        );
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
