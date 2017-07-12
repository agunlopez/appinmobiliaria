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
public class ExcepcionAltaInmueble extends Exception {
    public ExcepcionAltaInmueble(String msg) {
        super(msg);
    }
    public static void validarDatos(String calle, String numero, String ciudad, String provincia,String Propietario) throws ExcepcionAltaInmueble{
        if(calle.equals("")){
            throw new ExcepcionAltaInmueble("Ingresar Calle del Inmueble");
        }
        if(numero.equals("")){
            throw new ExcepcionAltaInmueble("Ingresar Numero de calle del Inmueble");
        }
        if(ciudad.equals("")){
            throw new ExcepcionAltaInmueble("Ingresar Ciudad del Inmueble");
        }
        if(provincia.equals("")){
            throw new ExcepcionAltaInmueble("Ingresar la Provincia del Inmueble");
        }
        if(Propietario.equals("")){
            throw new ExcepcionAltaInmueble("Ingresar el Propietario del Inmueble");
        }
    }
}
