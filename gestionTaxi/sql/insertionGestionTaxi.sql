-- insertions Client
insert into client(nom,prenom,adresse,telephone) values ("tintin","milou","1 rue Hergé","0123456789");
insert into client(nom,prenom,adresse,telephone) values ("VERGOTE","Anne-Claire","Le Touquet","0123456789");
insert into client(nom,prenom,adresse,telephone) values ("GODET","Guillaume","1 avenue du Football","0123456789");
insert into client(nom,prenom,adresse,telephone) values("VALERA","Julien","2 place de la Gare","0123456789");
insert into client(nom,prenom,adresse,telephone) values ("AUPETIT","Alexiane","5 rue de Dijon","0123456789");

-- insertions Taxi
-- catégories possibles : touktouk, citadine, minibus, limousine
insert into taxi(categorie,tarifDeBase,ville) values ("Touktouk",4.5,"Angers");
insert into taxi(categorie,tarifDeBase,ville) values ("Touktouk",5,"Paris");
insert into taxi(categorie,tarifDeBase,ville) values ("Citadine",10,"Angers");
insert into taxi(categorie,tarifDeBase,ville) values ("Citadine",11.5,"Toulouse");
insert into taxi(categorie,tarifDeBase,ville) values ("Minibus",14.5, "Angers");
insert into taxi(categorie,tarifDeBase,ville) values ("Minibus",15,"Le Mans");
insert into taxi(categorie,tarifDeBase,ville) values ("Limousine",20, "Angers");
insert into taxi(categorie,tarifDeBase,ville) values ("Limousine",18,"Marseille");

-- insertions Réservation
insert into reservation(dateReservation,destination,booleenPaiementEffectue,idClient,idTaxi) values ("2018-03-16 14:20:00","Eseo Angers",0,2,1);