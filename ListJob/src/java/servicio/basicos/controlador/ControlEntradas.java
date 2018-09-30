/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.basicos.controlador;

import java.sql.Connection;
import servicio.basicos.modelo.dao.EntradasDAO;
import servicio.basicos.modelo.vo.EntradasVO;

/**
 *
 * @author Administrador
 */
public class ControlEntradas extends ControladorGenerico<EntradasDAO, EntradasVO>{
    
    public ControlEntradas(Connection cnn) {
        dao = new EntradasDAO(cnn);
    }
}
