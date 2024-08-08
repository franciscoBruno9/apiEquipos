package com.api.equipos.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class CargaDatos implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        try (Connection conexion = dataSource.getConnection()) {
            Statement sql = conexion.createStatement();

            sql.execute("INSERT INTO equipo (nombre, liga, pais) VALUES" +
                    "('Real Madrid', 'La Liga', 'España'), " +
                    "('FC Barcelona', 'La Liga', 'España'), " +
                    "('Manchester United', 'Premier League', 'Inglaterra'), " +
                    "('Liverpool FC', 'Premier League', 'Inglaterra'), " +
                    "('Juventus FC', 'Serie A', 'Italia'), " +
                    "('AC Milan', 'Serie A', 'Italia'), " +
		            "('Bayern Munich', 'Bundesliga', 'Alemania'), " +
		            "('Borussia Dortmund', 'Bundesliga', 'Alemania'), " +
		            "('Paris Saint-Germain', 'Ligue 1', 'Francia'), " +
		            "('Olympique de Marseille', 'Ligue 1', 'Francia'), " +
		            "('FC Porto', 'Primeira Liga', 'Portugal'), " +
		            "('Sporting CP', 'Primeira Liga', 'Portugal'), " +
		            "('Ajax Amsterdam', 'Eredivisie', 'Países Bajos'), " +
		            "('Feyenoord', 'Eredivisie', 'Países Bajos'), " +
		            "('Celtic FC', 'Scottish Premiership', 'Escocia'), " +
		            "('Rangers FC', 'Scottish Premiership', 'Escocia'), " +
		            "('Galatasaray SK', 'Süper Lig', 'Turquía'), " +
		            "('Fenerbahçe SK', 'Süper Lig', 'Turquía'), " +
		            "('FC Zenit Saint Petersburg', 'Premier League Rusa', 'Rusia'), " +
		            "('Spartak Moscow', 'Premier League Rusa', 'Rusia'), " +
		            "('SL Benfica', 'Primeira Liga', 'Portugal'), " +
		            "('Besiktas JK', 'Süper Lig', 'Turquía'), " +
		            "('SSC Napoli', 'Serie A', 'Italia'), " +
		            "('Atlético Madrid', 'La Liga', 'España')");

            sql.close();
        } catch (SQLException e) {
            System.out.println("Error al inicializar la base de datos: " + e.getMessage());
        }
    }
}
