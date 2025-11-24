import java.time.LocalDate;
public abstract class Servicio{

	protected String tipoServicio;
	protected float costo;
	protected String fecha;
	protected String mecanico;
	
	
	public Servicio(String tipoServicio, float costo, String mecanico){
		this.tipoServicio = tipoServicio;
		this.costo = costo;
		this.mecanico = mecanico;
	}
	
		
	public String getTipoServicio(){ return tipoServicio;}
	public float getCosto(){ return costo;}
	public String getFecha() { return fecha;}
	public String getMecanico() {return mecanico;}
	
	public void setTipoServicio(String tipoServicio) {this.tipoServicio = tipoServicio;}
	public void setCosto(float costo) {this.costo = costo;}
	public void setFecha(String fecha) {this.fecha = fecha;}
	public void setMecanico(String mecanico){ this.mecanico = mecanico;}
	
	
	public abstract void realizarServicio();
	public abstract void calcularCosto();
	
	
	@Override
	public String toString(){
		return tipoServicio+"\n"+ "NOMBRE DEL MECANICO: "+mecanico+"\n" +"PRECIO: "+costo+"\n"+"FECHA: "+fecha;
	}

}
