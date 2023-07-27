/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.model;

/*
 * @author Leonardo Fonseca
 */
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import java.time.LocalDate;

public class Fatura {

    private final IntegerProperty ID_Fatura = new SimpleIntegerProperty(this, "ID_Fatura", 0);
    private final ObjectProperty<LocalDate> DataFatura = new SimpleObjectProperty<>(this, "DataFatura");
    private final ObjectProperty<Pagamento> Pagamento = new SimpleObjectProperty<>(this, "pagamento");

    public IntegerProperty getID_Fatura() {
        return ID_Fatura;
    }

    public void setID_Fatura(int ID_Fatura) {
        this.ID_Fatura.set(ID_Fatura);
    }

    public LocalDate getDataFatura() {
        return DataFatura.get();
    }

    public void setDataFatura(LocalDate DataFatura) {
        this.DataFatura.set(DataFatura);
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
