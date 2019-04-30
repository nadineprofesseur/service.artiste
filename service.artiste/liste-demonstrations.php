<?php 

$listeDemonstrations = array();

if(!empty($_GET['artiste']))
{
	$artiste = filter_var($_GET['artiste'], FILTER_SANITIZE_NUMBER_INT);
	$SQL_LISTE_DEMONSTRATIONS = "SELECT * FROM demonstration WHERE id_artiste = :id_artiste"; // TODO optimiser
	include "connexion.php";
	$requeteListeDemonstrations = $basededonnees->prepare($SQL_LISTE_DEMONSTRATIONS);
	$requeteListeDemonstrations->bindParam(":id_artiste", $artiste, PDO::PARAM_INT);
	$requeteListeDemonstrations->execute();
	$listeDemonstrations = $requeteListeDemonstrations->fetchAll(PDO::FETCH_OBJ);
	//print_r($listeDemonstrations);
}
else
{
	$SQL_LISTE_DEMONSTRATIONS = "SELECT * FROM demonstration"; // TODO optimiser
	//echo $SQL_LISTE_DEMONSTRATIONS;	
	include "connexion.php";
	$requeteListeDemonstrations = $basededonnees->prepare($SQL_LISTE_DEMONSTRATIONS);
	$requeteListeDemonstrations->execute();
	$listeDemonstrations = $requeteListeDemonstrations->fetchAll(PDO::FETCH_OBJ);
	//print_r($listeDemonstrations);
}

?>


<demonstrations>

<?php
foreach($listeDemonstrations as $demonstration){
//print_r($demonstration);
?>
	<demonstration>
		<id><?php echo $demonstration->id?></id>
		<titre><?php echo $demonstration->titre?></titre>
	</demonstration>	

<?php
}
?>

</demonstrations>

