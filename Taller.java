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

    public void crearClientenuevo(){
        if(numClientes<100){


            String nombre = JOptionPane.showInputDialog("INTRODUZCA EL NOMBRE DEL CLIENTE:\n");
            String telefono = JOptionPane.showInputDialog("INTRODUZCA EL TELEFONO DEL CLIENTE:\n");
            String correo = JOptionPane.showInputDialog("INTRODUZCA EL CORRREO DEL CLIENTE:\n");

            Cliente nuevo = new Cliente(nombre,telefono,correo);
            clientes[numClientes++] = nuevo;
        }else{
            JOptionPane.showMessageDialog(null, "CANTIDAD MAXIMA DE CLIENTES");
        }
    }

       public void agregraVehiculoCliente(Cliente cliente){
            String marca;
            String modelo;
            String placa;
      
        int opc = Integer.parseInt(JOptionPane.showInputDialog(null,"[1] Auto\n [2] Motocicleta\n"));
        

        switch (opc) {
            case 1:
            
            
            marca = JOptionPane.showInputDialog("INTRODUZCA LA MARCA DEL VEHICULO:\n");
            modelo = JOptionPane.showInputDialog("INTRODUZCA EL MODELO DEL VEJICULO:\n");
            placa = JOptionPane.showInputDialog("INTRODUZCA EL NUMERO DE PLACA:\n");
            int numPuertas = Integer.parseInt(JOptionPane.showInputDialog("INTRODUZCA EL NUMERO DE PUERTAS: \n"));
            String tipoCombustible = JOptionPane.showInputDialog("INTRODUZCA EL TIPO DE COMBUSTIBLE: \n");
            String tipoMotor = JOptionPane.showInputDialog("INTRODUZCA EL TIPO DE MOTOR: \n");
            Vehiculo nuevoAuto  = new Auto(numPuertas,tipoCombustible,tipoMotor,marca,modelo,placa,cliente); 
            vehiculos[numVehiculos++] = nuevoAuto;
            cliente.agregarVehiculo(nuevoAuto);
                break;
            case 2:
            marca = JOptionPane.showInputDialog("INTRODUZCA LA MARCA DEL VEHICULO:\n");
            modelo = JOptionPane.showInputDialog("INTRODUZCA EL MODELO DEL VEJICULO:\n");
            placa = JOptionPane.showInputDialog("INTRODUZCA EL NUMERO DE PLACA:\n");
        
            int cilindrada = Integer.parseInt(JOptionPane.showInputDialog("INTRODUZCA LA CILINDRADA: \n"));
            String tipoCadena = JOptionPane.showInputDialog("INTRODUZCA EL TIPO DE CADENA: \n");
            Vehiculo nuevaMoto = new Motocicleta(cilindrada, tipoCadena, marca,  modelo,  placa, cliente);
            vehiculos[numVehiculos++] = nuevaMoto;
            cliente.agregarVehiculo(nuevaMoto);
            
                break;
        
            default:
            JOptionPane.showMessageDialog(null,"OPCION INCORRECTA");
                break;
        }



    }

   

    public String desplegarClientes(){
        String info = "";
            for(int i =0;i< numClientes;i++){
                info +="INDICE: "+ i + ":"+ clientes[i].toString() + "\n";
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

    public int verificarCliente(int indice){
        if(numClientes!= 0 && indice < numClientes){

            return indice;
        }   
        else{

            
            return-1;
        }
    }
    
    

    @Override
    public String toString(){
        return "NOMBRE DE TALLER: "+nombre+" DIRECCION: "+direccion+" TELEFONO: "+telefono+"\n";
    }

    


    
}
