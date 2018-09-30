/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.basicos.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import servicio.basicos.modelo.vo.EntradasVO;

/**
 *
 * @author Administrador
 */
public class EntradasDAO implements IrreglasDAO<EntradasVO>{
    
    Connection cnn;
    
    public EntradasDAO(Connection cnn) {
        this.cnn = cnn;
    }

    @Override
    public void insertar(EntradasVO vo) throws SQLException {
        PreparedStatement sentencia
                = this.cnn.prepareStatement("INSERT into tareas(nombre,Descripcion,Estado) VALUES (?,?,?)");
       
        sentencia.setString(1,vo.getNombre());
        sentencia.setString(2,vo.getDescripcion());
        sentencia.setInt(3,vo.isEstado() ? 1 : 2);
        sentencia.executeUpdate();
    }

    @Override
    public void modificar(EntradasVO vo) throws SQLException {
        PreparedStatement sentencia
                = this.cnn.prepareStatement("UPDATE tareas set nombre=?,Descripcion=?,Estado=? where id=?");
     
        
        sentencia.setString(1, vo.getNombre());
        sentencia.setString(2, vo.getDescripcion());
        sentencia.setInt(3, vo.isEstado()? 1 : 2);
        sentencia.setInt(4, vo.getId());
        sentencia.executeUpdate();
    }

    @Override
    public List<EntradasVO> consultar() throws SQLException {
        PreparedStatement sentencia = this.cnn.prepareStatement("SELECT id,nombre,Descripcion,Estado FROM tareas");
        ArrayList<EntradasVO> listaUsuarios = new ArrayList<>();
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {
            EntradasVO voTemporal = new EntradasVO();
            voTemporal.setId(resultado.getInt("id"));
            voTemporal.setNombre(resultado.getString("nombre"));
            voTemporal.setDescripcion(resultado.getString("Descripcion"));
            voTemporal.setEstado(resultado.getInt("Estado")==1);
              listaUsuarios.add(voTemporal);
        }
        if (!listaUsuarios.isEmpty()) {
            return listaUsuarios;
        } else {
            return null;
        }
    }

    @Override
    public void eliminar(EntradasVO vo) throws SQLException {
        PreparedStatement sentencia
                = this.cnn.prepareStatement("DELETE FROM tareas "
                        + " WHERE id= ?");

        sentencia.setInt(1, vo.getId());
        sentencia.executeUpdate();
    }
    
}
