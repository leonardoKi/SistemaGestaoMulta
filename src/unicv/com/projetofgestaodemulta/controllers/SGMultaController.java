/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package unicv.com.projetofgestaodemulta.controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
public class SGMultaController implements Initializable {

    // Declara um atributo do tipo Pane para armazenar o painel que contém as telas
    @FXML
    private Pane containerPane;

// Declara um atributo do tipo ToolBar para armazenar o menu de opções
    @FXML
    private ToolBar menu;

// Método para tratar o evento de clicar no botão Aplicar Multa
    public void handleAplicarMultaButtonAction() {
        try {
            // Carrega o arquivo FXML da tela de aplicar multa e cria um objeto AnchorPane com o seu conteúdo
            AnchorPane childAnchorPane = FXMLLoader.load(getClass().getResource("../views/Aplicarmulta.fxml"));
            // Limpa o painel containerPane de qualquer tela anterior
            containerPane.getChildren().clear();
            // Adiciona a tela de aplicar multa ao painel containerPane
            containerPane.getChildren().add(childAnchorPane);
            // Define a altura e a largura preferidas do painel containerPane de acordo com a tela de aplicar multa
            containerPane.setPrefHeight(childAnchorPane.getPrefHeight());
            containerPane.setPrefWidth(childAnchorPane.getPrefWidth());
            // Define a altura preferida do menu de acordo com a tela de aplicar multa mais 50 pixels
            menu.setPrefHeight(childAnchorPane.getPrefHeight() + 50);
            // Obtém o palco atual da cena do painel containerPane
            Stage stage = (Stage) containerPane.getScene().getWindow();
            // Define a altura e a largura do palco de acordo com o painel containerPane e o menu
            stage.setHeight(childAnchorPane.getPrefHeight() + 50);
            stage.setWidth(containerPane.getPrefWidth() + menu.getPrefWidth());
        } catch (IOException ex) {
            // Se ocorrer um erro de entrada ou saída, registra o nível e a causa do erro no logger da classe SGMultaController
            Logger.getLogger(SGMultaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

// Método para tratar o evento de clicar no botão Cancelar Multa
    public void handleCancelarMultaButtonAction() {
        try {
            // Carrega o arquivo FXML da tela de cancelar multa e cria um objeto AnchorPane com o seu conteúdo
            AnchorPane childAnchorPane = FXMLLoader.load(getClass().getResource("../views/CancelarMulta.fxml"));
            // Limpa o painel containerPane de qualquer tela anterior
            containerPane.getChildren().clear();
            // Adiciona a tela de cancelar multa ao painel containerPane
            containerPane.getChildren().add(childAnchorPane);
            // Define a altura e a largura preferidas do painel containerPane de acordo com a tela de cancelar multa
            containerPane.setPrefHeight(childAnchorPane.getPrefHeight());
            containerPane.setPrefWidth(childAnchorPane.getPrefWidth());
            // Define a altura preferida do menu de acordo com a tela de cancelar multa mais 50 pixels
            menu.setPrefHeight(childAnchorPane.getPrefHeight() + 50);
            // Obtém o palco atual da cena do painel containerPane
            Stage stage = (Stage) containerPane.getScene().getWindow();
            // Define a altura e a largura do palco de acordo com o painel containerPane e o menu
            stage.setHeight(childAnchorPane.getPrefHeight() + 50);
            stage.setWidth(containerPane.getPrefWidth() + menu.getPrefWidth());
        } catch (IOException ex) {
            // Se ocorrer um erro de entrada ou saída, registra o nível e a causa do erro no logger da classe SGMultaController
            Logger.getLogger(SGMultaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

// Método para tratar o evento de clicar no botão Artigo
    public void handleArtigoButtonAction() {
        try {
            // Carrega o arquivo FXML da tela de artigo e cria um objeto AnchorPane com o seu conteúdo
            AnchorPane childAnchorPane = FXMLLoader.load(getClass().getResource("../views/Artigo.fxml"));
            // Limpa o painel containerPane de qualquer tela anterior
            containerPane.getChildren().clear();
            // Adiciona a tela de artigo ao painel containerPane

            containerPane.getChildren().add(childAnchorPane);
            containerPane.setPrefHeight(childAnchorPane.getPrefHeight());
            containerPane.setPrefWidth(childAnchorPane.getPrefWidth());
            menu.setPrefHeight(childAnchorPane.getPrefHeight() + 50);
            Stage stage = (Stage) containerPane.getScene().getWindow();
            stage.setHeight(childAnchorPane.getPrefHeight() + 50);
            stage.setWidth(containerPane.getPrefWidth() + menu.getPrefWidth());
        } catch (IOException ex) {
            Logger.getLogger(SGMultaController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Método para tratar o evento de clicar no botão Veiculo
    public void handleVeiculoButtonAction() {
        try {
            // Carrega o arquivo FXML da tela de veiculo e cria um objeto AnchorPane com o seu conteúdo
            AnchorPane childAnchorPane = FXMLLoader.load(getClass().getResource("../views/Veiculo.fxml"));
            // Limpa o painel containerPane de qualquer tela anterior
            containerPane.getChildren().clear();
            // Adiciona a tela de veiculo ao painel containerPane
            containerPane.getChildren().add(childAnchorPane);
            // Define a altura e a largura preferidas do painel containerPane de acordo com a tela de veiculo
            containerPane.setPrefHeight(childAnchorPane.getPrefHeight());
            containerPane.setPrefWidth(childAnchorPane.getPrefWidth());
            // Define a altura preferida do menu de acordo com a tela de veiculo mais 50 pixels
            menu.setPrefHeight(childAnchorPane.getPrefHeight() + 50);
            // Obtém o palco atual da cena do painel containerPane
            Stage stage = (Stage) containerPane.getScene().getWindow();
            // Define a altura e a largura do palco de acordo com o painel containerPane e o menu
            stage.setHeight(childAnchorPane.getPrefHeight() + 50);
            stage.setWidth(containerPane.getPrefWidth() + menu.getPrefWidth());

        } catch (IOException ex) {
            // Se ocorrer um erro de entrada ou saída, registra o nível e a causa do erro no logger da classe SGMultaController
            Logger.getLogger(SGMultaController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Método para tratar o evento de clicar no botão Condutor
    public void handlecondutorButtonAction() {
        try {
            // Carrega o arquivo FXML da tela de condutor e cria um objeto AnchorPane com o seu conteúdo
            AnchorPane childAnchorPane = FXMLLoader.load(getClass().getResource("../views/Condutor.fxml"));
            // Limpa o painel containerPane de qualquer tela anterior
            containerPane.getChildren().clear();
            // Adiciona a tela de condutor ao painel containerPane
            containerPane.getChildren().add(childAnchorPane);
            // Define a altura e a largura preferidas do painel containerPane de acordo com a tela de condutor
            containerPane.setPrefHeight(childAnchorPane.getPrefHeight());
            containerPane.setPrefWidth(childAnchorPane.getPrefWidth());
            // Define a altura preferida do menu de acordo com a tela de condutor mais 50 pixels
            menu.setPrefHeight(childAnchorPane.getPrefHeight() + 50);
            // Obtém o palco atual da cena do painel containerPane
            Stage stage = (Stage) containerPane.getScene().getWindow();
            // Define a altura e a largura do palco de acordo com o painel containerPane e o menu
            stage.setHeight(childAnchorPane.getPrefHeight() + 50);
            stage.setWidth(containerPane.getPrefWidth() + menu.getPrefWidth());

        } catch (IOException ex) {
            // Se ocorrer um erro de entrada ou saída, registra o nível e a causa do erro no logger da classe SGMultaController
            Logger.getLogger(SGMultaController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

// Método para tratar o evento de clicar no botão Fechar
    public void onActionFechar(ActionEvent event) {
        // Obtém o palco atual da cena do botão que disparou o evento
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Fecha o palco
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
