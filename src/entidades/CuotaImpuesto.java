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
public class CuotaImpuesto {
    
    private Cuotas cuotas;
    private Impuesto impuesto;
    private TitularImpuesto titular;

    public TitularImpuesto getTitular() {
        return titular;
    }

    public void setTitular(TitularImpuesto titular) {
        this.titular = titular;
    }
    
    

    public Cuotas getCuotas() {
        return cuotas;
    }

    public void setCuotas(Cuotas cuotas) {
        this.cuotas = cuotas;
    }



    public Impuesto getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }
    
    
    
    
}
