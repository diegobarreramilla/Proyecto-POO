import javax.swing.JOptionPane;
public class Principal {
    
    private Taller taller = new Taller("TALLER PERRON", "OTAy 1321", "664 582 3334");

    public static void main(String[] args){
        Principal p = new Principal();
        p.menu();
    }

    public void menu(){
		ejemplos();
		
        int opc;
        do{
			//QUITE LA OPCION DE DESPLEGAR VEHICULOS DE CLIENTE Y LA COMBINE CON
			//LA DE MOSTRAR INFORMACION DE CLIENTE
			//AGREGUE LA OPCION 5 PARA VER TODOS LOS VEHICULOS DEL TALLER
			
			
            opc = Integer.parseInt(input(
			taller.toString()+"\n[1] MOSTRAR INFORMACION TALLER\n"+
            "[2] MOSTRAR INFORMACION DE CLIENTE\n"+
            "[3] CREAR CLIENTE NUEVO\n"+
            "[4] AGREGAR NUEVO VEHICULO A CLIENTE\n"+
			"[5] VER LOS VEHICULOS DEL TALLER\n"+
			"[6] MOSTRAR AUTOS\n"+
			"[7] MOSTRAR MOTOCICLETAS\n"+
            "[8] ASIGNAR SERVICIO A VEHICULO EN ESPECIFICO\n"+ 
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

				String nombre = input("INTRODUZCA EL NOMBRE DEL CLIENTE:\n");
            	String telefono = input("INTRODUZCA EL TELEFONO DEL CLIENTE:\n");
            	String correo = input("INTRODUZCA EL CORRREO DEL CLIENTE:\n");

				boolean creado =taller.crearClientenuevo(nombre,telefono,correo);
				if(creado != false){
					output("EL CLIENTE SE CREO CORRECTAMENTE");
				}else{
					output("SE HA ALCANZADO EL LIMITE DE CLIENTES");
				}

                break;
				//AGREGAR VEHICULO A UN CLIENTE
                case 4:	
				///OBTENEMOS EL CLIENTE
				int ind = Integer.parseInt(input(taller.desplegarClientes()+"\nINTRODUZCA EL INDICE DEL CLINENTE AL QUE DESEA AGREGAR UN VEHICULO\n"));
				Cliente actual = (taller.getClienteIndice((ind-1) )) ;
				int  opcion =Integer.parseInt(input("[1] AGREGAR AUTO\n	[2] AGREGAR MOTOCICLETA"));


						////ATRIBUTOS DE TODOS LOS VEHICULOS
						String marca = input("INTRODUZCA LA MARCA DEL VEHICULO:\n");
						String modelo = input("INTRODUZCA EL MODELO DEL VEJICULO:\n");
						String placa = input("INTRODUZCA EL NUMERO DE PLACA:\n");


				switch (opcion) {
					case 1:
						///ATRIBUTROS DE AUTO	
						
						int numPuertas = Integer.parseInt(input("INTRODUZCA EL NUMERO DE PUERTAS: \n"));
						String tipoCombustible = input("INTRODUZCA EL TIPO DE COMBUSTIBLE: \n");
						String tipoMotor = input("INTRODUZCA EL TIPO DE MOTOR: \n");	

						//CREAMS EL VEHICULO NUEVO
						Vehiculo actualCarro = new Auto(actual, marca, modelo, placa, tipoMotor, tipoCombustible, numPuertas);
						actual.agregarVehiculo(actualCarro);
						taller.agregarVehiculo(actualCarro);
						break;
					case 2:
						int cilindrada = Integer.parseInt(input("INTRODUZCA LA CILINDRADA: \n"));
						String tipoCadena = input("INTRODUZCA EL TIPO DE CADENA: \n");

						Vehiculo actualMoto = new Motocicleta(actual, marca, modelo, placa, tipoCadena, cilindrada);
						actual.agregarVehiculo(actualMoto);
						taller.agregarVehiculo(actualMoto);
						break;
				
					default:
					output("OPCION ERRONEA");
						break;
				}
                break;
				//DESPLEGAR LA LISTA DE VEHICULOS EN EL TALLER
                case 5:
					desplegarVehiculos();
                break;
				
				case 6:
					//MOSTRAR AUTOS SOLAMENTE (POLIMORFISMO)
					output(taller.mostrarAutos());
				break;
				
				case 7:
					//MOSTRAR MOTOS SOLAMENTE (POLIMORFISMO)
					output(taller.mostrarMotocicletas());
				break;
                case 8:
				
				///OBTENEMOS EL CLIENTE
				int index = Integer.parseInt(input(taller.desplegarClientes()+"\nINTRODUZCA EL INDICE DEL CLINENTE AL QUE DESEA AGREGAR EL SERVICIOO\n"));
				Cliente act = taller.getClienteIndice((index-1));


				if(act !=  null){
				
				
				//AGREGAR SERVICIO A UN VEHICULO

				int tipoServicio = Integer.parseInt(input("[1] CAMBIO DE ACEITE Y FILTRO DE AIRE\n[2] AFINACION\n[3] SERVICIO DE fRENOS COMPLETO\n[4] DIAGNOSTICO ELECTRICO")); 

				
				
				int op = Integer.parseInt(input(act.mostrarVehiculos()+"\n"+"INTRODUZCA EL INDICE DEL VEHICULO A AGREGAR EL SERVICIO"));
				Vehiculo vehiculoServicio = act.getVehiculo((op-1));

				
            	String fecha = input("FECHA:");
				String nombreMecanico = input("INTRODUZCA EL NOMBRE DEL MECANICO QUE REALIZARA/REALIZO EL SERVICIO");


				switch (tipoServicio) {
					///acxeite
					case 1:
						Servicio aceite = new CambioAceite(fecha, nombreMecanico);
						vehiculoServicio.agregarServicio(aceite);
						taller.agregarServicio(aceite);
						
						break;
						///afinacion
					case 2:
						Servicio afinacion = new Afinacion(fecha, nombreMecanico);

						vehiculoServicio.agregarServicio(afinacion);
						taller.agregarServicio(afinacion);
						
						break;
						///frenos
					case 3:
						Servicio Frenos = new ServicioFrenos(fecha, nombreMecanico);

						vehiculoServicio.agregarServicio(Frenos);
						taller.agregarServicio(Frenos);
						
						break;
						////electrivo
					case 4:
						Servicio electrico = new DiagnosticoElectrico(fecha, nombreMecanico);

						vehiculoServicio.agregarServicio(electrico);
						taller.agregarServicio(electrico);
						break;
					default:
						break;
				}
					}else{
						output("ERROR");
					}

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
		
		int id = Integer.parseInt(input(taller.desplegarVehiculos()+ "SELECCIONE UN VEHICULO ESPECIFICO A CONSULTAR: "));
		id--;
		//VALIDAR EL ID
		if (!taller.indiceVehiculoValido(id)){
			output("INDICE INVALIDO");
		}else{
			//OBTENER EL VEHICULO
			Vehiculo v = taller.getVehiculoIndice(id);
			//IMPRIMIR SUS DATOS
			output(v.toString()+ "\nSERVICIOS REALIZADOS: \n"+v.mostrarServicios());
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
		
		int id = Integer.parseInt(input(taller.desplegarClientes()+ "INDICE DEL CLIENTE A CONSULTAR INFORMACION "));
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
	
	
	public void ejemplos(){
		
		// Clientes
		Cliente cliente1 = new Cliente("Mariana Torres", "553-284-9172", "mariana.torres92@example.com");
		Cliente cliente2 = new Cliente("Alejandro Ríos", "442-781-6605", "alejandro.rios87@example.com");
		Cliente cliente3 = new Cliente("Sofía Martínez", "331-920-5548", "sofia.martinez11@example.com");
		Cliente cliente4 = new Cliente("Daniel Herrera", "662-478-3910", "daniel.herrera03@example.com");
		Cliente cliente5 = new Cliente("Carla Mendoza", "818-703-2246", "carla.mendoza75@example.com");
		
		
		//Vehiculos
		Vehiculo vehiculo1 = new Auto(cliente1, "Toyota", "Corolla", "XZN-4821", "1.8L I4", "Gasolina", 4);
		Vehiculo vehiculo2 = new Auto(cliente2, "Honda", "Civic", "JKP-9217", "2.0L I4", "Gasolina", 4);
		Vehiculo vehiculo3 = new Auto(cliente3, "Nissan", "Sentra", "RBT-3056", "1.6L I4", "Gasolina", 4);
		Vehiculo vehiculo4 = new Auto(cliente4, "Mazda", "CX-5", "HGF-7782", "2.2L Turbo Diesel", "Diesel", 5);
		Vehiculo vehiculo5 = new Auto(cliente5, "Chevrolet", "Malibu", "WQP-1169", "2.5L I4", "Gasolina", 4);
		
		Vehiculo vehiculo6 = new Motocicleta(cliente1, "Yamaha", "MT-03", "MTR-8834", "Sellada (O-Ring)", 321);
		Vehiculo vehiculo7 = new Motocicleta(cliente2, "Honda", "CB190R", "HND-5521", "Normal", 184);
		Vehiculo vehiculo8 = new Motocicleta(cliente3, "Kawasaki", "Ninja 400", "KNJ-9042", "Sellada (X-Ring)", 399);
		Vehiculo vehiculo9 = new Motocicleta(cliente4, "Suzuki", "GSX-S750", "SZX-3320", "Sellada (O-Ring)", 749);
		Vehiculo vehiculo10 = new Motocicleta(cliente5, "Italika", "FT150", "ITK-2178", "Normal", 150);
		
		
		cliente1.agregarVehiculo(vehiculo1);
		cliente1.agregarVehiculo(vehiculo6);
		cliente2.agregarVehiculo(vehiculo2);
		cliente2.agregarVehiculo(vehiculo7);
		cliente3.agregarVehiculo(vehiculo3);
		
		cliente3.agregarVehiculo(vehiculo8);
		cliente4.agregarVehiculo(vehiculo4);
		cliente4.agregarVehiculo(vehiculo9);
		cliente5.agregarVehiculo(vehiculo5);
		cliente5.agregarVehiculo(vehiculo10);
		
		taller.agregarCliente(cliente1);
		taller.agregarCliente(cliente2);
		taller.agregarCliente(cliente3);
		taller.agregarCliente(cliente4);
		taller.agregarCliente(cliente5);
		
		taller.agregarVehiculo(vehiculo1);
		taller.agregarVehiculo(vehiculo2);
		taller.agregarVehiculo(vehiculo3);
		taller.agregarVehiculo(vehiculo4);
		taller.agregarVehiculo(vehiculo5);
		taller.agregarVehiculo(vehiculo6);
		taller.agregarVehiculo(vehiculo7);
		taller.agregarVehiculo(vehiculo8);
		taller.agregarVehiculo(vehiculo9);
		taller.agregarVehiculo(vehiculo10);
		
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


