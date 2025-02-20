USE  formation;

DELIMITER $
CREATE PROCEDURE GET_COUNT_BY_PRIX(IN prixmax DOUBLE,OUT nb_produit INT)
BEGIN
	SELECT count(id) INTO nb_produit FROM produits WHERE prix<prixmax;
END $
DELIMITER ;

CALL GET_COUNT_BY_PRIX(100.0,@resultat);
SELECT @resultat;

