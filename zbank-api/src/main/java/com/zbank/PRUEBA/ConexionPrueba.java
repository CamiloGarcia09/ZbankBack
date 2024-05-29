package com.zbank.PRUEBA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionPrueba {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/Zbanky?user=postgres&password=653200";

        try (Connection conn = DriverManager.getConnection(url)) {
            // Mostrar contenido de TipoDocumento
            System.out.println("Contenido de TipoDocumento:");
            mostrarContenido(conn, "TipoDocumento");

            // Mostrar contenido de Divisa
            System.out.println("\nContenido de Divisa:");
            mostrarContenido(conn, "Divisa");

            // Mostrar contenido de Perfil
            System.out.println("\nContenido de Perfil:");
            mostrarContenido(conn, "Perfil");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarContenido(Connection conn, String tabla) throws SQLException {
        String sql = "SELECT * FROM " + tabla;

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            // Obtener metadatos de las columnas
            int columnCount = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getMetaData().getColumnName(i) + "\t");
            }
            System.out.println();

            // Mostrar contenido de las filas
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        }
    }
}

