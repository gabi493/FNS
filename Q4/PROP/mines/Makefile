all: driverBranchBound

driverBranchBound.class: *.java
	   javac *.java
	  
driverBranchBound: driverBranchBound.class
	  java driverBranchBound < driverBranchBound.in > driverBranchBound.out
	  
clean:
	  rm *.class
