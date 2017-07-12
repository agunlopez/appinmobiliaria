/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Nahuel
 */
public class TitularImpuesto {

    private String titular;
    private Contrato contrato;
    private DescripcionImpuesto descipcion;

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public DescripcionImpuesto getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(DescripcionImpuesto descipcion) {
        this.descipcion = descipcion;
    }

    



    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
    
    

}
