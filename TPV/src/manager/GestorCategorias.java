package manager;

import java.sql.ResultSet;
import java.util.ArrayList;

public class GestorCategorias {
	
	private GestorBDSQLite gbd = new GestorBDSQLite();
	
	public ArrayList<String> getCategorias(){
		String sql = "select * from categorias";
		ResultSet rs = gbd.executeSQL(sql);
		ArrayList<String> lstCategorias = new ArrayList<String>();
		try {
			while (rs.next()) {
				String nombre = rs.getString("nombre");
				lstCategorias.add(nombre);
			}
		} catch (Exception e) {//SQLException | ParseException
			e.printStackTrace();
		}
		return lstCategorias;
	}

}
