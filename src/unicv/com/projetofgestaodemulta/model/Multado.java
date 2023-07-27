/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Multado {

    private final IntegerProperty ID_Multado = new SimpleIntegerProperty(this, "ID_Multado", 0);
    private final ObjectProperty<Multa> Multa = new SimpleObjectProperty<>(this, "Multa");

    public final int getID_Multado() {
        return ID_Multado.get();
    }

    public final void setID_Multado(int ID_Multado) {
        this.ID_Multado.set(ID_Multado);
    }

    public IntegerProperty ID_MultadoProperty() {
        return ID_Multado;
    }

    public Multa getMultas() {
        return Multa.get();
    }

    public void setMultas(Multa multa) {
        this.Multa.set(multa);
    }

}
