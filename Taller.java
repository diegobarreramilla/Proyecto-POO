public class Taller {
    private String nombre;
    private String direccion;
    private String telefono;
    private Vehiculo[] vehiculos = new Vehiculo[256];
    private int numVehiculos;
    private Cliente[] clientes = new Cliente[256];
    private int numCLientes;
    private Servicio[] servicios = new Servicio[256];
    private int numServicios;

    public Taller(String nombre, String direccion,String telefono){
        this.nombre = " 'NOMBRE TALLER' ";
        this.direccion = " OTAY ";
        this.telefono = "664 582 3331";


    }

    public void agregarCliente(Cliente c){
        if(numCLientes<256){

                clientes[numCLientes++] = c;
        }
    }
    public void agregarVehiculo(Vehiculo v){
        if(numVehiculos<256){

                vehiculos[numVehiculos++] = v;
        }
    }
    public void agregarServicio(Servicio s){
        if(numServicios<256){

                servicios[numServicios++] = s;
        }
    }

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

    @Override
    public String toString(){
        return " TALLER: "+nombre+ " UBICADO EN: "+ direccion+" TELEFONO:"+telefono+"\n" ;
    }

    public String desplegarClientes(){
        String info = "";
            for(int i =0;i< numCLientes;i++){
                info += clientes[i].toString() + "\n";
            }
            return info;

    }

    public String desplegarVehiculosCliente(){
        String info = "";
            for(int i =0;i< numCLientes;i++){
                info += clientes[i].toString() + "\n";
            }
            return info;

    }

    


    
}
