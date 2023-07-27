/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.model;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import java.time.LocalDate;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class Pagamento {

    private final FloatProperty valorPagar = new SimpleFloatProperty(this, "ValorPagar", 0f);
    private final IntegerProperty ID_Pagamento = new SimpleIntegerProperty(this, "ID_Pagamento", 0);
    private final ObjectProperty<LocalDate> DataPagamento = new SimpleObjectProperty<>(this, "DataPagamento");
    private final BooleanProperty estado = new SimpleBooleanProperty(this, "estado");
    private ObjectProperty<Multa> Multa = new SimpleObjectProperty<>(this, "Multa");

    public final float getValorPagar() {
        return valorPagar.get();
    }

    public final void setValorPagar(float valorPagar) {
        this.valorPagar.set(valorPagar);
    }

    public FloatProperty ValorPagarProperty() {
        return valorPagar;
    }

    public final int getID_Pagamento() {
        return ID_Pagamento.get();
    }

    public final void setID_Pagamento(int ID_Pagamento) {
        this.ID_Pagamento.set(ID_Pagamento);
    }

    public IntegerProperty ID_PagamentoProperty() {
        return ID_Pagamento;
    }

    public final LocalDate getDataPagamento() {
        return DataPagamento.get();
    }

    public final void setDataPagamento(LocalDate DataPagamento) {
        this.DataPagamento.set(DataPagamento);
    }

    public ObjectProperty<LocalDate> DataPagamentoProperty() {
        return DataPagamento;
    }

    public Multa getMultas() {
        return Multa.get();
    }

    public void setMultas(Multa multa) {
        this.Multa.set(multa);
    }

    public ObjectProperty<Multa> MultaProperty() {
        return Multa;
    }

    public Boolean getEstado() {
        return estado.get();
    }

    public void setEstado(Boolean estado) {
        this.estado.set(estado);
    }

}
