/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.model;

import java.time.LocalDateTime;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class SistemadeMulta {

    private final IntegerProperty ID_SistemaMulta = new SimpleIntegerProperty(this, "ID_SistemaMulta", 0);
    private final ObjectProperty<LocalDateTime> DataHoje = new SimpleObjectProperty<>(this, "DataHoje", LocalDateTime.now());
    private ObjectProperty<Administrador> Administrador = new SimpleObjectProperty<>(this, "administrador");


    public final int getID_SistemaMulta() {
        return ID_SistemaMulta.get();
    }

    public final void setID_SistemaMulta(int ID_SistemaMulta) {
        this.ID_SistemaMulta.set(ID_SistemaMulta);
    }

    public IntegerProperty ID_SistemaMultaProperty() {
        return ID_SistemaMulta;
    }

    public LocalDateTime getDataHoje() {
        return DataHoje.get();
    }

    public void setDataHoje(LocalDateTime DataHoje) {
        this.DataHoje.set(DataHoje);
    }

    public ObjectProperty<LocalDateTime> DataHojeProperty() {
        return DataHoje;
    }

    public Administrador getAdministrador() {
        return Administrador.get();
    }

    public void setAdministrador(Administrador administrador) {
        this.Administrador.set(administrador);
    }
    
     public final ObjectProperty<Administrador> AdministradorProperty() {
        return Administrador;
    }
}
