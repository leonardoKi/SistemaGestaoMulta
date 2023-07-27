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
import unicv.com.projetofgestaodemulta.model.Veiculo;
import unicv.com.projetofgestaodemulta.service.IVeiculoServices;
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
public class VeiculoController implements Initializable {

    @FXML
    private TableView<Veiculo> tblVeiculos;
    @FXML
    private TableColumn<Veiculo, Integer> tcolidveiculo;
    @FXML
    private TableColumn<Veiculo, String> tcolplaca;
    @FXML
    private TableColumn<Veiculo, Integer> tcolnumidentificacao;
    @FXML
    private TableColumn<Veiculo, LocalDate> tcolData;
    @FXML
    private TableColumn<Veiculo, Float> tcolpeso;
    @FXML
    private TableColumn<Veiculo, Integer> tcollotacao;
    @FXML
    private TableColumn<Veiculo, String> tcoldescricao;
    @FXML
    private TextField txtpeso;
    @FXML
    private TextField txtplaca;
    @FXML
    private TextField txtnumidentificacao;
    @FXML
    private TextField txtlotacao;
    @FXML
    private TextField txtdescricao;
    @FXML
    private DatePicker dtpData;
    @FXML
    private Button btnAdicionar;
    @FXML
    private RadioButton rbIdveiculo;
    @FXML
    private RadioButton rbPlaca;
    @FXML
    private RadioButton rbNumidentificacao;
    @FXML
    private RadioButton rbTodos;
    @FXML
    private TextField txtBuscar;

    private ObservableList<Veiculo> listaVeiculos;
    
    private final List<Veiculo> oldlistaVeiculos = new ArrayList<>();
    
    private final List<Veiculo> toRemovelistaVeiculos = new ArrayList<>();
    
    private IVeiculoServices veiculoService;

    // limpa o handle buscar por conteudo
    public void handleRadioButtonAction() {
        txtBuscar.clear();
    }
// buscar por uma determinada opção

public void handleBuscarVeiculoButtonAction() {
    try {
        listaVeiculos.clear();
        if (rbTodos.isSelected()) {
            txtBuscar.clear();
            oldlistaVeiculos.clear();
            listaVeiculos.setAll(veiculoService.findAll());
            oldlistaVeiculos.addAll(listaVeiculos);
        } else if (!txtBuscar.getText().isBlank()) {
            if (rbIdveiculo.isSelected()) {
                Optional<Veiculo> optionalVeiculo = veiculoService.findById(Integer.parseInt(txtBuscar.getText()));
                optionalVeiculo.ifPresent((veiculo) -> {
                    listaVeiculos.add(veiculo);
                });
            } else if (rbNumidentificacao.isSelected()) {
                listaVeiculos.setAll(veiculoService.findByIdentificacao(Integer.parseInt(txtBuscar.getText())));
            } else if (rbPlaca.isSelected()) {
                Optional<Veiculo> optionalVeiculo = veiculoService.findByPlaca(txtBuscar.getText());
                optionalVeiculo.ifPresent((veiculo) -> {
                    listaVeiculos.add(veiculo);
                });
            } else {
                int idveiculo = Integer.parseInt(txtBuscar.getText());
                Optional<Veiculo> optionalVeiculo = veiculoService.findById(idveiculo);
                optionalVeiculo.ifPresent((veiculo) -> {
                    listaVeiculos.add(veiculo);
                });
            }
        }
    } catch (NumberFormatException ex) {
        String mssg = "O valor inserido não tem o formato correto";
        showAlertMessage(Alert.AlertType.ERROR, "Error",
                "Erro buscando um veiculo", mssg);
    } catch (ServiceException ex) {
        showAlertMessage(Alert.AlertType.ERROR, "Error",
                "Erro buscando um veiculo", ex.getMessage());
    }
}


    public void handleAdicionarButtonAction() {// metodo adicionar 
        Veiculo novoartigo = new Veiculo();
        listaVeiculos.add(novoartigo);
        tblVeiculos.getSelectionModel().select(novoartigo);
        tblVeiculos.scrollTo(novoartigo);
        tblVeiculos.setDisable(true);
        btnAdicionar.setDisable(true);
        tblVeiculos.setOpacity(1);
    }

    public void handleExcluirButtonAction() {// metodo excluir 
        if (tblVeiculos.getSelectionModel().isEmpty()) {
            showAlertMessage(Alert.AlertType.ERROR, "Error",
                    "Error excluindo o veiculo", "Deve selecionar um Veiculo");
        } else {
            toRemovelistaVeiculos.add(tblVeiculos.getSelectionModel().getSelectedItem());
            listaVeiculos.remove(tblVeiculos.getSelectionModel().getSelectedItem());
        }

    }

  public void handleAtualizarButtonAction() {
    if (tblVeiculos.getSelectionModel().isEmpty()) {
        showAlertMessage(Alert.AlertType.ERROR, "Error",
                "Error atualizando o veiculo", "Deve selecionar um Veiculo");
    } else {
        try {
            Veiculo selectedVeiculo = tblVeiculos.getSelectionModel().getSelectedItem();
            selectedVeiculo.setPlaca((txtplaca.getText()));
            selectedVeiculo.setNum_Identificao(Integer.parseInt(txtnumidentificacao.getText()));
            selectedVeiculo.setDataExpecao(dtpData.getValue());
            selectedVeiculo.setPeso(Float.parseFloat(txtpeso.getText()));
            selectedVeiculo.setLotacao(Integer.parseInt(txtlotacao.getText()));
            selectedVeiculo.setDescricao((txtdescricao.getText()));
            if (selectedVeiculo.getID_Veiculo() == 0) {
                veiculoService.add(selectedVeiculo);
                showAlertMessage(Alert.AlertType.INFORMATION, "Informação",
                    "Veículo Adicionado ", "O veículo foi atualizado com sucesso!");
            } else {
                veiculoService.update(selectedVeiculo);
                showAlertMessage(Alert.AlertType.INFORMATION, "Informação",
                    "Atualização do Veículo", "O veículo foi atualizado com sucesso!");
            }
            for (Veiculo veiculo : toRemovelistaVeiculos) {
                veiculoService.remove(veiculo.getID_Veiculo());
            }
            oldlistaVeiculos.clear();
            oldlistaVeiculos.addAll(listaVeiculos);
            tblVeiculos.setDisable(false);
            btnAdicionar.setDisable(false);
             
        } catch (NumberFormatException ex) {
            String mssg = "Um dos valores inseridos não tem o formato correto";
            showAlertMessage(Alert.AlertType.ERROR, "Error",
                    "Erro atualozando um Veiculo", mssg);
        } catch (ServiceException ex) {
            showAlertMessage(Alert.AlertType.ERROR, "Error",
                    "Error atualizando o Veiculo", ex.getMessage());
        }
    }
}


    public void handleCancelarButtonAction() {
        listaVeiculos.clear();
        listaVeiculos.setAll(oldlistaVeiculos);
        tblVeiculos.setDisable(false);
        btnAdicionar.setDisable(false);
        toRemovelistaVeiculos.clear();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        veiculoService = ServiceManager.getServiceManager().getVeiculoService();
        listaVeiculos = FXCollections.emptyObservableList();
        try {
            listaVeiculos = FXCollections.observableList(veiculoService.findAll());
            oldlistaVeiculos.addAll(listaVeiculos);
        } catch (ServiceException ex) {
            showAlertMessage(Alert.AlertType.ERROR, "Erro", "Erro carregando os Veiculos", ex.getMessage());
        }

        tblVeiculos.setItems(listaVeiculos);

        tcolidveiculo.setCellValueFactory(new PropertyValueFactory<>("ID_Veiculo"));
        tcolplaca.setCellValueFactory(new PropertyValueFactory<>("Placa"));
        tcolnumidentificacao.setCellValueFactory(new PropertyValueFactory<>("Num_Identificao"));
        tcolData.setCellValueFactory(new PropertyValueFactory<>("DataExpecao"));
        tcolpeso.setCellValueFactory(new PropertyValueFactory<>("Peso"));        
        tcollotacao.setCellValueFactory(new PropertyValueFactory<>("Lotacao"));
        tcoldescricao.setCellValueFactory(new PropertyValueFactory<>("Descricao"));

        tblVeiculos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Veiculo>() {
            @Override
            public void changed(ObservableValue<? extends Veiculo> ov, Veiculo oldValue, Veiculo newValue) {
                if (oldValue != null) {
                    txtplaca.clear();
                    txtnumidentificacao.clear();
                    dtpData.setValue(null);
                    txtpeso.clear();
                    txtlotacao.clear();
                    txtdescricao.clear();
                }
                if (newValue != null) {
                    txtplaca.setText(newValue.getPlaca());
                    txtnumidentificacao.setText(Integer.toString(newValue.getNum_Identificao()));
                    dtpData.setValue(newValue.getDataExpecao());
                    txtpeso.setText(Float.toString(newValue.getPeso()));
                    txtlotacao.setText(Integer.toString(newValue.getLotacao()));
                    txtdescricao.setText(newValue.getDescricao());
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
