<?php 

$filtresDemonstration = array(
'id_artiste'=>FILTER_SANITIZE_NUMBER_INT,
'titre'=>FILTER_SANITIZE_STRING,
'resume'=>FILTER_SANITIZE_STRING,
'date'=>FILTER_SANITIZE_STRING,
'lieu'=>FILTER_SANITIZE_STRING,
);

$demonstration = filter_var_array($_POST, $filtresDemonstration);
print_r($demonstration);

$SQL_AJOUTER_DEMONSTRATION = "INSERT INTO demonstration(id_artiste, titre, resume, date, lieu) VALUES(:id_artiste, :titre, :resume, :date, :lieu)"; 
include "connexion.php";
$requeteAjouterDemonstration = $basededonnees->prepare($SQL_AJOUTER_DEMONSTRATION);
$requeteAjouterDemonstration->bindParam(":id_artiste", $demonstration['id_artiste'], PDO::PARAM_INT);
$requeteAjouterDemonstration->bindParam(":titre", $demonstration['titre'], PDO::PARAM_INT);
$requeteAjouterDemonstration->bindParam(":resume", $demonstration['resume'], PDO::PARAM_INT);
$requeteAjouterDemonstration->bindParam(":date", $demonstration['date'], PDO::PARAM_INT);
$requeteAjouterDemonstration->bindParam(":lieu", $demonstration['lieu'], PDO::PARAM_INT);
$requeteAjouterDemonstration->execute();

?>

