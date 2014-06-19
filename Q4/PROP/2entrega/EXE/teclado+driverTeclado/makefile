all: teclado driverTeclado exe

teclado: teclado
	javac teclado.java

driverTeclado: driverTeclado
	javac driverTeclado.java

exe: driverTeclado
	java driverTeclado < driverTeclado.in > driverTeclado.out

clean:
	rm -f *.class
