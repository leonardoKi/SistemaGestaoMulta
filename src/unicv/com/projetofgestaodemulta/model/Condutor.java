/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Condutor extends Multado {

    private final IntegerProperty ID_Condutor = new SimpleIntegerProperty(this, "ID_Condutor", 0);
    private final StringProperty NomeCondutor = new SimpleStringProperty(this, "NomeCondutor");
    private final StringProperty CNI = new SimpleStringProperty(this, "CNI");
    private final StringProperty Sexo = new SimpleStringProperty(this, "Sexo");
    private final IntegerProperty Idade = new SimpleIntegerProperty(this, "Idade", 0);
    private final IntegerProperty Contato = new SimpleIntegerProperty(this, "Contato", 0);
    private final StringProperty ilharesidencia = new SimpleStringProperty(this, "ilharesidencia");
    private final ObjectProperty<Multado> multado = new SimpleObjectProperty<>(this, "Multado");

    public int getID_Condutor() {
        return ID_Condutor.get();
    }

    public void setIdCondutor(int ID_Condutor) {
        this.ID_Condutor.set(ID_Condutor);
    }

    public IntegerProperty ID_CondutorProperty() {
        return ID_Condutor;
    }

    public String getNomeCondutor() {
        return NomeCondutor.get();
    }

    public void setNomeCondutor(String NomeCondutor) {
        this.NomeCondutor.set(NomeCondutor);
    }

    public StringProperty NomeCondutorProperty() {
        return NomeCondutor;
    }

    public String getCNI() {
        return CNI.get();
    }

    public final void setCNI(String CNI) {
        this.CNI.set(CNI);
    }

    public StringProperty CNIProperty() {
        return CNI;
    }

    public String getSexo() {
        return Sexo.get();
    }

    public final void setSexo(String Sexo) {
        this.Sexo.set(Sexo);
    }

    public StringProperty SexoProperty() {
        return Sexo;
    }

    public int getIdade() {
        return Idade.get();
    }

    public void setIdade(int Idade) {
        this.Idade.set(Idade);
    }

    public IntegerProperty IdadeProperty() {
        return Idade;
    }

    public int getContato() {
        return Contato.get();
    }

    public void setContato(int Contato) {
        this.Contato.set(Contato);
    }

    public IntegerProperty ContatoProperty() {
        return Contato;
    }

    public String getilharesidencia() {
        return ilharesidencia.get();
    }

    public void setIlharesidencia(String ilharesidencia) {
        this.ilharesidencia.set(ilharesidencia);
    }

    public StringProperty ilharesidenciaProperty() {
        return ilharesidencia;
    }

    public Multado getMultado() {
        return multado.get();
    }

    public void setMultado(Multado multado) {
        this.multado.set(multado);
    }

    public ObjectProperty<Multado> MultadoProperty() {
        return multado;
    }

}
