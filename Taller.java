public class Taller {
    private String nombre;
    private String direccion;
    private String telefono;
    private Vehiculo[] vehiculos = new Vehiculo[256];
    private Cliente[] clientes = new Cliente[256];
    private Servicio[] servicios = new Servicio[256];

    public Vehiculo[] getVehiculos() {
        return this.vehiculos;
    }

    public void setVehiculos(Vehiculo[] vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Cliente[] getClientes() {
        return this.clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public Servicio[] getServicios() {
        return this.servicios;
    }

    public void setServicios(Servicio[] servicios) {
        this.servicios = servicios;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    


    
}
