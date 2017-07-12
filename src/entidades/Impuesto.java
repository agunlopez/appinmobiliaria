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
public class Impuesto {
    
    private int idImpuesto;
    private int idDescripcion;
    private double valor;
    private Cuotas cuotas;
    private CuotaImpuesto cuotaImpuestos;
    private DescripcionImpuesto descripcion;

    public DescripcionImpuesto getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(DescripcionImpuesto descripcion) {
        this.descripcion = descripcion;
    }
    
    

    public int getIdImpuesto() {
        return idImpuesto;
    }

    public void setIdImpuesto(int idImpuesto) {
        this.idImpuesto = idImpuesto;
    }

    public int getIdDescripcion() {
        return idDescripcion;
    }

    public void setIdDescripcion(int idDescripcion) {
        this.idDescripcion = idDescripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Cuotas getCuotas() {
        return cuotas;
    }

    public void setCuotas(Cuotas cuotas) {
        this.cuotas = cuotas;
    }

    public CuotaImpuesto getCuotaImpuestos() {
        return cuotaImpuestos;
    }

    public void setCuotaImpuestos(CuotaImpuesto cuotaImpuestos) {
        this.cuotaImpuestos = cuotaImpuestos;
    }
    
    
    
    
    
}
