<?php

require_once 'classes/Conn.php';

Class Candidato{

    function __construct() {

    }

    public function mostrar(){
        
		// chama a conexão.
		$pdo = DB();
		// prepara a SQL statement.
		$stmt = $pdo->prepare("SELECT * FROM Candidato ORDER BY id ASC");
		// executa a statement.
		$stmt->execute();
		
		$resultados = array();
		
		while($row = $sql->fetch(PDO::FETCH_ASSOC)) {
			$resultados[] = $row;
		}

		if(!$resultados){
			throw new Exception("Nenhum candidato encontrado!");
		}
		return $resultados;		            
    }
}