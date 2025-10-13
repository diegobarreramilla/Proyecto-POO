import javax.swing.JOptionPane;
public class Principal {
    Cliente[] clientes = new Cliente[100];
    private int numClientes =0;

    public static void main(String[] args){
        Principal p = new Principal();
        p.menu();
    }

    public void menu(){
        int opc =-1;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog("[1] DESPLEGAR INFORMACION DEL TALLER\n"+
            "[2] Crear un Cliente nuevo\n"+
            "[3] Agregar nuevo vehiculo al cliente\n"+
            "[4] Asiganr servicio a vehiculo en especifico\n"+
            "[5] Generar ticket de servicio\n"+
            "[6] SALIR "));

            switch (opc) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
            
                default:
                    break;
            }
            

        }while(opc != 6);

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
        

    }



    
}
