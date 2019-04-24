<?php 

include "connexion.php";
// ne pas copier if(!empty($basededonnees)) echo "je suis connectee";

$SQL_LISTE_ARTISTES = "SELECT * FROM artiste"; // TODO optimiser
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
		<nom><?php echo $artiste->nom?></nom>
		<surnom><?php echo $artiste->surnom?></surnom>
		<age><?php echo $artiste->age?></age>
		<ville><?php echo $artiste->ville?></ville>
	</artiste>	

<?php
}
?>

</artistes>

