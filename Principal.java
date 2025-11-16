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
						Vehiculo actualCarro = new Auto(numPuertas, tipoCombustible, tipoMotor, marca, modelo, placa, actual);
						actual.agregarVehiculo(actualCarro);
						taller.agregarVehiculo(actualCarro);
						break;
					case 2:
						int cilindrada = Integer.parseInt(input("INTRODUZCA LA CILINDRADA: \n"));
						String tipoCadena = input("INTRODUZCA EL TIPO DE CADENA: \n");

						Vehiculo actualMoto = new Motocicleta(cilindrada, tipoCadena, marca, modelo, placa, actual);
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


