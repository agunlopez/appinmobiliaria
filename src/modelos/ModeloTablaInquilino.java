package modelos;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


import entidades.Cliente;





public class ModeloTablaInquilino extends AbstractTableModel {

public static ArrayList<Cliente> lista=new ArrayList();
 final String [] COLUMN_NAMES={"ID","Nombre","Apellido","Apellido Materno","DNI","Telefono","Celular","E-mail","Direccion","Localidad","Provincia","Fecha Nacimiento","DGI","CUIT","EstadoCivil","Profesion"};
private int cantColumnas=COLUMN_NAMES.length;
 
public ModeloTablaInquilino(ArrayList<Cliente> lista) {
		super();
		this.lista=lista;
	}

	
@Override
public int getColumnCount() {
		
		return cantColumnas;
	}

@Override
public int getRowCount() {
		return lista.size();
	}
	
public String[] getCOLUMN_NAMES() {
		return COLUMN_NAMES;
	}

public ArrayList<Cliente> getListaPedidos() {
		return lista;
	}

public void setListaPedidos(ArrayList<Cliente> listaPedidos) {
		this.lista = listaPedidos;
	}
	
	
@Override
public Object getValueAt(int fila, int columna) {
		if (fila> lista.size())
		{
			return null;
		}
		else
			switch (columna)
			{
			case 0: return lista.get(fila).getId();
			
			case 1: return lista.get(fila).getNombre();
			
			case 2: return lista.get(fila).getApellido();
			
			case 3: return lista.get(fila).getApellidoMaterno();
			
			case 4: return lista.get(fila).getDni();
			
			case 5: return lista.get(fila).getTel();
			
			case 6: return lista.get(fila).getCelular();
			
			case 7: return lista.get(fila).getCorreo();
			
			case 8: return lista.get(fila).getDireccion();
			
			case 9: return lista.get(fila).getLocalidad();
					
			case 10: return lista.get(fila).getProvincia();
					
			case 11: return lista.get(fila).getFechaNac();
					
			case 12: return lista.get(fila).getDgi();
					
			case 13: return lista.get(fila).getCuit();
					
			case 14: return lista.get(fila).getEstadoCivil();
					
			case 15: return lista.get(fila).getProfesion();
			

			
			
			
			default: return null;
			}
	}
}
