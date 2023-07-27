/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package unicv.com.projetofgestaodemulta.model;

/**
 *
 * @author Leonardo Fonseca
 */
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Categoria {

    private final StringProperty identificacao = new SimpleStringProperty(this, "Identificacao");
    private final IntegerProperty IDcategoria = new SimpleIntegerProperty(this, "ID_Categoria", 0);
    private final ObjectProperty<Multado> multado = new SimpleObjectProperty<>(this, "Multado");

  
    public String getIdentificacao() {
        return identificacao.get();
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao.set(identificacao);
    }

    public StringProperty IdentificacaoProperty() {
        return identificacao;
    }

    public int getIDcategoria() {
        return IDcategoria.get();
    }

    public void setIDcategoria(int IDcategoria) {
        this.IDcategoria.set(IDcategoria);
    }

    public IntegerProperty IDcategoriaProperty() {
        return IDcategoria;
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
