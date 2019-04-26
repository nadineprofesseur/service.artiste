<?php 
$id = filter_var($_GET['artiste'], FILTER_SANITIZE_NUMBER_INT);

include "connexion.php";
// ne pas copier if(!empty($basededonnees)) echo "je suis connectee";

$SQL_ARTISTE = "SELECT * FROM artiste WHERE id = :id"; // TODO optimiser
//echo $SQL_LISTE_ARTISTES;

$requeteArtiste = $basededonnees->prepare($SQL_ARTISTE);
$requeteArtiste->bindParam(":id", $id, PDO::PARAM_INT); // (T_PAAMAYIM_NEKUDOTAYIM) PDO::PDO::PARAM_INT
$requeteArtiste->execute();
$artiste = $requeteArtiste->fetch(PDO::FETCH_OBJ);
if(empty($artiste)) exit(0);
//print_r($listeArtistes);
?>

<artiste>
	<id><?php echo $artiste->id?></id>
	<nom><?php echo $artiste->nom?></nom>
	<surnom><?php echo $artiste->surnom?></surnom>
	<age><?php echo $artiste->age?></age>
	<ville><?php echo $artiste->ville?></ville>
</artiste>	
