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
public class Cuotas {
    
    private int nroCuota;
    private double totalImpuestos;
    private int valorCuota;
    private double totalaPagar;
    private double totalPagado;
    private double punitorios;
    private double comision;
    private double descuento;
    private double valorGarantia;
    private Movimiento movimiento;
    private Contrato contrato;
    private CuotaImpuesto cuotaImpuesto;

    public CuotaImpuesto getCuotaImpuesto() {
        return cuotaImpuesto;
    }

    public void setCuotaImpuesto(CuotaImpuesto cuotaImpuesto) {
        this.cuotaImpuesto = cuotaImpuesto;
    }
    


    
    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public int getNroCuota() {
        return nroCuota;
    }

    public void setNroCuota(int nroCuota) {
        this.nroCuota = nroCuota;
    }

    public double getTotalImpuestos() {
        return totalImpuestos;
    }

    public void setTotalImpuestos(double totalImpuestos) {
        this.totalImpuestos = totalImpuestos;
    }

    public int getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(int valorCuota) {
        this.valorCuota = valorCuota;
    }


    public double getTotalaPagar() {
        return totalaPagar;
    }

    public void setTotalaPagar(double totalaPagar) {
        this.totalaPagar = totalaPagar;
    }

    public double getTotalPagado() {
        return totalPagado;
    }

    public void setTotalPagado(double totalPagado) {
        this.totalPagado = totalPagado;
    }

    public double getPunitorios() {
        return punitorios;
    }

    public void setPunitorios(double punitorios) {
        this.punitorios = punitorios;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getValorGarantia() {
        return valorGarantia;
    }

    public void setValorGarantia(double valorGarantia) {
        this.valorGarantia = valorGarantia;
    }


    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }
    
    
    
}
