/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcialdjg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author gabou
 */

public class ManejadorCliente implements Runnable {

    private final Socket cliente;
    private String nombreCliente;

    public ManejadorCliente(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(cliente.getInputStream())); PrintWriter writer = new PrintWriter(cliente.getOutputStream(), true)) {

            nombreCliente = reader.readLine();
            int numero = Integer.parseInt(reader.readLine());

            System.out.println("Cliente [" + nombreCliente + "] envio el número: " + numero);

            int cuadrado = numero * numero;
            String fechaHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            writer.println("Bienvenido, " + nombreCliente);
            writer.println("El cuadrado de " + numero + " es: " + cuadrado);
            writer.println("Fecha y hora del servidor: " + fechaHora);

            System.out.println("Respuesta enviada a [" + nombreCliente + "]");

        } catch (IOException e) {
            System.err.println("Error con cliente [" + nombreCliente + "]: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Numero invalido recibido");
        } finally {
            try {
                cliente.close();
                System.out.println("Cliente [" + nombreCliente + "] desconectado");
            } catch (IOException e) {
                System.err.println("Error al cerrar conexion con cliente");
            }
        }
    }
}
