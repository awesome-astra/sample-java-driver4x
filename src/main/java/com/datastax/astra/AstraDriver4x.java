package com.datastax.astra;
import java.nio.file.Paths;
import com.datastax.oss.driver.api.core.CqlSession;

public class AstraDriver4x {
  public static void main(String[] args) {
    try (CqlSession cqlSession = CqlSession.builder()
      .withCloudSecureConnectBundle(Paths.get("/tmp/secure-connect-bundle-db-demo."))
      .withAuthCredentials("client_id","client_secret")
      .withKeyspace("keyspace_demo")
      .build()) {
       System.out.println("Connected to " + cqlSession.getKeyspace().get());
    }
  }
}
