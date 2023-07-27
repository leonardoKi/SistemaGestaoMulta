/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class Departamento {

    private final IntegerProperty ID_Departamento = new SimpleIntegerProperty(this, "ID_Departamento", 0);
    private final StringProperty NomeDepartamento = new SimpleStringProperty(this, "NomeDepartamento");

    public int getID_Departamento() {
        return ID_Departamento.get();
    }

    public void setID_Departamento(int ID_Departamento) {
        this.ID_Departamento.set(ID_Departamento);
    }

    public IntegerProperty ID_DepartamentoProperty() {
        return ID_Departamento;
    }

    public String getNomeDepartamento() {
        return NomeDepartamento.get();
    }

    public void setNomeDepartamento(String NomeDepartamento) {
        this.NomeDepartamento.set(NomeDepartamento);
    }

    public StringProperty NomeDepartamentoProperty() {
        return NomeDepartamento;
    }

}
