import javax.swing.JOptionPane;
public class Principal {
    
    private Taller taller = new Taller("TALLER PERRON", "OTAy 1321", "664 582 3334");

    public static void main(String[] args){
        Principal p = new Principal();
        p.menu();
    }

    public void menu(){
        int opc;
        do{
			//QUITE LA OPCION DE DESPLEGAR VEHICULOS DE CLIENTE Y LA COMBINE CON
			//LA DE MOSTRAR INFORMACION DE CLIENTE
			//AGREGUE LA OPCION 5 PARA VER TODOS LOS VEHICULOS DEL TALLER
            opc = Integer.parseInt(input(
			"[1] DESPLEGAR INFORMACION DEL TALLER\n"+
            "[2] MOSTRAR INFORMACION DE CLIENTE\n"+
            "[3] CREAR CLIENTE NUEVO\n"+
            "[4] AGREGAR NUEVO VEHICULO A CLIENTE\n"+
			"[5] VER LOS VEHICULOS DEL TALLER\n"+
            "[6] ASIGNAR SERVICIO A VEHICULO EN ESPECIFICO\n"+
            "[7] GENERAR TICKET DE SERVICIO\n"+  //FALTA IMPLEMENTAR ESTA, NO SUPE BIEN QUE DEBE HACER
            "[0] SALIR "));


			// PASE LO QUE ESTABA EN LOS CASOS A FUNCIONES, ESTAN ABAJO
			//PARA QUE SE VIERA MAS LIMPIO
            switch (opc) {
				//MOSTRAR INFORMACION DEL TALLER
                case 1:
					output(taller.toString());
                break;
				//DESPLEGAR INFORMACION DE UN CLIENTE SELECCIONADO
				case 2:
					desplegarClientes();
				break;
				//CREAR UN CLIENTE NUEVO
                case 3:
					taller.crearClientenuevo();
                break;
				//AGREGAR VEHICULO A UN CLIENTE
                case 4:
					agregraVehiculoCliente();
                break;
				//DESPLEGAR LA LISTA DE VEHICULOS EN EL TALLER
                case 5:
					desplegarVehiculos();
                break;
				//AGREGAR SERVICIO A UN VEHICULO
                case 6:
					agregarServicioAVehiculo();
                break;
            }
            

        }while(opc != 0);

    }
	
	
	public void desplegarVehiculos(){
		//NO HAY VEHICULOS
		if (!taller.hayVehiculos()){
			output("NO HAY VEHICULOS");
			return;
		}
		
		int id = Integer.parseInt(input(taller.desplegarVehiculos()+ "ID: "));
		id--;
		//VALIDAR EL ID
		if (!taller.indiceVehiculoValido(id)){
			output("INDICE INVALIDO");
		}else{
			//OBTENER EL VEHICULO
			Vehiculo v = taller.getVehiculoIndice(id);
			//IMPRIMIR SUS DATOS
			output(v.toString());
		}
	}
	
	
	//HICE ESTA FUNCION PARA QUE SE DESPLIEGUEN TODOS LOS CLIENTES QUE HAY
	//Y QUE SE PUEDA SELECCIONAR UNO PARA VER SUS DATOS
	public void desplegarClientes(){
		//NO HAY CLIENTES
		if (!taller.hayClientes()){
			output("NO HAY CLIENTES");
			return;
		}
		
		int id = Integer.parseInt(input(taller.desplegarClientes()+ "ID: "));
		id--;
		//VALIDAR EL ID
		if (!taller.indiceValido(id)){
			output("INDICE INVALIDO");
		}else{
			//OBTENER EL CLIENTE
			Cliente c = taller.getClienteIndice(id);
			//IMPRIMIR SUS DATOS
			output(c + c.mostrarVehiculos());
		}
	}
	
	
	
	public void agregraVehiculoCliente(){
		//NO HAY CLIENTES
		if (!taller.hayClientes()){
			output("NO HAY CLIENTES");
			return;
		}
		
		int id = Integer.parseInt(input(taller.desplegarClientes()+"SELECCIONA EL CLIENTE:"));
		id --;
		//VALIDAR INDICE
		if(!taller.indiceValido(id)){
			output("INDICE INVALIDO");
		}else{
			//OBTENER EL CLIENTE
			Cliente c = taller.getClienteIndice(id);
			//AGREGAR UN VEHICULO AL CLIENTE
			taller.agregraVehiculoCliente(c);
		}
	}
	
	
	public void agregarServicioAVehiculo(){
		//NO HAY VEHICULOS
		if (!taller.hayVehiculos()){
			output("NO HAY VEHICULOS");
			return;
		}
		
		int id = Integer.parseInt(input(taller.desplegarVehiculos()+ "ID: "));
		id--;
		//VALIDAR EL ID
		if (!taller.indiceVehiculoValido(id)){
			output("INDICE INVALIDO");
		}else{
			//OBTENER EL VEHICULO
			Vehiculo v = taller.getVehiculoIndice(id);
			//AGREGARLE UN SERVICIO
			taller.agregarServicioAVehiculo(v);
		}
	}
	

	//ESTA FUNCION ES PARA NO TENER QUE ESCRIBIR LO DE JOPTION TODO EL RATO
	//NOMAS LE MANDAS EL MENSAJE Y TE REGRESA LA VENTANA DE INPUT
	//PERO AUN ASI TIENES QUE PONER EL INTEGER.PARSEINT O A LO QUE ESTES CONVIRTIENDO
	public String input(String mensaje){
		return JOptionPane.showInputDialog(mensaje);
	}

	//ESTA TAMBIEN ES PARA NO ESCRIBIR TANTO, NOMAS LE MANDAS EL MENSAJE Y LO DESPLIEGA
	//EJEMPLO: output("Mensaje") Y YA TE DESPLIEGA EL MENSAJE
	//Y YA NO ES NECESARIO QUE PONGAS NULL
	public void output(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
}


