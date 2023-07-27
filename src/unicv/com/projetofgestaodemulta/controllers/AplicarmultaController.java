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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LocalDateStringConverter;
import unicv.com.projetofgestaodemulta.execeptions.ServiceException;
import unicv.com.projetofgestaodemulta.model.Artigo;
import unicv.com.projetofgestaodemulta.model.Multa;
import unicv.com.projetofgestaodemulta.service.IArtigoServices;
import unicv.com.projetofgestaodemulta.service.IMultaServices;
import unicv.com.projetofgestaodemulta.service.ServiceManager;

/*
 * FXML Controller class
 * @author Leonardo Fonseca
 */

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

public class AplicarmultaController implements Initializable {

// Declara uma tabela de visualização para exibir as multas
@FXML
private TableView <Multa>  tblMulta;

// Declara uma coluna para exibir o ID da multa
@FXML
private TableColumn <Multa, Integer>  tcolIDmulta;

// Declara uma coluna para exibir a seção da multa
@FXML
private TableColumn <Multa, String>  tcolSeccao;

// Declara uma coluna para exibir a data da multa
@FXML
private TableColumn <Multa, LocalDate>  tcolDatMulta;

// Declara uma coluna para exibir o artigo da multa
@FXML
private TableColumn <Multa , Artigo >  tcolArtigo;

// Declara um campo de texto para inserir a seção da multa
@FXML
private TextField txtseccao;

// Declara um seletor de data para buscar as multas por data
@FXML
private DatePicker dtpBuscar;

// Declara um combo box para selecionar o artigo da multa
@FXML
private ComboBox<Artigo> cmbArtigo;

// Declara um botão para adicionar uma nova multa
@FXML
private Button btnAdicionar;

// Declara um botão de rádio para buscar as multas por ID
@FXML
private RadioButton rbidmulta;

// Declara um botão de rádio para buscar as multas por data
@FXML
private RadioButton rbdata;

// Declara um seletor de data para inserir a data da multa
@FXML
private DatePicker dtpData;

// Declara um botão de rádio para buscar todas as multas
@FXML
private RadioButton rbTodos;

// Declara um campo de texto para inserir o valor a ser buscado
@FXML
private TextField txtBuscar;

// Declara uma lista observável para armazenar as multas
private ObservableList<Multa> listaMulta;

// Declara uma lista observável para armazenar os artigos
private ObservableList<Artigo> listaArtigo;

// Declara uma lista auxiliar para armazenar as multas antigas
private final List<Multa> oldListaMulta = new ArrayList<>();

// Declara uma lista auxiliar para armazenar as multas a serem removidas
private final List<Multa> toRemoveListaMulta = new ArrayList<>();

// Declara um serviço de interface para gerenciar as operações com as multas
private IMultaServices multaService;

 // Declara um serviço de interface para gerenciar as operações com os artigos   
 private IArtigoServices artigoServices;

 // Define um método para lidar com a ação dos botões de rádio 
 public void handleRadioButtonAction() {
     txtBuscar.clear();
 }

// Define um método para lidar com a ação do botão de buscar multa
public void handleBuscarMultaButtonAction() {
    try {
        // Limpa a lista de multas
        listaMulta.clear();
        // Se o botão de rádio de todos estiver selecionado
        if (rbTodos.isSelected()) {
            // Limpa o campo de texto de busca
            txtBuscar.clear();
            // Limpa a lista auxiliar de multas antigas
            oldListaMulta.clear();
            // Limpa o seletor de data de busca
            dtpBuscar.setValue(null);
            // Preenche a lista de multas com todas as multas do serviço
            listaMulta.setAll(multaService.findAll());
            // Adiciona todas as multas na lista auxiliar de multas antigas
            oldListaMulta.addAll(listaMulta);
        // Se o botão de rádio de data estiver selecionado
        } else if (rbdata.isSelected()) {
            // Obtém a data do seletor de data de busca
            LocalDate data = dtpBuscar.getValue();
            // Busca uma multa opcional pelo serviço com a data informada
            Optional<Multa> optionalMulta = multaService.findByDataMulta(data);
            // Se encontrar uma multa, adiciona na lista de multas
            if(optionalMulta.isPresent()) {
                listaMulta.add(optionalMulta.get());
            }
        // Se o campo de texto de busca não estiver vazio
        } else if (!txtBuscar.getText().isBlank()) {
            // Se o botão de rádio de ID estiver selecionado
            if (rbidmulta.isSelected()) {
                // Converte o valor do campo de texto em um inteiro
                int idmulta = Integer.parseInt(txtBuscar.getText());
                // Busca uma multa opcional pelo serviço com o ID informado
                Optional<Multa> optionalMulta = multaService.findById(idmulta);
                // Se encontrar uma multa, adiciona na lista de multas
                optionalMulta.ifPresent((multa) -> {
                    listaMulta.add(multa);
                });
            }
        }
    } catch (NumberFormatException ex) {
        // Exibe uma mensagem de erro se houver algum problema ao converter o valor do campo de texto em um inteiro
        String mssg = "O valor inserido não tem o formato correto";
        showAlertMessage(Alert.AlertType.ERROR, "Error",
                "Erro buscando um Multa", mssg);
    } catch (ServiceException ex) {
        // Exibe uma mensagem de erro se houver algum problema ao buscar as multas pelo serviço
        showAlertMessage(Alert.AlertType.ERROR, "Error",
                "Erro buscando um Multa", ex.getMessage());
    }
}

// Define um método para lidar com a ação do botão de adicionar multa
public void handleAdicionarButtonAction() {
    // Cria uma nova multa vazia
    Multa novoMulta = new Multa();
    // Adiciona a nova multa na lista de multas
    listaMulta.add(novoMulta);
    // Seleciona a nova multa na tabela de visualização
    tblMulta.getSelectionModel().select(novoMulta);
    // Rola a tabela para mostrar a nova multa
    tblMulta.scrollTo(novoMulta);
    // Desabilita a tabela e o botão de adicionar para evitar alterações indevidas
    tblMulta.setDisable(true);
    tblMulta.setDisable(true);
    btnAdicionar.setDisable(true);
    tblMulta.setOpacity(1);
}

// Define um método para lidar com a ação do botão de excluir multa
public void handleExcluirButtonAction() {
    // Se não houver nenhuma multa selecionada na tabela, exibe uma mensagem de erro
    if (tblMulta.getSelectionModel().isEmpty()) {
        showAlertMessage(Alert.AlertType.ERROR, "Error",
                "Error excluindo o Multa", "Deve selecionar um Multa");
    } else {
        // Adiciona a multa selecionada na lista auxiliar de multas a serem removidas
        toRemoveListaMulta.add( tblMulta.getSelectionModel().getSelectedItem());
        // Remove a multa selecionada da lista de multas
         listaMulta.remove( tblMulta.getSelectionModel().getSelectedItem());
        }
    }

// Define um método para lidar com a ação do botão de atualizar multa
public void handleAtualizarButtonAction() {
    // Se não houver nenhuma multa selecionada na tabela, exibe uma mensagem de erro
    if (tblMulta.getSelectionModel().isEmpty()) {
        showAlertMessage(Alert.AlertType.ERROR, "Error",
                "Error atualizando a Multa", "Deve selecionar um Multa");
    } else {
        try {
            // Obtém a multa selecionada na tabela
            Multa selectdoMulta =   tblMulta.getSelectionModel().getSelectedItem();
            // Atualiza os dados da multa selecionada com os valores dos campos de texto e do seletor de data
            selectdoMulta.setSeccao((txtseccao.getText()));
            selectdoMulta.setDataMulta(dtpData.getValue());
            selectdoMulta.setArtigos(cmbArtigo.getValue());
            // Se o ID da multa selecionada for zero, significa que é uma nova multa
            if (selectdoMulta.getID_Multa() == 0) {
                // Adiciona a nova multa pelo serviço
                multaService.add(selectdoMulta);
                // Exibe uma mensagem de informação de que a multa foi aplicada com sucesso
                showAlertMessage(Alert.AlertType.INFORMATION, "Informação",
                    " Multa Aplicada", "A multa foi aplicada com sucesso!");

            // Se o ID da multa selecionada não for zero, significa que é uma multa existente
            } else {
                // Atualiza a multa existente pelo serviço
                multaService.update(selectdoMulta);
                // Exibe uma mensagem de informação de que a multa foi atualizada com sucesso
                showAlertMessage(Alert.AlertType.INFORMATION, "Informação",
                    "Atualização da Multa", "A multa foi atualizada com sucesso!");
            }
            // Para cada multa na lista auxiliar de multas a serem removidas
            for (Multa multa : toRemoveListaMulta) {
                // Remove a multa pelo serviço
                multaService.remove(multa.getID_Multa());
            }
            // Limpa a lista auxiliar de multas antigas
            oldListaMulta.clear();
            // Adiciona todas as multas na lista auxiliar de multas antigas
            oldListaMulta.addAll(listaMulta);
            // Habilita a tabela e o botão de adicionar para permitir novas alterações
            tblMulta.setDisable(false);
            btnAdicionar.setDisable(false);
        } catch (NumberFormatException ex) {
            // Exibe uma mensagem de erro se houver algum problema ao converter o valor do campo de texto em um inteiro
            String mssg = "Um dos valores inseridos não tem o formato correto";
            showAlertMessage(Alert.AlertType.ERROR, "Error",
                    "Erro atualizando um Multas", mssg);
        } catch (ServiceException ex) {
            // Exibe uma mensagem de erro se houver algum problema ao atualizar as multas pelo serviço
            showAlertMessage(Alert.AlertType.ERROR, "Error",
                    "Error atualizando o Artigo", ex.getMessage());
        }
    }
}

// Define um método para lidar com a ação do botão de cancelar
public void handleCancelarButtonAction() {
    // Limpa a lista de multas
    listaMulta.clear();
    // Preenche a lista de multas com as multas da lista auxiliar de multas antigas
    listaMulta.setAll(oldListaMulta);
    // Habilita a tabela e o botão de adicionar para permitir novas alterações
    tblMulta.setDisable(false);
    btnAdicionar.setDisable(false);
    // Limpa a lista auxiliar de multas a serem removidas
    toRemoveListaMulta.clear();
}


    /**
     * Initializes the controller class.
     */
  // Define um método para inicializar a interface gráfica
@Override
public void initialize(URL url, ResourceBundle rb) {

    // Obtém os serviços de interface para as multas e os artigos
    multaService = ServiceManager.getServiceManager().getMultaService();
    artigoServices = ServiceManager.getServiceManager().getArtigoService();
    // Cria as listas observáveis para as multas e os artigos
    listaMulta = FXCollections.observableArrayList();
    listaArtigo = FXCollections.observableArrayList();
    try {
        // Preenche a lista de multas com todas as multas do serviço
        listaMulta.setAll(multaService.findAll());
    } catch (ServiceException ex) {
        // Exibe uma mensagem de erro se houver algum problema ao carregar as multas
        showAlertMessage(Alert.AlertType.ERROR, "Erro",
                "Erro carregando as multas", ex.getMessage());
    }
    try {
        // Preenche a lista de artigos com todos os artigos do serviço
        listaArtigo.setAll(artigoServices.findAll());
    } catch (ServiceException ex) {
        // Exibe uma mensagem de erro se houver algum problema ao carregar os artigos
        showAlertMessage(Alert.AlertType.ERROR, "Erro",
                "Erro carregando os artigos", ex.getMessage());
    }
    // Define a lista de multas como a fonte de dados da tabela de visualização
    tblMulta.setItems(listaMulta);
    // Define as propriedades das células das colunas da tabela de visualização
    tcolIDmulta.setCellValueFactory(new PropertyValueFactory<>("ID_Multa"));
    tcolSeccao.setCellValueFactory(new PropertyValueFactory<>("Seccao"));
    tcolDatMulta.setCellValueFactory(new PropertyValueFactory<>("DataMulta"));
    tcolArtigo.setCellValueFactory(new PropertyValueFactory<>("Artigo"));

    // Define as células das colunas como campos de texto editáveis com conversores de tipos
    tcolIDmulta.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
    tcolDatMulta.setCellFactory(TextFieldTableCell.forTableColumn(new LocalDateStringConverter()));
    
    // Define um conversor de string para o tipo Artigo
    StringConverter<Artigo> artigoStringConverter = new StringConverter<>() {
        @Override
        public String toString(Artigo t) {
            String valueToDisplay = null;
            if (t != null) {
                valueToDisplay = "Artigo " + t.getNum_Artigo();
            }
            return valueToDisplay;
        }

        @Override
        public Artigo fromString(String string) {
            return null;
        }
    };
    
    // Define a célula da coluna de artigos como um campo de texto editável com o conversor de string definido acima
    tcolArtigo.setCellFactory(TextFieldTableCell.forTableColumn(artigoStringConverter));
    
    // Adiciona um listener para a propriedade de item selecionado na tabela de visualização
    tblMulta.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Multa>() {
        @Override
        public void changed(ObservableValue<? extends Multa> ov, Multa oldValue, Multa newValue) {
        
        // Se houver um valor antigo, limpa os campos de texto e o seletor de data
        if (oldValue != null) {
            txtseccao.clear();
            dtpData.setValue(null);
            cmbArtigo.setValue(null);
        }
        
        // Se houver um novo valor, preenche os campos de texto e o seletor de data com os dados da multa selecionada
        if (newValue != null) {
            txtseccao.setText(newValue.getSeccao());
            dtpData.setValue(newValue.getDataMulta());
            
            // Busca o artigo correspondente à multa selecionada na lista de artigos
            Optional<Artigo> optionalArtigo = listaArtigo.stream()
                    .filter(artigo -> newValue.getArtigo() != null && artigo.getID_Artigo() == newValue.getArtigo().getID_Artigo())
                    .findFirst();

            // Se encontrar o artigo, define o valor do combo box com ele
            if (optionalArtigo.isPresent()) {
                cmbArtigo.setValue(optionalArtigo.get());
            }
        }
    }
    });
    
    // Define os itens do combo box com a lista de artigos
    cmbArtigo.getItems().setAll(listaArtigo);
    
    // Define o conversor do combo box com o conversor de string definido acima
    cmbArtigo.setConverter(artigoStringConverter);
}

// Define um método para exibir uma mensagem de alerta com os parâmetros especificados
private Optional<ButtonType> showAlertMessage(Alert.AlertType type, String title,
    String headerText, String mssg) {
    Alert alert = new Alert(type);
    alert.setTitle(title);
    alert.setHeaderText(headerText);
    alert.setContentText(mssg);
    return alert.showAndWait();
}

}
