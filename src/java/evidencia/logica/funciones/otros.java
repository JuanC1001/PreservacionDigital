/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evidencia.logica.funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import evidencia.logica.clases.Caso;
import evidencia.logica.clases.CasoPersonaUsuario;
import evidencia.logica.clases.Persona;
import evidencia.logica.clases.Documento;
import evidencia.logica.clases.IncrementoEvidencias_Juridicos;
import java.sql.SQLException;
import master.logica.clases.UsuarioRol;
import recursos.Tools;
import java.util.ArrayList;
import java.util.Date;
import master.logica.funciones.FUsuarioRol;
import static org.apache.poi.hssf.usermodel.HeaderFooter.date;

/**
 *
 * @author RUBEN
 */
public class otros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//// try {
//            Autor objet = new Autor();
//            UsuarioRol dos = new UsuarioRol();
//            dos.setCodigo(8);
//            objet.setApellido("Guaman");
//            objet.setNombres("Siguenza");
//            objet.setCedula("0602536520");
//            objet.setCodigo_usuario_rol(dos);
//            objet.setMail("bhggjhhjb");
//            objet.setFecha_registro(Tools.FechaDateDadoString("01/01/2014"));
//            boolean b = FAutor.insertar(objet);
//            System.out.println(b);
//            System.out.println("Ingreso exitoso");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.out.println("Error al ingreso ");
//            
//        } 
//
//    }
//         try {
//            ArrayList<ArchivosOriginales> lista = new ArrayList<ArchivosOriginales>();
//            lista = FArchivosOriginales.obtenerTodosArchivos();
//            for (ArchivosOriginales archivosoriginales : lista) {
//                System.out.println(archivosoriginales.getTitulo());
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//}
//             try {
//            ArrayList<IncrementoArchivos> lista = new ArrayList<IncrementoArchivos>();
//            lista = FIncrementoArchivos.obtenerTodosIncrementoArchivos();
//            for (IncrementoArchivos incrementoarchivos : lista) {
//                System.out.println(incrementoarchivos.getTitulo());
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//             
//        try {
//            ArchivosOriginales ar = new ArchivosOriginales();
//            ar = FArchivosOriginales.obtenerArchivosOriginalesDadoCodigo(1);
//            System.out.printf("OK");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }  
//        try {
//            IncrementoArchivos objet = new IncrementoArchivos();
//            UsuarioRol dos = new UsuarioRol();
//            dos.setCodigo(8);
//            objet.setCodigo_archivos_originales("1");
//            objet.setNombres("Siguenza");
//            objet.setCedula("0602536520");
//            objet.setCodigo_usuario_rol(dos);
//            objet.setMail("bhggjhhjb");
//            objet.setFecha_registro(Tools.FechaDateDadoString("01/01/2014"));
//            boolean b = FAutor.insertar(objet);
//            System.out.println(b);
//            System.out.println("Ingreso exitoso");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.out.println("Error al ingreso ");
//            
//        } 
//        try {
//            ArrayList<Documento> lista = new ArrayList<Documento>();
//            lista = FDocumento.obtenerDocumetos();
//            for (Documento  documento : lista) {
//                System.out.println(documento.getTitulo());
//                System.out.println(documento.getResumen());
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//                try {
//            UsuarioRol us  = new UsuarioRol();
//            us = FUsuarioRol.ObtenerUsuarioRolDadoCodigo(35);
//            
//                System.out.println(us.getFecha_creacion());                           
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//      try {
//            Documento us  = new Documento();
//            us = FDocumento.ObtenerDocumentoDadoCodigo(26);          
//                System.out.println(us.getTipo());  
//                System.out.println(us.getResumen());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }           
//    }
        /*
         try {
         Incremento objet = new Incremento();
         UsuarioRol dos = new UsuarioRol();
         dos.setCodigo(8);
         Documento cd = new Documento();
         cd.setCodigo(28);
         objet.setCodigo_documento(cd);
         objet.setTitulo("Prueva");
         objet.setParte("Siguenza");
         objet.setPath("0602536520");
         objet.setCodigo_usuario_rol(dos);
         objet.setFecha_registro(Tools.FechaDateDadoString("01/01/2015"));
         boolean b = FIncremento.insertar(objet);
         System.out.println(b);
         System.out.println("Ingreso exitoso");
         } catch (Exception e) {
         System.out.println(e.getMessage());
         System.out.println("Error al ingreso ");
            
         } 
         */
        /*/
         try {

         ArrayList<Caso> lista = new ArrayList<Caso>();
         lista = FCaso.obtenerCasos();
         for (Caso caso : lista) {
         System.out.println(caso.getCodigo());
         //System.out.println(caso.getCodigo_institucional());    
         }
         } catch (Exception e) {
         System.out.println(e.getMessage());
         }*/
        //Listar casousuariopersona dado codigo institucional
        /*try {
         Caso lista = new Caso();
         lista = FCaso.ObtenerCasoUltimo();           
         System.out.println(lista.getCodigo());
         System.out.println(lista.getCodigo_institucional());                
         } catch (Exception e) {
         System.out.println(e.getMessage());
         }
         //Listar casousuariopersona 
         try {
         ArrayList<CasoPersonaUsuario> lista = new ArrayList<CasoPersonaUsuario>();
         lista = FCasoPersonaUsuario.obteneTodosCasoPersonaUsuario();           
         for (CasoPersonaUsuario caso : lista) {
         System.out.println(caso.getCodigo());
         System.out.println(caso.getCodigo_persona().getApellidos());    
         }                
         } catch (Exception e) {
         System.out.println(e.getMessage());
         }
        //Listar casousuariopersona_Fechas
        try {
            Date FechaIn ;
            Date FechaFin;

            ArrayList<CasoPersonaUsuario> lista = new ArrayList<CasoPersonaUsuario>();
            lista = FCasoPersonaUsuario.ObtenerCPUdadoCodFechas( fechaInicio);
            for (CasoPersonaUsuario caso : lista) {
                System.out.println(caso.getCodigo());
                System.out.println(caso.getCodigo_persona().getApellidos());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }*/

    }
}
