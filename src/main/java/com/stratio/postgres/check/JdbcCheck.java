/* © 2020 Stratio Big Data Inc., Sucursal en España. All rights reserved.
 *
 * This software – including all its source code – contains proprietary information of Stratio Big Data Inc., Sucursal
 * en España and may not be revealed, sold, transferred, modified, distributed or otherwise made available, licensed or
 * sublicensed to third parties; nor reverse engineered, disassembled or decompiled, without express written
 * authorization from Stratio Big Data Inc., Sucursal en España. */

package com.stratio.postgres.check;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcCheck {

  public static void main(String[] args) {

    if (args.length < 1 || args.length == 2 || args.length > 3) {
      System.out.println("Usage: java JdbcCheck url [user] [password]");
      System.exit(0);
    }

    System.out.println("URL: " + args[0]);
    if (args.length > 1) {
      System.out.println("User: " + args[1]);
      System.out.println("Pass: " + args[2]);
    }

    // auto close connection
    try (Connection conn = DriverManager.getConnection(args[0], args.length > 1 ? args[1] : null,
        args.length > 2 ? args[2] : null)) {
      if (conn != null) {
        System.out.println("Connected to the database!");
      } else {
        System.out.println("Failed to make connection!");
      }
      System.exit(0);
    } catch (SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
      System.err.println();
      e.printStackTrace();
      System.exit(1);
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

}
