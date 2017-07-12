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
public class ExcepcionClientesContrato extends Exception {
    public ExcepcionClientesContrato(String msg) {
        super(msg);
    }
    public static void validarDatos(String Inmueble, String Inquilino, String Garante1, String Garante2) throws ExcepcionClientesContrato{
        if(Inmueble.equals("")){
            throw new ExcepcionClientesContrato("Ingrese el Inmueble");
        }
        if(Inquilino.equals("")){
            throw new ExcepcionClientesContrato("Ingrese el Inquilino");
        }
        if(Garante1.equals("")){
            throw new ExcepcionClientesContrato("Ingrese el Primer Garante");
        }
        if(Garante2.equals("")){
            throw new ExcepcionClientesContrato("Ingrese el Segundo Garante");
        }

    }
}
