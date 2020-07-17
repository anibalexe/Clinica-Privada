package cuentas;
/*package otros;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import conexiones.ConexionBaseDeDatos;
import stocks.Almacen;
import stocks.Espacio;
import stocks.Estante;
import stocks.Insumo;
import ventanas.MainFrame;

public class MenuAnterior {
	/*ConexionBaseDeDatos conexion = new ConexionBaseDeDatos();
	conexion.conectarMySQL();
	Almacen al = conexion.sacarInsumosDB();
	/* Esta parte genera los 3 tipos de reporte que estan en la carpeta
	al.generarReporte();
	al.mostrarEstante(1).generarReporte();
	al.mostrarEstante(1).mostrarEspacio(1).generarReporte();
	
	BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
	while(true) {
	System.out.println("Selecione una opcion :");
	System.out.println("1)Estantes");
	System.out.println("2)Espacios");
	System.out.println("3)Insumos");
	System.out.println("4)Agregar Insumos al Almacen");
	System.out.println("5)Eliminar Insumos de Almacen");
	System.out.println("6)Insumos por vencer");
	System.out.println("7)Ventana");
	int opcion = Integer.parseInt(lector.readLine());
	if(opcion==1) {
		System.out.println("Estante(s)");
		System.out.println("1)Agregar");
		System.out.println("2)Editar");
		System.out.println("3)Eliminar");
		System.out.println("4)Reporte");
		int alternativa = Integer.parseInt(lector.readLine());
		if(alternativa==1) {
			System.out.println("Ingrese Id y Capacidad :");
			Estante es = new Estante(Integer.parseInt(lector.readLine()), Integer.parseInt(lector.readLine()), al.getSala());
			if(!al.agregarEstanteBD(es))
				System.out.println("No se puede agregar ya que supera la capacidad del almacen :"+al.getCapacidad());;
		}
		if(alternativa==2) {
			System.out.println("Selecione una opcion :");
			System.out.println("1)Modificar id");
			System.out.println("2)Modificar Capacidad");
			System.out.println("3)Modificar Sala");
			int alternativa2 = Integer.parseInt(lector.readLine());
			if(alternativa2==1) {
				System.out.println("Ingrese Id y nueva Id:");
				al.mostrarEstante(Integer.parseInt(lector.readLine())).modificarEstanteId(Integer.parseInt(lector.readLine()));
			}
			if(alternativa2==2) {
				System.out.println("Ingrese Id y nueva Capacidad:");
				al.mostrarEstante(Integer.parseInt(lector.readLine())).modificarEstanteCapacidad(Integer.parseInt(lector.readLine()));
			}
			if(alternativa2==3) {
				System.out.println("Ingrese Id y nueva Sala:");
				al.mostrarEstante(Integer.parseInt(lector.readLine())).modificarEstanteSala(Integer.parseInt(lector.readLine()));
			}		
		}
		if(alternativa==3) {
			System.out.println("Ingrese Id :");
			Estante es = al.eliminarEstante(Integer.parseInt(lector.readLine()));
			System.out.println("El estante "+es.getId()+" fue eliminado");
		}
		if(alternativa==4) {
			System.out.println("Estantes en el Almacen :");
			System.out.println("Id - Capacidad - Sala");
			for(int i=0;i<al.contarEstantes();i++) {
				System.out.println(al.mostrarEstantePosicion(i).getId()+"  -  "+al.mostrarEstantePosicion(i).getCapacidad()+"    -    "+al.mostrarEstantePosicion(i).getSala());
			}
		}
	}
	if(opcion==2) {
		System.out.println("Ingrese el id del Estante  :");
		int idest = Integer.parseInt(lector.readLine());
		System.out.println("Espacio(s)");
		System.out.println("1)Agregar");
		System.out.println("2)Editar");
		System.out.println("3)Eliminar");
		System.out.println("4)Reporte");	
		int alternativa = Integer.parseInt(lector.readLine());
		if(alternativa==1) {
			System.out.println("Ingrese Id y Capacidad :");
			Espacio es = new Espacio(Integer.parseInt(lector.readLine()), Integer.parseInt(lector.readLine()), al.mostrarEstante(idest).getId());
			if(!al.mostrarEstante(idest).agregarEspacioBD(es))
				System.out.println("No se puede agregar ya que supera la capacidad del Estante :"+al.mostrarEstante(idest).getCapacidad());;
		}
		if(alternativa==2) {
			System.out.println("Selecione una opcion :");
			System.out.println("1)Modificar id");
			System.out.println("2)Modificar Capacidad");
			System.out.println("3)Modificar idEstante");
			int alternativa2 = Integer.parseInt(lector.readLine());
			if(alternativa2==1) {
				System.out.println("Ingrese Id y nueva Id:");
				al.mostrarEstante(idest).mostrarEspacio(Integer.parseInt(lector.readLine())).modificarEspacioId(Integer.parseInt(lector.readLine()));
			}
			if(alternativa2==2) {
				System.out.println("Ingrese Id y nueva Capacidad:");
				al.mostrarEstante(idest).mostrarEspacio(Integer.parseInt(lector.readLine())).modificarEspacioCapacidad(Integer.parseInt(lector.readLine()));
			}
			if(alternativa2==3) {
				System.out.println("Ingrese Id y nueva IdEstante :");
				al.mostrarEstante(idest).mostrarEspacio(Integer.parseInt(lector.readLine())).modificarEspacioIdEstante(Integer.parseInt(lector.readLine()));
			}	
		}
		if(alternativa==3) {
			System.out.println("Ingrese Id :");
			al.mostrarEstante(idest).eliminarEspacio(Integer.parseInt(lector.readLine()));
		}
		if(alternativa==4) {
			System.out.println("Espacios en el Estante :");
			System.out.println("Id - Capacidad ");
			for(int i=0;i<al.mostrarEstante(idest).contarEspacios();i++) {
				System.out.println(al.mostrarEstante(idest).mostrarEspacioPosicion(i).getId()+"  -  "+al.mostrarEstante(idest).mostrarEspacioPosicion(i).getCapacidad());
			}
		}
	}
	if(opcion==3) {
		System.out.println("Ingrese el id del Estante, id del espacio dentro del estante");
		int idest = Integer.parseInt(lector.readLine());
		int idesp = Integer.parseInt(lector.readLine());
		System.out.println("Insumo(s)");
		System.out.println("1)Agregar");
		System.out.println("2)Editar");
		System.out.println("3)Eliminar");
		System.out.println("4)Reporte");
		int alternativa = Integer.parseInt(lector.readLine());
		if(alternativa==1) {
			System.out.println("Ingrese Id, precio, nombre y  fecha de vencimiento(año-mes-dia) :");
			Insumo in = new Insumo(Integer.parseInt(lector.readLine()), Integer.parseInt(lector.readLine()), lector.readLine(), Integer.parseInt(lector.readLine()), Integer.parseInt(lector.readLine()), Integer.parseInt(lector.readLine()), al.mostrarEstante(idest).mostrarEspacio(idesp).getId());
			if(!al.mostrarEstante(idest).mostrarEspacio(idesp).agregarInsumoDB(in))
				System.out.println("No se puede agregar ya que supera la capacidad del Espacio :"+al.mostrarEstante(idest).mostrarEspacio(idesp).getCapacidad());;
		
		}
		if(alternativa==2) {
			System.out.println("Selecione una opcion :");
			System.out.println("1)Modificar id");
			System.out.println("2)Modificar Valor");
			System.out.println("3)Modificar Nombre");
			System.out.println("4)Modificar Fecha vencimiento");
			System.out.println("5)Modificar IdEspacio");
			int alternativa2 = Integer.parseInt(lector.readLine());
			if(alternativa2==1) {
				System.out.println("Ingrese Id y nueva Id :");
				al.mostrarEstante(idest).mostrarEspacio(idesp).mostrarInsumo(Integer.parseInt(lector.readLine())).modificarInsumoId(Integer.parseInt(lector.readLine()));
			}
			if(alternativa2==2) {
				System.out.println("Ingrese Id y nueva Valor :");
				al.mostrarEstante(idest).mostrarEspacio(idesp).mostrarInsumo(Integer.parseInt(lector.readLine())).modificarInsumoValor(Integer.parseInt(lector.readLine()));
			}
			if(alternativa2==3) {
				System.out.println("Ingrese Id y nueva Nombre :");
				al.mostrarEstante(idest).mostrarEspacio(idesp).mostrarInsumo(Integer.parseInt(lector.readLine())).modificarInsumoNombre(lector.readLine());
			}
			if(alternativa2==4) {
				System.out.println("Ingrese Id y nueva Fecha vencimiento(Año-Mes-Dia) :");
				@SuppressWarnings("deprecation")
				Date fechaNew = new Date(Integer.parseInt(lector.readLine())-1900,Integer.parseInt(lector.readLine())-1,Integer.parseInt(lector.readLine()));
				al.mostrarEstante(idest).mostrarEspacio(idesp).mostrarInsumo(Integer.parseInt(lector.readLine())).modificarInsumoFecha(fechaNew);
			}
			if(alternativa2==5) {
				System.out.println("Ingrese Id y nueva IdEstante :");
				al.mostrarEstante(idest).mostrarEspacio(idesp).mostrarInsumo(Integer.parseInt(lector.readLine())).modificarInsumoIdEspacio(Integer.parseInt(lector.readLine()));
			}
		}
		if(alternativa==3) {
			System.out.println("Ingrese Id :");
			al.mostrarEstante(idest).mostrarEspacio(idesp).eliminarInsumoDB(Integer.parseInt(lector.readLine()));
		}
		if(alternativa==4) {
			System.out.println("Insumos en el Espacio :");
			System.out.println("Id - Valor - Nombre - FechaVencimiento ");
			for(int i=0;i<al.mostrarEstante(idest).mostrarEspacio(idesp).contarInsumos();i++) {
				Insumo in = al.mostrarEstante(idest).mostrarEspacio(idesp).mostrarInsumoPosicion(i);
				System.out.println(in.getId()+"  -  "+in.getValor()+"  -  "+in.getNombre()+"  -  "+in.getFecha());
			}
		}
	}
	if(opcion==4) {
		System.out.println("Ingrese Id, precio, nombre,  fecha de vencimiento(año-mes-dia) :");
		Insumo in = new Insumo(Integer.parseInt(lector.readLine()), Integer.parseInt(lector.readLine()), lector.readLine(), Integer.parseInt(lector.readLine()), Integer.parseInt(lector.readLine()), Integer.parseInt(lector.readLine()), 0);
		System.out.println("Ingrese Cantidad :");
		int cant = al.agregarInsumosAlmacen(in, Integer.parseInt(lector.readLine()));
		if(cant!=0)System.out.println("No se pudieron agregar "+cant+" insumos");
	}
	if(opcion==5) {
		System.out.println("Insumos en estante :");
		ArrayList<Insumo> lista = new ArrayList<Insumo>();
		lista = al.agruparInsumosAlmacen();
		for(int i=0;i<lista.size();i++) {
			Insumo in1 = lista.get(i);
			System.out.println(in1.getId()+" - "+in1.getValor()+"-"+in1.getNombre()+"-"+in1.getFecha());
		}
		
		System.out.println("Ingrese Id, Cantidad :");
		int idinsumo = Integer.parseInt(lector.readLine());
		int cantidad = Integer.parseInt(lector.readLine());
		if(cantidad<=al.contarInsumosAlmacen(idinsumo)) al.eliminarInsumosAlmacen(idinsumo, cantidad);
		System.out.println("No se puede eliminar. Cantidad actual de insumos de ese tipo :"+al.contarInsumosAlmacen(idinsumo));
	}
	if(opcion==6) {
		System.out.println("Insumos por vencer :");
		ArrayList<Insumo> vencer = new ArrayList<Insumo>();
		vencer = al.verificarFechasInsumosAlmacen();
		System.out.println("Id-Valor-Nombre-FechaVencimiento-diasParaCaducar");
		for(int i=0;i<vencer.size();i++) {
			Insumo in = vencer.get(i);
			System.out.println(in.getId()+" - "+in.getValor()+"-"+in.getNombre()+"-"+in.getFecha()+"  -  "+in.getDiasParaCaducar());
		}
	}
	if(opcion==7) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame(al);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

}
}*/
