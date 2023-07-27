/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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

public class Multa {
// Declara um atributo do tipo IntegerProperty para armazenar o id da multa
private final IntegerProperty ID_Multa = new SimpleIntegerProperty(this, "ID_Multa", 0);
// Declara um atributo do tipo StringProperty para armazenar a seção da multa
private final StringProperty Seccao = new SimpleStringProperty(this, "Seccao");
// Declara um atributo do tipo ObjectProperty<LocalDate> para armazenar a data da multa
private final ObjectProperty<LocalDate> DataMulta = new SimpleObjectProperty<>(this, "DataMulta");
// Declara um atributo do tipo ObjectProperty<Artigo> para armazenar o artigo associado à multa
private final ObjectProperty<Artigo> Artigo = new SimpleObjectProperty<>(this, "Artigo");
// Declara um atributo do tipo ObjectProperty<SistemadeMulta> para armazenar o sistema de multa associado à multa
private final ObjectProperty<SistemadeMulta> SistemadeMulta = new SimpleObjectProperty<>(this, "SistemadeMulta");


// Método para obter o valor do id da multa que retorna um inteiro
public final int getID_Multa() {
    return ID_Multa.get();
}

// Método para definir o valor do id da multa que recebe um inteiro ID_Multa como parâmetro e atribui ao atributo ID_Multa
public final void setID_Multa(int ID_Multa) {
    this.ID_Multa.set(ID_Multa);
}

// Método para obter a propriedade do id da multa que retorna um objeto IntegerProperty
public IntegerProperty ID_MultaProperty() {
    return ID_Multa;
}

// Método para obter o valor da seção da multa que retorna uma string
public String getSeccao() {
    return Seccao.get();
}

// Método para definir o valor da seção da multa que recebe uma string Seccao como parâmetro e atribui ao atributo Seccao
public void setSeccao(String Seccao) {
    this.Seccao.set(Seccao);
}

// Método para obter a propriedade da seção da multa que retorna um objeto StringProperty
public StringProperty SeccaoProperty() {
    return Seccao;
}

// Método para obter o valor da data da multa que retorna um objeto LocalDate
public LocalDate getDataMulta() {
    return DataMulta.get();
}

// Método para definir o valor da data da multa que recebe um objeto LocalDate dataMulta como parâmetro e atribui ao atributo DataMulta
public void setDataMulta(LocalDate dataMulta) {
    this.DataMulta.set(dataMulta);
}

// Método para obter a propriedade da data da multa que retorna um objeto ObjectProperty<LocalDate>
public ObjectProperty<LocalDate> DataMultaProperty() {
    return DataMulta;
}

// Método para obter o valor do artigo da multa que retorna um objeto Artigo
public Artigo getArtigo() {
    return Artigo.get();
}

// Método para definir o valor do artigo da multa que recebe um objeto Artigo artigo como parâmetro e atribui ao atributo Artigo
public void setArtigos(Artigo artigo) {
    this.Artigo.set(artigo);
}

// Método para obter a propriedade do artigo da multa que retorna um objeto ObjectProperty<Artigo>
public ObjectProperty<Artigo> ArtigoProperty() {
    return Artigo;
}

// Método para obter o valor do sistema de multa da multa que retorna um objeto SistemadeMulta
public SistemadeMulta getSistemaMulta() {
    return SistemadeMulta.get();
}

 // Método para obter a propriedade do sistema de multa da multa que retorna um objeto ObjectProperty<SistemadeMulta>
 public ObjectProperty<SistemadeMulta> SistemadeMultaProperty() {
    return SistemadeMulta;
 }

 // Método para definir o valor do sistema de multa da multa que recebe um objeto SistemadeMulta sistemaMulta como parâmetro e atribui ao atributo SistemadeMulta
 public void setSistemaMulta(SistemadeMulta sistemaMulta) {
    this.SistemadeMulta.set(sistemaMulta);
 }

 

}
