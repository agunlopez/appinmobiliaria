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
public class Inmueble {
    
    	private int id;
	private String calle;
	private String piso;
	private String dpto;
	private String localidad;
        private String provincia;
        private String estado;
	private String tipo;
        private String folio;
        private int folioReal;
        private int tomo;
        private String fechaInscripcion;
        private Cliente propietario;
        private TitularImpuesto titularImpuesto;

    public TitularImpuesto getTitularImpuesto() {
        return titularImpuesto;
    }

    public void setTitularImpuesto(TitularImpuesto titularImpuesto) {
        this.titularImpuesto = titularImpuesto;
    }

   
    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }


    public String getFolio() {
        return folio;
    }

    public int getFolioReal() {
        return folioReal;
    }

    public int getTomo() {
        return tomo;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }


    public void setFolio(String folio) {
        this.folio = folio;
    }

    public void setFolioReal(int folioReal) {
        this.folioReal = folioReal;
    }

    public void setTomo(int tomo) {
        this.tomo = tomo;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

   
	
        
        
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	public String getDpto() {
		return dpto;
	}
	public void setDpto(String dpto) {
		this.dpto = dpto;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

    public Cliente getPropietario() {
        return propietario;
    }

    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }
	
	
    
}
