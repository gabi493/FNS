all: texto driverTexto exe

texto: texto
	javac texto.java

driverTexto: driverTexto
	javac driverTexto.java

exe: texto
	java driverTexto < driverTexto.in > driverTexto.out

clean:
	rm -f *.class
