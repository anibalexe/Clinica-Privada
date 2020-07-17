package transacciones;

import java.util.ArrayList;

import stocks.Insumo;

public class Servicio {
	private ArrayList<Insumo> insumos;
	private int id;
	private String nombre;
	private float manoDeObra;
	private float montoBruto;
	
	public Servicio(int id, String nombre, int manoDeObra) {
		this.id = id;
		this.nombre = nombre;
		this.manoDeObra = manoDeObra;
		insumos = new ArrayList<Insumo>();
	}
	public Servicio(int id, String nombre, ArrayList<Insumo> ins) {
		this.id = id;
		this.nombre = nombre;
		insumos = ins;
		montoBruto = calcularMontoBruto();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getManoDeObra() {
		return manoDeObra;
	}
	public void setManoDeObra(int manoDeObra) {
		this.manoDeObra = manoDeObra;
	}
	public float getMontoBruto() {
		return montoBruto;
	}
	public void setMontoBruto(float montoBruto) {
		this.montoBruto = montoBruto;
	}
	
	//recorre la lista de insumos y retorna el monto bruto
	public float calcularMontoBruto() {
		int montofinal = 0;
		for(int i=0; i<insumos.size();i++) {
			montofinal = montofinal+insumos.get(i).getValor();
		}
		setMontoBruto(montofinal+manoDeObra);
		return montoBruto;
	}
	//retorna los insumos del servicio
	public ArrayList<Insumo> mostrarInsumos(){
		return insumos;
	}
	//agrega un insumo al servicio
	public void agregarInsumo(Insumo in) {
		insumos.add(in);
		calcularMontoBruto();
	}
	//agrega insumos al servicio
	public void agregarInsumo(ArrayList<Insumo> ins) {
		for(int i=0; i<ins.size();i++) {
			insumos.add(ins.get(i));
		}
		calcularMontoBruto();
	}
}
