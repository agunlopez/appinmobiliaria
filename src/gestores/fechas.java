/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Nahuel
 */
public class fechas {
    public static int calcularMesesAFecha(Date fechaInicio, Date fechaFin) {
         try {
             //Fecha inicio en objeto Calendar
             Calendar startCalendar = Calendar.getInstance();
             startCalendar.setTime(fechaInicio);
             //Fecha finalización en objeto Calendar
             Calendar endCalendar = Calendar.getInstance();
             endCalendar.setTime(fechaFin);
             //Cálculo de meses para las fechas de inicio y finalización
             int startMes = (startCalendar.get(Calendar.YEAR) * 12) + startCalendar.get(Calendar.MONTH);
             int endMes = (endCalendar.get(Calendar.YEAR) * 12) + endCalendar.get(Calendar.MONTH);
             //Diferencia en meses entre las dos fechas
             int diffMonth = endMes - startMes;
             return diffMonth;
         } catch (Exception e) {
             return 0;
         }
    
}
    
    public static int cantidadDias(String Vencimiento, String Actual) throws ParseException{
        int dias;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
 
		Date fechaInicial=dateFormat.parse(Actual);
		Date fechaFinal=dateFormat.parse(Vencimiento);
                
                dias=(int) ((fechaInicial.getTime()-fechaFinal.getTime())/86400000);
	return dias;	
    }
    
    public static int calculaEdad(Calendar fechaNac) {
        Calendar today = Calendar.getInstance();

        int diff_year = today.get(Calendar.YEAR) -  fechaNac.get(Calendar.YEAR);
        int diff_month = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        int diff_day = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);

        //Si está en ese año pero todavía no los ha cumplido
        if (diff_month < 0 || (diff_month == 0 && diff_day < 0)) {
            diff_year = diff_year - 1; //no aparecían los dos guiones del postincremento :|
        }
        return diff_year;
    }
}