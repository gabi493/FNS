all: teclado controladorTeclado driverControladorTeclado exe

teclado: teclado
	javac teclado.java

controladorTeclado: controladorTeclado
	javac controladorTeclado.java

driverControladorTeclado: driverControladorTeclado
	javac driverControladorTeclado.java

exe: driverControladorTeclado
	java driverControladorTeclado < driverControladorTeclado.in > driverControladorTeclado.out

clean:
	rm -f *.class
