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
public class Movimiento {
    
    private String tipoMovimiento;
    private double valorMovimiento;
    private String fecha;
    private int recibo;
    private double honorarios;
    private Cuotas contratoCuota;
    private PropietarioPago propietarioPago;
    private Contrato contrato;
    private CuotaImpuesto cuotaImpuesto;

    public CuotaImpuesto getCuotaImpuesto() {
        return cuotaImpuesto;
    }

    public void setCuotaImpuesto(CuotaImpuesto cuotaImpuesto) {
        this.cuotaImpuesto = cuotaImpuesto;
    }
    

    public Cuotas getContratoCuota() {
        return contratoCuota;
    }

    public void setContratoCuota(Cuotas contratoCuota) {
        this.contratoCuota = contratoCuota;
    }

    public PropietarioPago getPropietarioPago() {
        return propietarioPago;
    }

    public void setPropietarioPago(PropietarioPago propietarioPago) {
        this.propietarioPago = propietarioPago;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
    

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public double getValorMovimiento() {
        return valorMovimiento;
    }

    public void setValorMovimiento(double valorMovimiento) {
        this.valorMovimiento = valorMovimiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getRecibo() {
        return recibo;
    }

    public void setRecibo(int recibo) {
        this.recibo = recibo;
    }

    public double getHonorarios() {
        return honorarios;
    }

    public void setHonorarios(double honorarios) {
        this.honorarios = honorarios;
    }
    
    
 
    
    
    
}
