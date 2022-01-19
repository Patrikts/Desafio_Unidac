# Desafio_Unidac

Link para o site da parte backend publicado no Heroku: https://lanche-unidac.herokuapp.com/

Aplicação para teste até o momento via Postman
  
  1.1 - Implementando Frontend foi implementado mas o cors para o heroku estava dando problema, então a aplicação está funcionando tanto você utilizando o link no Postman, por favor faça o clone da aplicação e suba localmente e realize o teste no link do heroku para exibir os resultados.

  1.2 - No pedido por favor fazer o teste pelo heroku pois pelo tempo que eu tive fora do trabalho foi o que consegui fazer.
  
  JSON para cadastro do pedido no Postman: 
  
  {
    "colaborador": 6,
    "lanche": 5
  }

  No colaborador coloque o código do colaborador, e no lanche o código do lanche, faltou apenas a NativeQuery e mostrar o erro no Postman,
  por favor quando você cadastrar o pedido no Postman você conseguira ver ele no Frontend.
  
  Tecnologias utilizadas:
  
  java com SpringBoot REST, injeção de dependencias no Maven, 
  Banco de Dados em teste H2, Banco de Dados PostgreSQL, Banco de Dados Heroku.
  Frontend em Flutter Web, validação de cpf e consumo da API REST.
