<?php
error_reporting(E_ALL);
ini_set('display_errors', 1);

$usager = 'root';
$motdepasse = '';
$hote = 'localhost';
$base = 'service.artiste';
$charset = 'utf8mb4'; // $charset = 'utf8';

$dsn = "mysql:host=$hote;dbname=$base;charset=$charset";
$basededonnees = new PDO($dsn, $usager, $motdepasse);

?>