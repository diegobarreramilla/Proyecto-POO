import java.time.LocalDate;
public class ServicioFrenos extends Servicio{
	
	private boolean incluyePurgado;
	private boolean cambiaPastillas;
	

    public ServicioFrenos(boolean incluyePurgado, boolean cambiaPastillas, String mecanico){
		
		super("Servicio de frenos", 1050, mecanico);
		this.incluyePurgado = incluyePurgado;
		this.cambiaPastillas = cambiaPastillas;
		
		fecha = LocalDate.now().toString();
    }
	
	@Override
    public void calcularCosto() {
        float total = costo;
        if (incluyePurgado) total += 200;
        if (cambiaPastillas) total += 350;
        costo = total;
    }
	
	@Override
	public void realizarServicio(){
		System.out.println("Realizando servicio de frenos...");
	}
}