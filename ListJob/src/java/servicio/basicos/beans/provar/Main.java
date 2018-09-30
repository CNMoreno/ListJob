/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio.basicos.beans.provar;

/**
 *
 * @author darkc
 */
public class Main {
   
 public static void main(String[] args) throws Exception {
 String key = "92AE31A79FEEB2A3"; //llave
 String iv = "0123456789ABCDEF"; // vector de inicialización
 String cleartext = "mono";
 System.out.println("Texto encriptado: "+servicio.basicos.beans.provar.StringEncrypt.encrypt(key, iv,cleartext));
 System.out.println("Texto desencriptado: "+servicio.basicos.beans.provar.StringEncrypt.decrypt(key, iv,servicio.basicos.beans.provar.StringEncrypt.encrypt(key, iv,cleartext)));
 }
 
}

