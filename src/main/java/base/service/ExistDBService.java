package base.service;

import java.io.File;
import org.xmldb.api.base.Database;
import org.springframework.stereotype.Service;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.modules.XMLResource;


@Service
public class ExistDBService {

		private String url ="xmldb:exist://localhost:8080/exist/xmlrpc/db/";
		
		public void guardarInforme(File archivoXml) {
			
			try {
				Class clase = Class.forName("org.exist.xmldb.DatabaseImpl");
				Database database =(Database) clase.getDeclaredConstructor().newInstance();
				DatabaseManager.registerDatabase(database);
				
				String urlRaiz = "xmldb:exist://localhost:8080/exist/xmlrpc/db/"; //
				Collection colecion = DatabaseManager.getCollection(url,"admin","admin");
				
				if(colecion == null) {
					System.out.println("Error no se encuentra la coleccion db informes");
					return;
				}	
				XMLResource recurso =(XMLResource) colecion.createResource(archivoXml.getName(),"XMLResource");
				recurso.setContent(archivoXml);
				colecion.storeResource(recurso);
				
				System.out.println("Exito el archivo ya esta en eXist-db" + archivoXml.getName());
				
				colecion.close();
				
				
				
				}catch(Exception e) {
					System.err.println("Ocurrio un error al guardar en eXist-db:"+ e.getMessage());
					e.printStackTrace();
				}
			
		}
}

