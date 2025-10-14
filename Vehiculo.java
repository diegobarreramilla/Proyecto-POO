public class Vehiculo {
    protected String marca;
    protected String modelo;
    protected String placa;
    //// cliente al que pertenece
    protected Cliente cliente;
    protected Servicio[] servicios = new Servicio[100];

    public Vehiculo(String marca, String modelo, String placa,Cliente cliente){
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.cliente = cliente;
        

    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    
    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString(){
        return "MARCA: "+marca+" MODELO: "+modelo+" PLACA: "+placa+"\n";
    }

    
    
}
