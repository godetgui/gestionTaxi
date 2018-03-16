----insertions Client-----
insert into client values ("tintin","milou","1 rue Hergé","0123456789");
insert into client values ("VERGOTE","Anne-Claire","Le Touquet","0123456789");
insert into client values ("GODET","Guillaume","1 avenue du Football","0123456789");
insert into client values("VALERA","Julien","2 place de la Gare","0123456789");
insert into client values ("AUPETIT","Alexiane","5 rue de Dijon","0123456789");

----insertions Taxi-------
---catégories possibles : touktouk, citadine, minibus, limousine
insert into taxi values ("Touktouk",4,5,"Angers");
insert into taxi values ("Touktouk",5,"Paris");
insert into taxi values ("Citadine",10,"Angers");
insert into taxi values ("Citadine",11,5,"Toulouse");
insert into taxi values ("Minibus",14,5, "Angers");
insert into taxi values ("Minibus",15,"Le Mans");
insert into taxi values ("Limousine",20, "Angers");
insert into taxi values ("Limousine",18,"Marseille");

----insertions Réservation----
insert into reservation values ("16/03/2018 14:20:00","Eseo Angers",0,2,1);