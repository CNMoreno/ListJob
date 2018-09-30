/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.basicos.controlador;

import java.sql.SQLException;
import java.util.List;
import servicio.basicos.modelo.dao.IrreglasDAO;
import servicio.basicos.modelo.vo.IrreglasVO;
/**
 *
 * @author Aprendiz
 */
public class ControladorGenerico <DAO extends IrreglasDAO, VO extends IrreglasVO>{
    DAO dao;
     public void insertar(VO vo){
         try {
             dao.insertar(vo);
         } catch (Exception ex) {
             System.out.println("Error al insertar el Regristro de " + vo.getClass().getName()+ " motivo : " + ex.getMessage());
         }
     }
     public void modificar(VO vo){
        try {
            dao.modificar(vo);
        } catch (SQLException ex) {
            System.out.println("Error al modificar el Regristro de " + vo.getClass().getName()+ " motivo : " + ex.getMessage());
        }
    }
     
   public List<VO> consultar() {
        try {
            return dao.consultar();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
   }
     
     public void eliminar(VO vo) {
        try {
            dao.eliminar(vo);
        } catch (SQLException ex) {
            System.out.println("Error al modificar el Regristro de " + vo.getClass().getName() + " motivo : " + ex.getMessage());
        }
    }
}
