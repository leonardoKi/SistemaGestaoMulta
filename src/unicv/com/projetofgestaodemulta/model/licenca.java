/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.model;

/**
 *
 * @author Leonardo Fonseca
 */
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class licenca {

    private final IntegerProperty ID_Licenca = new SimpleIntegerProperty(this, "ID_Licenca", 0);
    private final IntegerProperty Num_Licenca = new SimpleIntegerProperty(this, "Num_Licenca", 0);
    private final BooleanProperty Suspensa = new SimpleBooleanProperty(this, "Suspensa");
    private final ObjectProperty<Condutor> condutor = new SimpleObjectProperty<>(this, "Condutor");

    public boolean isSuspensa() {
        return Suspensa.get();
    }

    public final void setSuspensa(boolean Suspensa) {
        this.Suspensa.set(Suspensa);
    }

    public BooleanProperty SuspensaProperty() {
        return Suspensa;
    }

    public final int getID_Licenca() {
        return ID_Licenca.get();
    }

    public final void setID_Licenca(int ID_Licenca) {
        this.ID_Licenca.set(ID_Licenca);
    }

    public IntegerProperty ID_LicencaProperty() {
        return ID_Licenca;
    }

    public final int getNum_Licenca() {
        return Num_Licenca.get();
    }

    public final void setNum_Licenca(int Num_Licenca) {
        this.Num_Licenca.set(Num_Licenca);
    }

    public IntegerProperty Num_LicencaProperty() {
        return Num_Licenca;
    }

    public Condutor getCondutor() {
        return condutor.get();
    }

    public void setCondutor(Condutor condutor) {
        this.condutor.set(condutor);
    }

}
