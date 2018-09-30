/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.basicos.modelo.dao;

import servicio.basicos.modelo.vo.IrreglasVO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public interface IrreglasDAO <VO extends IrreglasVO>{
    public void insertar(VO vo)throws SQLException;
    public void modificar(VO vo)throws SQLException;
    public List<VO> consultar()throws SQLException;
    public void eliminar(VO vo)throws SQLException;
}
