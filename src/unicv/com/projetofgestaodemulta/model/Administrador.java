/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class Administrador {

    private final IntegerProperty ID_Administrador = new SimpleIntegerProperty(this, "ID_Administrador", 0);
    private final StringProperty Nome_Administrador = new SimpleStringProperty(this, "Nome_Administrador");
    private ObjectProperty<Departamento> departamento = new SimpleObjectProperty<>(this, "departamento");
    
    public final int getID_Administrador() {
        return ID_Administrador.get();
    }

    public final void setID_Administrador(int ID_Administrador) {
        this.ID_Administrador.set(ID_Administrador);
    }

    public IntegerProperty ID_AdministradorProperty() {
        return ID_Administrador;
    }

    public String getNome_Administrador() {
        return Nome_Administrador.get();
    }

    public final void setNome_Administrador(String Nome_Administrador) {
        this.Nome_Administrador.set(Nome_Administrador);
    }

    public StringProperty Nome_AdministradorProperty() {
        return Nome_Administrador;
    }

     public Departamento getDepartamento() {
        return departamento.get();
    }

    public final ObjectProperty<Departamento> ID_DepartamentoProperty() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento.set(departamento);
    }

}
