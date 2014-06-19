all: distancia distanciaCluster driverDistancia driverDistanciaCluster exe

distancia: distancia
	javac distancia.java

distanciaCluster: distanciaCluster
	javac distanciaCluster.java

driverDistancia: driverDistancia
	javac driverDistancia.java

driverDistanciaCluster: driverDistanciaCluster
	javac driverDistanciaCluster.java

exe: driverDistancia
	java driverDistancia < driverDistancia.in > driverDistancia.out

clean:
	rm -f *.class
