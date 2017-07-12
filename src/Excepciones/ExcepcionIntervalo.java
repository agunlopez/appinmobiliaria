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
public class ExcepcionIntervalo extends Exception {
    public ExcepcionIntervalo(String msg) {
        super(msg);
    }
    public static void rango(int tot, int cant)throws ExcepcionIntervalo{
        if(tot!=cant){
            throw new ExcepcionIntervalo("Cantidad de coutas menores a la cantidad de Meses");
        }
}
}