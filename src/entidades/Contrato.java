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
public class Contrato {
    
    	private int idContrato;
        private double honorarios;
        private double punitorios;
        private String fechaInicio;
        private String fechaVencimiento;
        private int garantia;
        private int diaPago;
        private int totalCuotas;
        private int cuotaActual;
        private int cuotasGarantia;
        private String estado;
        private Cliente inquilino;
        private Cliente garante1;
        private Cliente garante2;
        private Inmueble inmueble;
        private Movimiento movimiento;
        private Cuotas Cutoas;
        private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
        
        



        
    public Movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

        
    public Cuotas getCutoas() {
        return Cutoas;
    }

    public void setCutoas(Cuotas Cutoas) {
        this.Cutoas = Cutoas;
    }

        
    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public double getHonorarios() {
        return honorarios;
    }

    public void setHonorarios(double honorarios) {
        this.honorarios = honorarios;
    }

    public double getPunitorios() {
        return punitorios;
    }

    public void setPunitorios(double punitorios) {
        this.punitorios = punitorios;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    public int getDiaPago() {
        return diaPago;
    }

    public void setDiaPago(int diaPago) {
        this.diaPago = diaPago;
    }

    public int getTotalCuotas() {
        return totalCuotas;
    }

    public void setTotalCuotas(int totalCuotas) {
        this.totalCuotas = totalCuotas;
    }

    public int getCuotaActual() {
        return cuotaActual;
    }

    public void setCuotaActual(int cuotaActual) {
        this.cuotaActual = cuotaActual;
    }

    public int getCuotasGarantia() {
        return cuotasGarantia;
    }

    public void setCuotasGarantia(int cuotasGarantia) {
        this.cuotasGarantia = cuotasGarantia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getInquilino() {
        return inquilino;
    }

    public void setInquilino(Cliente inquilino) {
        this.inquilino = inquilino;
    }

    public Cliente getGarante1() {
        return garante1;
    }

    public void setGarante1(Cliente garante1) {
        this.garante1 = garante1;
    }

    public Cliente getGarante2() {
        return garante2;
    }

    public void setGarante2(Cliente garante2) {
        this.garante2 = garante2;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }
        
        
        
	
    
}
