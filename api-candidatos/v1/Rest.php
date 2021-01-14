<?php

header('Content-Type: application/json; charset=utf-8');

require_once 'classes/Candidato.php';

class Rest{
	
	public static function open($requisicao){
		$url = explode('/', $_REQUEST['url']);
		$classe = ucfirst($url[0]);
		array_shift($url);

		$metodo = $url[0];
		array_shift($url);

		$parametros = array();
		$parametros = $url;

		try{
			if(class_exist($classe)){
				if(method_exists($classe, $metodo)){
				$retorno = call_user_func_array(array(new $classe, $metodo, $parametros);
				return json_encode(array('status' => 'Sucesso', 'dados' => $retorno));
				} else {
					return json_encode(array('status' => 'Erro', 'dados' => 'Método inexistente'));
				}
			} else {
				 return json_encode(array('status' => 'Erro', 'dados' => 'Classe inexistente'));
			}				
		} catch(Exception $e) {
			return json_encode(array('status' => 'Erro', 'dados' => e->getMessage()));				
		}
}

if(isset($_REQUEST)){
    Rest::open($_REQUEST);
}