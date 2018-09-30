/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.basicos.beans;

import static com.sun.javafx.logging.PulseLogger.addMessage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.naming.NamingException;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import servicio.basicos.controlador.ControlEntradas;
import servicio.basicos.modelo.conexion.Conexion;
import servicio.basicos.modelo.vo.EntradasVO;
import servicio.basicos.modelo.dao.EntradasDAO;

/**
 *
 * @author Administrador
 */
@ManagedBean
@RequestScoped
public class Entradas {
    
    private List<EntradasVO> listaEntradas;
    private EntradasVO nuevoEntradas;
    private String textoBoton;
  private List<EntradasVO> filtroMedicamento;

    public List<EntradasVO> getFiltroMedicamento() {
        return filtroMedicamento;
    }

    public void setFiltroMedicamento(List<EntradasVO> filtroMedicamento) {
        this.filtroMedicamento = filtroMedicamento;
    }
    
    public Entradas (){
    
    try {
            nuevoEntradas = new EntradasVO();
            textoBoton = "Agregar";
            ControlEntradas control = new ControlEntradas(Conexion.getConexionBD());
            listaEntradas = control.consultar();
            Conexion.desconectarBD();
        } catch (ClassNotFoundException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se encontro el Driver de la Base de datos"));
            Logger.getLogger(Entradas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocurrio un error de tipo SQL"));
            Logger.getLogger(Entradas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<EntradasVO> getListaEntradas() {
        return listaEntradas;
    }

    public void setListaEntradas(List<EntradasVO> listaEntradas) {
        this.listaEntradas= listaEntradas;
    }

    public void eliminarEntradas(EntradasVO vo) {
        try {

            ControlEntradas control = new ControlEntradas(Conexion.getConexionBD());
            control.eliminar(vo);
            listaEntradas.remove(vo);
            Conexion.desconectarBD();
        } catch (Exception e) {
            try {
                e.printStackTrace();
                Conexion.regresarBD();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void agregarEntradas() {
         Connection cnn = null;
        try {
            cnn = Conexion.getConexionBD();
            ControlEntradas control = new ControlEntradas(cnn);
            if (nuevoEntradas.getId()!= 0) {
                control.modificar(nuevoEntradas);
                listaEntradas.add(nuevoEntradas);
            } else {
                control.insertar(nuevoEntradas);
                listaEntradas.add(nuevoEntradas);
            }
            nuevoEntradas = new EntradasVO();
            Conexion.desconectarBD();
        } catch (ClassNotFoundException | SQLException e) {
            try {
                Conexion.regresarBD();
            } catch (SQLException ex) {
            }
        }
        
    }

    public void modificarEntradas(EntradasVO vo) {
        nuevoEntradas= vo;
        textoBoton = "Modificar";
        //listaMedicamento.remove(vo);
       
    }

    public EntradasVO getNuevoIEntradas() {
        return nuevoEntradas;
    }

    public void setNuevoEntradas(EntradasVO nuevoEntradas) {
        this.nuevoEntradas = nuevoEntradas;
    }

    public String getTextoBoton() {
        return textoBoton;
    }

    public void setTextoBoton(String textoBoton) {
        this.textoBoton = textoBoton;
    }
    public void onRowEdit(RowEditEvent event) {
        Connection cnn = null;
        try {
            cnn = Conexion.getConexionBD();
            ControlEntradas control = new ControlEntradas(cnn);
            if (nuevoEntradas.getId()!= 0) {
                control.modificar(nuevoEntradas);
                listaEntradas.add(nuevoEntradas);
                FacesMessage msg = new FacesMessage("Car Edited", ((EntradasVO) event.getObject()).getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
                System.out.println("error fatal");
            }
            nuevoEntradas = new EntradasVO();
            Conexion.desconectarBD();
        } catch (Exception e) {
            try {
                e.printStackTrace();
                Conexion.regresarBD();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    public TimeZone getTimeZone() {
    return TimeZone.getDefault();
}
    public void buttonAction(EntradasVO vo) {
        nuevoEntradas = vo;
        textoBoton = "Nuevo";
        //listaMedicamento.remove(vo);

        addMessage("Welcome to Primefaces!!");
    }
    
    
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
    
    public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
         
        if(value == null) {
            return false;
        }
         
        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }

public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

public void validarsecop(FacesContext contexto, UIComponent componente, Object valor) throws ValidatorException{
        String correo = (String) valor;
       try {
            String l = "select Codigo_secop from producto where Codigo_secop ='" + correo + "'";

            Connection conexion = Conexion.getConexionBD();
                Statement st = conexion.createStatement();
                ResultSet rst = st.executeQuery(l);
               
                while (rst.next()) {
                    String dc = rst.getString("Codigo_secop");
                    if(correo.contentEquals(dc)){
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error ya esta existe el codigo secop!", "Contact admin."));
        }
                }
Conexion.desconectarBD(); 
        } catch (Exception e) {
        }
        }

public void validaralma(FacesContext contexto, UIComponent componente, Object valor) throws ValidatorException{
        String correo = (String) valor;
       try {
            String l = "select Codigo_almacen from producto where Codigo_almacen ='" + correo + "'";

            Connection conexion = Conexion.getConexionBD();
                Statement st = conexion.createStatement();
                ResultSet rst = st.executeQuery(l);
               
                while (rst.next()) {
                    String dc = rst.getString("Codigo_almacen");
                    if(correo.contentEquals(dc)){
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error ya esta existe el codigo de almacen!", "Contact admin."));
        }
                }
Conexion.desconectarBD(); 
        } catch (Exception e) {
        }
        }

public void validarnom(FacesContext contexto, UIComponent componente, Object valor) throws ValidatorException{
        String correo = (String) valor;
       try {
            String l = "date(y-m-dd)";

            Connection conexion = Conexion.getConexionBD();
                Statement st = conexion.createStatement();
                ResultSet rst = st.executeQuery(l);
               
                while (rst.next()) {
                    String dc = rst.getString("Nombre");
                    if(correo.contentEquals(dc)){
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error ya esta existe el Nombre del medicamento!", "Contact admin."));
        }
                }
Conexion.desconectarBD(); 
        } catch (Exception e) {
        }
        }

public void validarfe(FacesContext contexto, UIComponent componente, Object valor) throws ValidatorException{
         String correo = (String) valor;
         System.out.println(correo);
      
        }

private Date currentDate = new Date();

public Date getCurrentDate() {
    return currentDate;
}
}
