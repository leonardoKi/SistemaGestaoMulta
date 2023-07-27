/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package unicv.com.projetofgestaodemulta.model;

/**
 * @author Leonardo Fonseca
 */
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class FormaPagamento {

    private final IntegerProperty ID_FormaPagamento = new SimpleIntegerProperty(this, "ID_FormaPagamento", 0);
    private final StringProperty Opcao = new SimpleStringProperty(this, "Opcao");
    private ObjectProperty<Pagamento> Pagamento = new SimpleObjectProperty<>(this, "Pagamento");

    public final int getID_FormaPagamento() {
        return ID_FormaPagamento.get();
    }

    public final void setidformapagamento(int ID_FormaPagamento) {
        this.ID_FormaPagamento.set(ID_FormaPagamento);
    }

    public IntegerProperty ID_FormaPagamentoProperty() {
        return ID_FormaPagamento;
    }

    public final String getOpcao() {
        return Opcao.get();
    }

    public final void setOpcao(String Opcao) {
        this.Opcao.set(Opcao);
    }

    public StringProperty OpcaoProperty() {
        return Opcao;
    }

    public Pagamento getPagamento() {
        return Pagamento.get();
    }

    public void setPagamento(Pagamento pagamento) {
        this.Pagamento.set(pagamento);
    }
    public ObjectProperty<Pagamento> MultaProperty() {
        return Pagamento;
    }
}
