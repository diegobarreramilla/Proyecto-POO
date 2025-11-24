import java.time.LocalDate;
public class CambioAceite extends Servicio{

	private String tipoAceite;
	private float litros;
	private float costoLitro;
	
	public CambioAceite(String tipoAceite, float litros, float costoLitro, String mecanico){
        super("Cambio de Aceite", 550, mecanico);
		
		this.tipoAceite = tipoAceite;
		this.litros = litros;
		this.costoLitro = costoLitro;
		
		fecha = LocalDate.now().toString();
    }
	
	@Override
	public void calcularCosto(){
		costo = costo + (litros * costoLitro);
	}
	
	public void realizarServicio(){
		System.out.println("Realizando cambio de aceite con aceite " + tipoAceite);
	}

}
