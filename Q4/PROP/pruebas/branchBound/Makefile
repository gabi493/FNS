all: driverBranchBound

driverBranchBound.class: *.java
	   javac *.java
	  
driverBranchBound: driverBranchBound.class
	  java driverBranchBound < driverBranchBound.in
	  
clean:
	  rm *.class