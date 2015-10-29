package negocio;

import java.sql.Date;
import java.util.ArrayList;

public class Pedido {

	private String idPedido;
	private String numeroPedido;
	private Cliente clientePedido;
	private String fechaPedido;
	private ArrayList<DetallePedido> detPedido;
	private double totalPedido;
	private boolean pagoConfirmado;
	private boolean pedidoPreparado;
    private int cliente;
    private double subTotal;
	private boolean Adomicilio;
	private String estado;

	public Pedido(String numPed, Cliente clientePedido, String fechaPedido,
			double totalPedido) {

		this.numeroPedido = numPed;
		this.clientePedido = clientePedido;
		this.fechaPedido = fechaPedido;
		this.totalPedido = totalPedido;
		this.pagoConfirmado = false;
		this.pedidoPreparado = false;
	}
	  public Pedido(String idPedido, String numPed,int cliente,
				String fechaPedido,double totalPedido,int pagoConfirmado,int pedidoPreparado,int Adomicilio) {

			this.idPedido = idPedido;
			this.numeroPedido = numPed;
	        this.cliente=cliente;
			this.fechaPedido = fechaPedido;
			this.totalPedido = totalPedido;
	                
	                if(pagoConfirmado==0){this.pagoConfirmado = false;}
	                else{this.pagoConfirmado=true;}
	                
	                if(pedidoPreparado==0){this.pedidoPreparado = false;}
	                else{this.pedidoPreparado=true;}
	                
	                if(Adomicilio==0){this.Adomicilio = false;}
	                else{this.Adomicilio=true;}
	                
		}
	  
	  public Pedido(String idPedido, String numPed,int cliente,
				String fechaPedido, double totalPedido,int Adomicilio,String estado) {

			this.idPedido = idPedido;
			this.numeroPedido = numPed;
	                this.cliente=cliente;
			this.fechaPedido = fechaPedido;
			this.subTotal = subTotal;
			this.totalPedido = totalPedido;        
	                if(Adomicilio==0){this.Adomicilio = false;}
	                else{this.Adomicilio=true;}
	                
	                this.estado=estado;
	                
		}
	
	public String getIdPedido() {
		return this.idPedido;
	}
	public ArrayList<DetallePedido> getDetPedido() {
		return detPedido;
	}

	public void setDetPedido(ArrayList<DetallePedido> detPedido) {
		this.detPedido = detPedido;
	}

	public boolean isPagoConfirmado() {
		return pagoConfirmado;
	}

	public void setPagoConfirmado(boolean pagoConfirmado) {
		this.pagoConfirmado = pagoConfirmado;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public boolean isPedidoPreparado() {
		return pedidoPreparado;
	}

	public void setPedidoPreparado(boolean pedidoPreparado) {
		this.pedidoPreparado = pedidoPreparado;
	}

	public Cliente getClientePedido() {
		return clientePedido;
	}

	public void setClientePedido(Cliente clientePedido) {
		this.clientePedido = clientePedido;
	}

	public String getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(String fechaActual) {
		this.fechaPedido = fechaActual;
	}

	public double getTotalPedido() {
		return totalPedido;
	}

	public void setTotalPedido(double totalPedido) {
		this.totalPedido = totalPedido;
	}
    public int getintpagoconfirmado(){
        int retorno;
        if(this.pagoConfirmado==true){
            retorno =1;
        }
        else{
            retorno= 0;
        }
        return retorno;
    }
    public int getintpreparado(){
        int retorno;
        if(this.pedidoPreparado==true){
            retorno =1;
        }
        else{
            retorno= 0;
        }
        return retorno;
    }
    public boolean getpagoconfirmado(){
        return this.pagoConfirmado;
    }

    public boolean getpreparado(){
        return this.pedidoPreparado;
    }
    public int getIdcliente(){
        return this.cliente;
    }

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	
}
    public boolean getAdomicilio(){
        return this.Adomicilio;
    }
    
    public String getestado(){
        return this.estado;
    }
    public void setestado(String estado){
        this.estado=estado;
    }
}
