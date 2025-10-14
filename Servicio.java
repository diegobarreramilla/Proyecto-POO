
public class Servicio {
    private String tipo;
    private float costo;
    private String fecha;
    private String descripcion;
    private Vehiculo vehiculo;

    public Servicio(String tipo, float costo, String fecha, String descripcion){

        this.tipo = tipo;
        this.costo = costo;
        this.fecha = fecha;
        this.descripcion= descripcion;

    }


    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getCosto() {
        return this.costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getFecha() {
        return this.fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    //generarinfromacion del sevicio
    @Override
    public String toString(){

        return " FECHA"+fecha+ "\nTIPO DE SERVICIO: "+tipo+"\nDESCRIPCION: "+descripcion+"\nCOSTO"+costo;
    }

    
    



    
}
