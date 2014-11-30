-- Opens the class diagram:
-- open examples/Documentation/Demo/Demo.use
-- Creates the object diagram:
-- read examples/Documentation/Demo/DemoGabriel.cmd

-- Department
!create cb:Department
!set cb.name := 'Costa Breve'
!set cb.location := 'Aribau'
!set cb.budget := 78980974

-- Department
!create uni:Department
!set uni.name := 'Universitat Politecnica de Catalunya'
!set uni.location := 'Avinguda de l exercit'
!set uni.budget := 47908987
-- Employee Gabriel
!create Gabriel : Employee
!set Gabriel.name := 'Gabriel'
!set Gabriel.salary := 100
-- Employee Carrillo
!create Carrillo : Employee
!set Carrillo.name := 'Carrillo'
!set Carrillo.salary := 70
-- Employee Lopez
!create Lopez : Employee
!set Lopez.name := 'Lopez'
!set Lopez.salary := 80
-- Employee Carlos
!create Carlos : Employee
!set Carlos.name := 'Carlos'
!set Carlos.salary := 500

-- WorksIn
!insert (Gabriel,cb) into WorksIn
!insert (Gabriel,uni) into WorksIn
!insert (Carrillo,uni) into WorksIn
!insert (Lopez,uni) into WorksIn
!insert (Carlos,cb) into WorksIn

-- Dirige
!insert (Carlos,cb) into Dirige
!insert (Gabriel,uni) into Dirige

-- Project RRPP
!create rrpp : Project
!set rrpp.name := 'RRPP'
!set rrpp.budget := 100

-- Project teaching
!create teaching : Project
!set teaching.name := 'Fonaments Matematics'
!set teaching.budget := 30

-- Controls
!insert (cb,rrpp) into Controls
!insert (uni,teaching) into Controls

-- WorksOn
!insert (Gabriel,teaching) into WorksOn
!insert (Carrillo,teaching) into WorksOn
!insert (Lopez,teaching) into WorksOn
!insert (Gabriel,rrpp) into WorksOn
!insert (Carlos,rrpp) into WorksOn


--WorksIn
!delete (Gabriel, uni) from WorksIn                                           


!set Gabriel.salary := 10

