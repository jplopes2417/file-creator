plugins {
	java
	id("org.springframework.boot") version "3.0.0"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "br.com.jpfilecreator"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-batch")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.0.0")
	implementation("com.mysql:mysql-connector-j:8.0.31")

	compileOnly("org.projectlombok:lombok")
	runtimeOnly("com.h2database:h2")

	annotationProcessor("org.projectlombok:lombok")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.batch:spring-batch-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
