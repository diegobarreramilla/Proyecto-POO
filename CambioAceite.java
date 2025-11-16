public class CambioAceite implements Servicio{

    private String tipo = "CAMBIO DE ACEITE ";
    private float precio;
    private String fecha;
    private String NombreMecanico; 

    public CambioAceite(String fecha,String descripcion){
        this.precio =  550;
        this.fecha = fecha;
        this.NombreMecanico = descripcion;

    }
    @Override
    public String getFecha(){
        return fecha;
    }
    @Override
    public String getMecanico(){
        return NombreMecanico;
    }
    @Override
    public float getPrecio(){
        return precio;
    }
    @Override
    public String getTipo(){
        return tipo;
    }
    @Override
    public String toString(){
        return tipo+"\n"+ "NOMBRE DEL MECANICO: "+NombreMecanico+"\n" +"PRECIO: "+precio+"\n"+"FECHA: "+fecha;
        }
    
}
