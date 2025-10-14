import javax.swing.JOptionPane;
public class Principal {
    
    private Taller taller = new Taller("TALLER PERRON", "OTAy 1321", "664 582 3334");

    public static void main(String[] args){
        Principal p = new Principal();
        p.menu();
    }

    public void menu(){
        int opc =-1;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog("[1] DESPLEGAR INFORMACION DEL TALLER\n"+
            "[2] DESPLEGAR VEHICULOS DE CLIENTE\n"+
            "[3] CREAR CLIENTE NUEVO\n"+
            "[4] AGREGAR NUEVO VEHICULO A CLIENTE\n"+
            "[5] ASIGNAR SERVICIO A VEHICULO EN ESPECIFICO\n"+
            "[6] GENERAR TICKET DE SERVICIO\n"+
            "[7] SALIR "));

            switch (opc) {
                case 1:
                JOptionPane.showMessageDialog(null,taller.toString());
                    
                    break;
                case 2:

                JOptionPane.showMessageDialog(null, "\nLISTA DE CLIENTES REGISTRADOS\n\n" +taller.desplegarClientes());
                int indice1 = Integer.parseInt(JOptionPane.showInputDialog("INTRODUCIR EL INDICE DEL CLINETE A MOSTRAR SUS VEHICULOS"));
                
                if(taller.verificarCliente(indice1) >= 0){
                    Cliente c = taller.getClienteIndice(indice1);
                    JOptionPane.showMessageDialog(null,c.mostrarVehiculos());

                }else{
                    JOptionPane.showMessageDialog(null,"EL INDICE NO EXISTE\n");

                }

                break;

                case 3:
                
                taller.crearClientenuevo();
                    
                    break;
                    
                    
                case 4:

                JOptionPane.showMessageDialog(null, "\nLISTA DE CLIENTES REGISTRADOS\n\n" +taller.desplegarClientes());
                int indice = Integer.parseInt(JOptionPane.showInputDialog("INTRODUCIR EL INDICE DEL CLIENTE AL QUE LE AGREGARAS UN VEHICULO"));
                if(taller.verificarCliente(indice) >= 0){
                    Cliente c = taller.getClienteIndice(indice);
                    taller.agregraVehiculoCliente(c);

                }else{
                    JOptionPane.showMessageDialog(null,"EL INDICE NO EXISTE\n");

                }
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                
                case 7:

                    break;
            
                default:
                    break;
            }
            

        }while(opc != 7);

    }


    

 



    
}
