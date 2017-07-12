/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author Nahuel
 */
public class ExcepcionGarantia extends Exception {
    public ExcepcionGarantia(String msg) {
        super(msg);
    }
    public static void rango(int cuotas, int cuotasGara,int Garantia)throws ExcepcionGarantia{
        if(cuotasGara>cuotas){
            throw new ExcepcionGarantia("Las cuotas del deposito de garantia no pueden superar el total de cuotas del contrato");
        }
        if(cuotasGara<1){
            throw new ExcepcionGarantia("Las cuotas del deposito de garantia no pueden ser menor a 1");
        }
        if(Garantia<0){
            throw new ExcepcionGarantia("La garantia debe ser mayor a 0");
        }
}
}