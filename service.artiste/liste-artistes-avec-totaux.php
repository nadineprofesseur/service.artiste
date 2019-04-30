<?php 

include "connexion.php";
// ne pas copier if(!empty($basededonnees)) echo "je suis connectee";

$SQL_LISTE_ARTISTES = "SELECT artiste.id, artiste.nom, SUM(demonstration.id) as total_voyages FROM artiste LEFT JOIN demonstration ON demonstration.id_artiste = artiste.id GROUP BY demonstration.id_artiste"; // TODO optimiser
//echo $SQL_LISTE_ARTISTES;

$requeteListeArtistes = $basededonnees->prepare($SQL_LISTE_ARTISTES);
$requeteListeArtistes->execute();
$listeArtistes = $requeteListeArtistes->fetchAll(PDO::FETCH_OBJ);
//print_r($listeArtistes);
?>


<artistes>

<?php
foreach($listeArtistes as $artiste){
//print_r($artiste);
?>
	<artiste>
		<id><?php echo $artiste->id?></id>
		<nom><?php echo $artiste->nom?></nom>
		<voyages><?php echo $artiste->total_voyages?></voyages>
	</artiste>	

<?php
}
?>

</artistes>

