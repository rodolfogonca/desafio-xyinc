Desafio Zup Este projeto tem como objetivo gerenciar coordenadas de GPS, tendo como funcionalidades cadastrar pontos de interesses(POIs), lista pontos cadastrados, e localizar pontos de interesses de acordo com a solicitação do usuário.
__________________________________________________________________________________________________________________________________________
1 - O desenvolvimento foi realizado especificamente nas tecnologias descritas abaixo 
	* Java 8
	* wildfly-10.1.0.Final(http://wildfly.org/downloads/) 
	* Maven

2 - Passos para execução do projeto 
	* Após o download do servidor wildfly, na pasta bin dentro do pacote do wildfly extraído acessar a basta bin e executar o arquivo standalone,  e linux .sh, se windows .bat;
	* Na pasta em que o projeto for clonado executar o comando mvn clean install	
3 - Serviços expostos pela API 
	* Todos os retornos são em formato JSON;
	* A URL base para acesso aos serviços abaixo http://localhost:8080/xyinc/service/ ;
	* /cargaBaseDados/ 
	   Serviço tem como objetivo apenas dar a carga inicial na tabela de coordenadas
	* /all
	   Serviço responsável por retornar todas as cordenadas cadastradas na base de dados
	* /pois?coordenadaX20&coordenadaY&raio=10 
	   coordenadaX = Parametro referente a coordenada X.
	   coordenadaY = Parametro referente a coordenada Y. 
	   raio        = Distância entre os pontos.
	   Serviço responsável por retornar os pontos de interesses de acordo com os filtros informados
	* @Post 
	   Modelo para utilização do serviço de post 
	   	{"id":null, 
		 "nome":"Teste", 
		 "coordenadaX":27,
		 "coordenadaY":12 
		}
	   Serviço responsável por persistir uma coordenada na base de dados.
  4 - Após a execução do passo 2 a cobertura de teste pode ser acompanhada na pasta {raiz-projeto-clonado}/target/jacoco-ut/index.html 
  5 - Para realização dos testes será necessário executar a primeira chamada de /cargaBaseDados/.
