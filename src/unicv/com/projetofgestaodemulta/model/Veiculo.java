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
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import java.time.LocalDate;

public class Veiculo extends Multado {

    /**
     * @return the Descricao
     */
    private final IntegerProperty ID_Veiculo = new SimpleIntegerProperty(this, "ID_Veiculo", 0);
    private final StringProperty Placa = new SimpleStringProperty(this, "Placa");
    private final IntegerProperty Num_Identificao = new SimpleIntegerProperty(this, "Num_Identificao", 0);
    private final ObjectProperty<LocalDate> DataExpecao = new SimpleObjectProperty<>(this, "DataExpecao");
    private final FloatProperty Peso = new SimpleFloatProperty(this, "Peso", 0f);
    private final IntegerProperty Lotacao = new SimpleIntegerProperty(this, "Lotacao", 0);
    private final StringProperty Descricao = new SimpleStringProperty(this, "Descricao");
    private final ObjectProperty<Multado> multado = new SimpleObjectProperty<>(this, "Multado");

    public final int getID_Veiculo() {
        return ID_Veiculo.get();
    }

    public void setID_Veiculo(int ID_Veiculo) {
        this.ID_Veiculo.set(ID_Veiculo);
    }

    public IntegerProperty ID_VeiculoProperty() {
        return ID_Veiculo;
    }

    public final String getPlaca() {
        return Placa.get();
    }

    public final void setPlaca(String Placa) {
        this.Placa.set(Placa);
    }

    public StringProperty placaProperty() {
        return Placa;
    }

    public final int getNum_Identificao() {
        return Num_Identificao.get();
    }

    public final void setNum_Identificao(int Num_Identificao) {
        this.Num_Identificao.set(Num_Identificao);
    }

    public IntegerProperty Num_IdentificaoProperty() {
        return Num_Identificao;
    }

    public LocalDate getDataExpecao() {
        return DataExpecao.get();
    }

    public void setDataExpecao(LocalDate DataExpecao) {
        this.DataExpecao.set(DataExpecao);
    }

    public ObjectProperty<LocalDate> DataExpecaoProperty() {
        return DataExpecao;
    }

    public final float getPeso() {
        return Peso.get();
    }

    public final void setPeso(float Peso) {
        this.Peso.set(Peso);
    }

    public FloatProperty PesoProperty() {
        return Peso;
    }

    public int getLotacao() {
        return Lotacao.get();
    }

    public final void setLotacao(int Lotacao) {
        this.Lotacao.set(Lotacao);
    }

    public IntegerProperty LotacaoProperty() {
        return Lotacao;
    }

    public String getDescricao() {
        return Descricao.get();
    }

    public void setDescricao(String Descricao) {
        this.Descricao.set(Descricao);
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
