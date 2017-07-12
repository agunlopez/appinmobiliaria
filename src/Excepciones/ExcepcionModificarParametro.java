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
public class ExcepcionModificarParametro extends Exception {
    public ExcepcionModificarParametro(String msg) {
        super(msg);
    }
    public static void validarDatos(int diasAlerta,String punitorios,double punit,double comis,String comision) throws ExcepcionModificarParametro{
        
        if(diasAlerta<1){
            throw new ExcepcionModificarParametro("Los dias de alerta deben ser mayores a 1");
        }
        if(punitorios.length()>3){   
            throw new ExcepcionModificarParametro("Escriba el valor en formato 0.0");         
        }else{
            if(punit<0 || punit>100){
                throw new ExcepcionModificarParametro("El valor debe ser mayor a 0 y menor a 100");
            }
        }
        if(comision.length()>3){   
            throw new ExcepcionModificarParametro("Escriba el valor en formato 0.0");         
        }else{
            if(comis<0 || comis>100){
                throw new ExcepcionModificarParametro("El valor debe ser mayor a 0 y menor a 100");
            }
        }

        

    }
}
