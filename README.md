### Using Java Cassandra Drivers version 4.x (recommended)

Version 4 is major redesign of the internal architecture. As such, it is not binary compatible with previous versions. However, most of the concepts remain unchanged, and the new API will look very familiar to 2.x and 3.x users. 
- If you want to know more the rational is explained [in this blogpost](https://www.datastax.com/blog/introducing-java-driver-4).
- If you are still using `3.x` and want to migrate you can have a look the [upgrade guide](https://docs.datastax.com/en/developer/java-driver/4.13/upgrade_guide/#4-0-0) but you can also keep using `3.x` as described [below](#using-java-cassandra-drivers-version-3x)

#### 📦. Prerequisites [ASTRA]

- You should have an [Astra account](http://astra.datastax.com/)
- You should [Create and Astra Database](https://github.com/datastaxdevs/awesome-astra/wiki/Create-an-AstraDB-Instance)
- You should [Have an Astra Token](https://github.com/datastaxdevs/awesome-astra/wiki/Create-an-Astra-Token)
- You should [Download your Secure bundle](https://github.com/datastaxdevs/awesome-astra/wiki/Download-the-secure-connect-bundle)

#### 📦. Prerequisites [Development Environment]

- You should install **Java Development Kit (JDK) 8**: Use the [reference documentation](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html) to install a **Java Development Kit**, Validate your installation with

```bash
java --version
```

- You should install **Apache Maven**: Use the [reference documentation](https://maven.apache.org/install.html) and validate your installation with

```bash
mvn -version
```

#### 📦. Setup Project

- Any version `4.x` should be compatible with Astra.

- Update your `pom.xml` file with the latest version of the 4.x libraries: [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.datastax.oss/java-driver-core/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.datastax.oss/java-driver-core)

```xml
<!-- (REQUIRED) -->
<dependency>
 <groupId>com.datastax.oss</groupId>
 <artifactId>java-driver-core</artifactId>
<version>${latest4x}</version>
</dependency>
		
<!-- OPTIONAL -->
<dependency>
 <groupId>com.datastax.oss</groupId>
 <artifactId>java-driver-query-builder</artifactId>
 <version>${latest4x}</version>
</dependency>
<dependency>
 <groupId>com.datastax.oss</groupId>
 <artifactId>java-driver-mapper-runtime</artifactId>
<version>${latest4x}</version>
</dependency>
```

#### 🖥️ . Sample Code (project [astra-driver4x](https://github.com/DataStax-Examples/astra-samples-java/tree/main/astra-driver4x))

```java
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.datastax.oss.driver.api.core.CqlSession;

public class AstraDriver4x {
 
 static final String ASTRA_ZIP_FILE = "<path_to_secureConnectBundle.zip>";
 static final String ASTRA_USERNAME = "<provide_a_clientId>";
 static final String ASTRA_PASSWORD = "<provide_a_clientSecret>";
 static final String ASTRA_KEYSPACE = "<provide_your_keyspace>";
    
 public static void main(String[] args) {
   Logger logger = LoggerFactory.getLogger(AstraDriver4x.class);
   try (CqlSession cqlSession = CqlSession.builder()
     .withCloudSecureConnectBundle(Paths.get(ASTRA_ZIP_FILE))
     .withAuthCredentials(ASTRA_USERNAME, ASTRA_PASSWORD)
     .withKeyspace(ASTRA_KEYSPACE)
     .build()) {
     logger.info("[OK] Welcome to ASTRA. Connected to Keyspace {}", cqlSession.getKeyspace().get());
   }
   logger.info("[OK] Success");
   System.exit(0);
 }

}
```

[![dl](https://dabuttonfactory.com/button.png?t=Download+Project&f=Open+Sans-Bold&ts=14&tc=fff&hp=15&vp=15&w=180&h=50&c=11&bgt=pyramid&bgc=666&ebgc=000&bs=1&bc=444)](https://github.com/DataStax-Examples/astra-samples-java/archive/refs/heads/main.zip)

#### 🔗. Extra Resources for Cassandra Drivers 4.x 

- [Multiple Standalone Classes using driver 4.x](https://github.com/DataStax-Examples/java-cassandra-driver-from3x-to4x/tree/master/example-4x/src/main/java/com/datastax/samples)
- [Spring PetClinic in Reactive](https://github.com/spring-petclinic/spring-petclinic-reactive) and specially the [mapper](https://github.com/spring-petclinic/spring-petclinic-reactive/tree/master/src/main/java/org/springframework/samples/petclinic/vet/db)
