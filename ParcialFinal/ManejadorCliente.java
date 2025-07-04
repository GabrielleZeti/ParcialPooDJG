/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcialfinal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
/**
 *
 * @author LENOVO
 */
public class ManejadorCliente implements Runnable {
private Socket cliente;
    
    public ManejadorCliente(Socket cliente){
        this.cliente = cliente; 
    }

    @Override
    public void run() {
        try{
            InputStream input = cliente.getInputStream();
            OutputStream output = cliente.getOutputStream();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            PrintWriter writer = new PrintWriter(output,true);
            String msg = reader.readLine();
            System.out.println("Mensaje del Cliente" + msg);
            writer.println("Todos pasaron, amen");
            cliente.close();
             
        }
        catch(IOException e ){
            
        }
    }
       
}
