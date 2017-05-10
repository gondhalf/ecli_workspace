package manager;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.BotonProducto;
import model.Producto;

public class GestorProductos {
	
	private GestorBDSQLite gbd = new GestorBDSQLite();
	
	private ArrayList<Producto> getProductos(){
		String sql = "select * from productos";
		ResultSet rs = gbd.executeSQL(sql);
		ArrayList<Producto> lstProductos = new ArrayList<Producto>();
		try {
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				double precio = rs.getDouble("precio");
				String categoria = rs.getString("categoria");
				lstProductos.add(new Producto(nombre, precio, categoria));
			}
		} catch (Exception e) {//SQLException | ParseException
			e.printStackTrace();
		}
		return lstProductos;
	}
	
	public ArrayList<BotonProducto> getBotones(){
		ArrayList<BotonProducto> lstBotones = new ArrayList<BotonProducto>();
		ArrayList<Producto> lstProductos = getProductos();
		for (Producto producto : lstProductos) {
			lstBotones.add(new BotonProducto(producto));
		}
		return lstBotones;
	}

}
