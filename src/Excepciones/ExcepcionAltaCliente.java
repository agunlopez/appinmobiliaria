/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

import java.util.Date;

/**
 *
 * @author Nahuel
 */
public class ExcepcionAltaCliente extends Exception {
    public ExcepcionAltaCliente(String msg) {
        super(msg);
    }
    public static void validarDatos(String nombre, String apellido, String direccion,String dni,String ciudad,String provincia,String cuit,Date fechaNac) throws ExcepcionAltaCliente{
        if(nombre.equals("")){
            throw new ExcepcionAltaCliente("Ingresar el Nombre del Cliente");
        }
        if(apellido.equals("")){
            throw new ExcepcionAltaCliente("Ingresar Apellido del Cliente");
        }
        if(ciudad.equals("")){
            throw new ExcepcionAltaCliente("Ingresar la Ciudad del Cliente");
        }
        if(provincia.equals("")){
            throw new ExcepcionAltaCliente("Ingresar la Provincia del Cliente");
        }
        if(direccion.equals("")){
            throw new ExcepcionAltaCliente("Ingresar el Direccion del Cliente");
        }

        if(dni.equals("")){
            throw new ExcepcionAltaCliente("Ingresar el DNI del Cliente");
        }

        if(cuit.equals("")){
            
        }else{
            if(cuit.length()!=11){
                throw new ExcepcionAltaCliente("El CUIT/CUIL debe tener 11 digitos");
            }
        }
        if(fechaNac==null){
            throw new ExcepcionAltaCliente("Ingrese fecha de Nacimiento");
        }
        if(dni.length()<8 || dni.length()>8){
            throw new ExcepcionAltaCliente("El DNI debe ser de 8 digitos ");
        }
        

    }
    
        public static void validarEdad(int edad) throws ExcepcionAltaCliente{
            if(edad<18){
            throw new ExcepcionAltaCliente("El cliente debe ser mayor a 18 años");
        }
        }
        
        public static void validarDni(boolean consultaDni) throws ExcepcionAltaCliente{
            if(consultaDni==true){
            throw new ExcepcionAltaCliente("Ya existe un cliente con ese DNI");
        }
        }

}
