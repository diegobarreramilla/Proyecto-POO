import java.time.LocalDate;
public class Afinacion extends Servicio{

	private boolean cambioBujias;
    private boolean limpiezaAceleracion;
    private boolean cambioFiltroAire;
    private boolean limpiezaInyectores;

	public Afinacion(boolean cambioBujias, boolean limpiezaAceleracion, boolean cambioFiltroAire, boolean limpiezaInyectores, String mecanico) {

		
        super("Afinación", 400, mecanico);
		
        this.cambioBujias = cambioBujias;
        this.limpiezaAceleracion = limpiezaAceleracion;
        this.cambioFiltroAire = cambioFiltroAire;
        this.limpiezaInyectores = limpiezaInyectores;
		
		fecha = LocalDate.now().toString();
	}
	
	@Override
	public void calcularCosto() {
        float total = costo;

        if (cambioBujias) total += 250;
        if (limpiezaAceleracion) total += 300;
        if (cambioFiltroAire) total += 150;
        if (limpiezaInyectores) total += 500;

        costo = total;
    }
	
	@Override
	public void realizarServicio(){
		System.out.println("Realizando Afinacion...");
	}
}
