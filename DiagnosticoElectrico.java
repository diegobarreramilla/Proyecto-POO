import java.time.LocalDate;
public class DiagnosticoElectrico extends Servicio{
    
	private boolean usaScanner;
	private String complejidad;
	
	
	public DiagnosticoElectrico(boolean usaScanner, String complejidad, String mecanico){
		
		super("Diagnostico Electrico", 750, mecanico);
		this.usaScanner = usaScanner;
		this.complejidad = complejidad;
		
		fecha = LocalDate.now().toString();
	}

	public void calcularCosto() {
        float total = costo;

        if (usaScanner) total += 250;

        switch (complejidad.toLowerCase()) {
            case "bajo":
                total += 200;
                break;
            case "medio":
                total += 400;
                break;
            case "alto":
                total += 700;
                break;
        }

        costo = total;
    }

    @Override
    public void realizarServicio() {
        System.out.println("Realizando diagnóstico eléctrico (" + complejidad + ")");
    }

}
