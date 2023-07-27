/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unicv.com.projetofgestaodemulta.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;

public class Artigo {

    private final IntegerProperty ID_Artigo = new SimpleIntegerProperty(this, "ID_Artigo", 0);
    private final FloatProperty ValorMulta = new SimpleFloatProperty(this, "ValorMulta", 0f);
    private final IntegerProperty Num_Pontos = new SimpleIntegerProperty(this, "Num_Pontos", 0);
    private final IntegerProperty Num_Artigo = new SimpleIntegerProperty(this, "Num_Artigo", 0);

    public int getID_Artigo() {
        return ID_Artigo.get();
    }

    public void setID_Artigo(int ID_Artigo) {
        this.ID_Artigo.set(ID_Artigo);
    }

    public final IntegerProperty ID_ArtigoProperty() {
        return ID_Artigo;
    }

    public void setValorMulta(Float ValorMulta) {
        this.ValorMulta.set(ValorMulta);
    }

    public float getValorMulta() {
        return ValorMulta.get();
    }

    public FloatProperty ValorMultaProperty() {
        return ValorMulta;
    }

    public void setNum_Pontos(int Num_Pontos) {
        this.Num_Pontos.set(Num_Pontos);
    }

    public int getNum_Pontos() {
        return Num_Pontos.get();
    }

    public IntegerProperty Num_PontosProperty() {
        return Num_Pontos;
    }

    public void setNum_Artigo(int Num_Artigo) {
        this.Num_Artigo.set(Num_Artigo);
    }

    public int getNum_Artigo() {
        return Num_Artigo.get();
    }

    public IntegerProperty Num_ArtigoProperty() {
        return Num_Artigo;
    }

}
