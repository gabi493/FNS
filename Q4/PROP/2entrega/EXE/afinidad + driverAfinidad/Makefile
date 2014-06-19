all: driverAfinidad

driverAfinidad.class: *.java
	   javac *.java
	  
driverAfinidad: driverAfinidad.class
	  java driverAfinidad < driverAfinidad.in
	  
clean:
	  rm *.class