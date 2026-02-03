# WeatherApp - Aplicativo Educacional de Previsão do Tempo

## Introdução

O WeatherApp é um projeto educacional completo desenvolvido em Java com o framework Spring Boot, projetado para demonstrar de forma prática e estruturada os conceitos fundamentais do desenvolvimento web moderno. Este aplicativo serve como uma ferramenta de aprendizagem que ilustra a integração de diferentes componentes tecnológicos em uma aplicação funcional e realista.

Este projeto foi concebido com o propósito educacional de fornecer um exemplo concreto de implementação de padrões arquiteturais, consumo de APIs REST externas, processamento de dados em tempo real e construção de interfaces de usuário responsivas. Através da análise e experimentação com este código, desenvolvedores em formação podem compreender como os diferentes elementos de uma aplicação web se conectam e colaboram para fornecer uma funcionalidade completa.

## Funcionalidades Atuais

- **Dados Meteorológicos Atuais:** Obtém temperaturas (atuais, max e min), sensação térmica, precipitação, umidade e coordenadas geograficas.
- **Contexto de Localização:** Exibe região, país e hora local da cidade pesquisada
- **Interface Amigável:** Design limpo e responsivo utilizando Bootstrap 5
- **Tratamento Básico de Erros:**
  - Informa claramente sobre nomes de cidade inválidos ou desconhecidos
  - Previne falhas na aplicação, garantindo experiência suave mesmo com erros de API
  - Valida entrada para nomes de cidade vazios

## Tecnologias Utilizadas

### Backend
- **Java 17+ & Spring Boot 3:** Framework principal para a lógica do servidor
- **Spring Web:** Manipula requisições e respostas web
- **RestTemplate / WebClient:** Usado para comunicação com a API externa de previsão do tempo

### Frontend
- **Thymeleaf:** Motor de templates que constrói páginas HTML dinâmicas
- **HTML5 & CSS3 (Bootstrap 5):** Para estrutura e estilização das páginas web

### API Externa
- **OpenWeatherMap API:** Fornece os dados meteorológicos. Documentação disponível em: https://openweathermap.org/api
- **Nota:** O código atual está configurado para usar a WeatherAPI.com, mas pode ser adaptado para utilizar a OpenWeatherMap API conforme necessário para fins educacionais.
  
### Interface da aplicação:

## Configuração e Execução Local
<img width="1339" height="991" alt="Screenshot from 2026-02-03 16-19-41" src="https://github.com/user-attachments/assets/935c2659-5164-48f2-861b-f7662d0a5d10" />

1. **Obtenha o código:**
   ```bash
   git clone https://github.com/Erixian/WeatherApp.git
   cd WeatherApp
   ```

2. **Obtenha uma chave de API:**
   - Para usar a OpenWeatherMap API, cadastre-se em https://openweathermap.org/api para obter sua chave gratuita

3. **Configure sua chave de API:**
   - Abra `src/main/resources/application.properties`
   - Adicione estas linhas, substituindo `SUA_CHAVE_DE_API_AQUI` pela sua chave real:
     ```
     weather.api.key=SUA_CHAVE_DE_API_AQUI
     weather.api.url=http://api.openweathermap.org/data/2.5/weather
     ```

4. **Compile e execute:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

5. **Acesse o aplicativo:** Abra seu navegador em:
   ```
   http://localhost:8080/home
   ```

## Melhorias Previstas

Como projeto educacional em constante evolução, planejamos implementar as seguintes melhorias:

### 1. Previsão para 5 Dias
- Implementação de endpoint para buscar previsão estendida
- Criação de interface para exibição de previsão diária
- Gráficos visuais para variação de temperatura ao longo dos dias

### 2. Tratamento de Timestamp para Mostrar Hora Local
- Conversão precisa de timestamps UTC para o fuso horário local de cada cidade
- Exibição do horário local formatado de acordo com a localidade
- Atualização em tempo real do relógio local na interface

### 3. Tratamento de Erros Robusto
- Sistema de logs estruturado para monitoramento de erros
- Páginas de erro personalizadas com informações úteis ao usuário
- Retry automático para falhas temporárias de API
- Fallback para dados meteorológicos básicos em caso de indisponibilidade da API
- Monitoramento de saúde da aplicação e da conexão com APIs externas

## Estrutura do Projeto

```
WeatherApp/
├── src/main/java/           # Código fonte Java
│   ├── controller/          # Controladores Spring
│   ├── model/               # Modelos de dados
│   ├── service/             # Lógica de negócio
│   └── config/              # Configurações da aplicação
├── src/main/resources/
│   ├── templates/           # Arquivos Thymeleaf
│   ├── static/              # CSS, JS, imagens
│   └── application.properties
├── pom.xml                  # Dependências Maven
└── README.md                # Este arquivo
```

## Contribuindo

Este projeto é aberto para contribuições da comunidade educacional. Sinta-se à vontade para:

1. Reportar problemas (issues)
2. Sugerir novas funcionalidades
3. Enviar pull requests com melhorias

## Licença

Este projeto é destinado para fins educacionais.

---

*Projeto educacional desenvolvido para demonstrar conceitos de desenvolvimento web full-stack com Spring Boot e consumo de APIs externas.*
