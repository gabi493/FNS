all: tecla driverTecla exe

tecla: tecla
	javac tecla.java

driverTecla: driverTecla
	javac driverTecla.java

exe: driverTecla
	java driverTecla < driverTecla.in > driverTecla.out

clean:
	rm -f *.class
