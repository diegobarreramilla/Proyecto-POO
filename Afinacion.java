public class Afinacion implements Servicio{

    private String tipo = "AFINACION";
    private float precio;
    private String fecha;
    private String NombreMecanico; 

    public Afinacion(String fecha,String nombre){
        this.precio =  400;
        this.fecha = fecha;
        this.NombreMecanico = nombre;

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
