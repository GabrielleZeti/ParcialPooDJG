/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.parcialfinal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author gabou
 */
public class ServidorCuadrado {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Esperando conexion...");
            Socket socketCliente = serverSocket.accept();
            System.out.println("Cliente conectado: " + socketCliente.getInetAddress());
            InputStream inputStream = socketCliente.getInputStream();
            OutputStream outputStream = socketCliente.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);
            String msg = reader.readLine();
            System.out.println("MEnsaje del cliente " + msg);
            writer.println("Este mensaje se ha enviado desde el servidor ");
            socketCliente.close();
            serverSocket.close();
            
        }catch (IOException e) {
            
        }

    }
}
