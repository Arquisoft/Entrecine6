package main.java.es.uniovi.asw.entrecine.administration;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import main.java.es.uniovi.asw.entrecine.administration.es.persisntece.BillboardCommitDao;
import main.java.es.uniovi.asw.entrecine.administration.es.persisntece.BillboardDao;
import main.java.es.uniovi.asw.entrecine.administration.es.persisntece.SaleDao;
import main.java.es.uniovi.asw.entrecine.administration.es.persisntece.UserDao;
import es.uniovi.asw.entrecine.central.system.model.*;


/**
 * Esta clase será eliminada una vez que la base de datos este concluida su
 * finalidad es la de simular el comportamiento de la BBDD
 * 
 * @author Davicin
 * 
 */

public class DataBaseSystem implements UserDao,SaleDao,BillboardDao,BillboardCommitDao {
	private List<Movie> peliculas;

	private List<User> usuarios;

	public void updateCartelera(Billboard cartelera) {
		this.cartelera = cartelera;
	}

	public Billboard getCartelera() {
		return cartelera;
	}

	public List<User> getUsuarios() {
		return usuarios;
	}

	public List<Sale> getVentas() {
		return ventas;
	}


	private List<Sale> ventas;

	int contador;

	private Billboard cartelera;

	public DataBaseSystem() {
		peliculas = new ArrayList<Movie>();
		usuarios = new ArrayList<User>();
		ventas = new ArrayList<Sale>();
		leerPeliculas();
		leerCartelera();
		leerUsuarios();
		leerVentas();
	}

	public void leerPeliculas() {
		String linea = "";
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(
					"files/peliculas.dat"));
			while (fichero.ready()) {
				linea = fichero.readLine();
				String[] trozos = linea.split("@");
				Movie p = new Movie();
				p.setId(Long.parseLong(trozos[0]));
				p.setName(trozos[1]);
				p.setSinopsis(trozos[2]);
				p.setDuration(Integer.parseInt(trozos[3]));
				p.setPrize(Integer.parseInt(trozos[4]));

				peliculas.add(p);

			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(null,
					"El archivo no se ha encontrado");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	public void leerUsuarios() {
		String linea = "";
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(
					"files/usuarios.dat"));
			while (fichero.ready()) {
				linea = fichero.readLine();
				String[] trozos = linea.split("@");
				User u = new User(Long.parseLong(trozos[0]), trozos[1],
						trozos[2], null, linea, null, null, null);

				usuarios.add(u);

			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(null,
					"El archivo no se ha encontrado");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	public void leerVentas() {
		String linea = "";
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(
					"files/ventas.dat"));
			while (fichero.ready()) {
				linea = fichero.readLine();
				String[] trozos = linea.split("@");
				Sale s = new CreditCardSale();

				ventas.add(s);

			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(null,
					"El archivo no se ha encontrado");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	public void leerCartelera() {
		String linea = "";
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(
					"files/cartelera.dat"));
			List<Movie> aux = new ArrayList<Movie>();
			while (fichero.ready()) {
				linea = fichero.readLine();
				String[] trozos = linea.split("@");

				Movie p = new Movie();
				p.setId(Long.parseLong(trozos[0]));
				p.setName(trozos[1]);
				p.setSinopsis(trozos[2]);
				p.setDuration(Integer.parseInt(trozos[3]));
				p.setPrize(Integer.parseInt(trozos[4]));

				aux.add(p);

			}
			cartelera = new Billboard();
			cartelera.setMovies(aux);
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(null,
					"El archivo no se ha encontrado");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}
	



	@Override
	public Billboard getRawBillboard() {
		// TODO Auto-generated method stub
		return getCartelera();
	}

	@Override
	public void updateBillboard(Billboard b) {
		// TODO Auto-generated method stub
		this.cartelera=b;
	}

	@Override
	public List<Sale> getSales() {
		// TODO Auto-generated method stub
		return getSales();
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return getUsers();
	}



	@Override
	public User findByName(String name) {
		for (User u : usuarios) {
			if(name==u.getName())
				return u;
		}
		return null;
	}

	@Override
	public User findByLogin(String login) {
		for (User u : usuarios) {
			if(login==u.getUserName())
				return u;
		}
		return null;
	}

	@Override
	public Sale findById(Long id) {
		for (Sale s : ventas) {
			if(s.getId()==id)
				return s;
		}
		return null;
	}

	
}
