<?php

define('HOST', 'localhost'); 
define('USER', 'root'); 
define('PASSWORD', ''); 
define('DATABASE', 'minhabase'); 
 
function DB()
{
    try {
        $pdo = new PDO('mysql:host='.HOST.';dbname='.DATABASE.'', USER, PASSWORD,
                     array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        return $pdo;
    } catch (PDOException $e) {
        return "Erro!: " . $e->getMessage();
        die();
    }
}
