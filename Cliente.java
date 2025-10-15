import javax.swing.JOptionPane;

public class Cliente {
    private String nombre;
    private String telefono;
    private String correo;
    private Vehiculo[] vehiculos = new Vehiculo[10];
    private int numVehiculo =0;

    public Cliente(String nombre, String telefono,String correo){
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        

    }
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
	
	public int getNumVehiculos() { return numVehiculo;}
	
	//AGREGUE ESTA FUNCION PARA RETORNAR ALGUN VEHICULO DE LA LISTA DE VEHICULOS
	public Vehiculo getVehiculo(int id){
		return vehiculos[id];
	}

    ///agregar vehiculo  la lista de vehiculos de cliente
    public void agregarVehiculo(Vehiculo vehiculo){
        if(numVehiculo<10){
            vehiculos[numVehiculo++] = vehiculo;


        }else{
            JOptionPane.showMessageDialog(null,"EL CLIENTE ALCANZO LA CANTIDAD MAXIMA DE VEHICULOS");
        }

    } 

    public String mostrarVehiculos(){
        String info = "";

        for(int i =0; i<numVehiculo;i++){
            info += vehiculos[i].getModelo();
        }
        return info;
    }

    @Override
    public String toString(){
        return "\nNombre: "+ nombre+"\nTelefono: "+telefono+"\nCorreo: " +correo+ "\nVehiculos registrados: "+numVehiculo+"\n" ;
    }


    





    
    
    
}
