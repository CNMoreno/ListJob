/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.basicos.beans.provar;

import java.util.UUID;

/**
 *
 * @author darkc
 */
public class clave {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().toUpperCase().substring(0,6));
        System.out.println(UUID.randomUUID().toString().toUpperCase().substring(0,7));
        System.out.println(UUID.randomUUID().toString().toUpperCase().substring(0,8));
    }
    
}
