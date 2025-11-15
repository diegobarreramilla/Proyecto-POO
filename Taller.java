import javax.swing.JOptionPane;

public class Taller {
    private String nombre;
    private String direccion;
    private String telefono;
    private Vehiculo[] vehiculos = new Vehiculo[256];
    private int numVehiculos;
    private Cliente[] clientes = new Cliente[256];
    private int numClientes;
    private Servicio[] servicios = new Servicio[256];
    private int numServicios;

    public Taller(String nombre, String direccion,String telefono){
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;


    }

    public void agregarCliente(Cliente c){
        if(numClientes<256){

                clientes[numClientes++] = c;
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

    public Cliente getClienteIndice(int indice) {
        if(indice>= 0 && indice< numClientes){
            return this.clientes[indice];

        }
        else
        return null;
    }
	
	public Vehiculo getVehiculoIndice(int indice) {
        if(indice>= 0 && indice< numClientes){
            return this.vehiculos[indice];

        }
        else
        return null;
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

    public boolean crearClientenuevo(String nombre, String telefono,String correo){
        if(numClientes<100){

        
        
            Cliente nuevo = new Cliente(nombre,telefono,correo);
            clientes[numClientes++] = nuevo;
            return true;
        }else{
            return false;
        }
    }

	

    public String desplegarClientes(){
		//Lo cambie para que solo imprima el nombre y no todos los datos
		//Para que no se vea tan saturado
        String info = "";
            for(int i =0;i< numClientes;i++){
				//Hice que empezara en 1, no en 0
                info +=(i + 1)+". "+ clientes[i].getNombre()+ "\n";
            }
            return info;

    }

    public String desplegarVehiculosCliente(){
        String info = "";
            for(int i =0;i< numClientes;i++){
                info += clientes[i].mostrarVehiculos() + "\n";
            }
            return info;

    }
	
	//MUESTRA LOS VEHICULOS REGISTRADOS EN EL TALLER
	public String desplegarVehiculos(){
		String info = "";
		for(int i =0;i< numClientes;i++){
			info += (i + 1) + ". "+vehiculos[i].getModelo()+"\n";
		}
		return info;
	}
	
	//Separe esta funcion en 2 con la de hayClientes y las hice boolean
    public boolean indiceValido(int indice){
		return numClientes > indice;
    }
    
	//Agregue una funcion para ver si no hay clientes
	public boolean hayClientes(){
		return numClientes > 0 ;
	}
	
	public boolean hayVehiculos(){
		return numVehiculos > 0;
	}
	
	public boolean indiceVehiculoValido(int indice){
		return numVehiculos > indice;
	}
    

    @Override
    public String toString(){
        return "NOMBRE DE TALLER: "+nombre+"\nDIRECCION: "+direccion+"\nTELEFONO: "+telefono+"\n";
    }
  
}
