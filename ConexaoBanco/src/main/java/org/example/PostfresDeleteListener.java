package org.example;

import org.postgresql.PGConnection;
import org.postgresql.PGNotification;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PostfresDeleteListener {

    public void listen()  {
        try(Connection conn =  DataBaseConnection.getConnection();
            Statement stmt =  conn.createStatement()){


            PGConnection pgConn = conn.unwrap(PGConnection.class);
            stmt.execute("LISTEN teste_registro");
            System.out.println("LISTEN teste_registro");

            while(true){
                PGNotification [] notifications  = (PGNotification[]) pgConn.getNotifications();
                if(notifications != null){
                    for(PGNotification notification : notifications){
                        System.out.println("pedito não encontrado");
                    }
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    }


