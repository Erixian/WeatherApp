# 🌤️ WeatherApp

Um aplicativo web desenvolvido em Java com Spring Boot para consulta de condições meteorológicas em tempo real através da integração com APIs externas.

## 📋 Descrição

O WeatherApp é uma aplicação web completa que permite aos usuários consultar condições climáticas atuais de qualquer cidade ao redor do mundo. Desenvolvido como projeto de estudo, o foco principal está na integração com APIs externas e no desenvolvimento full-stack com Spring Boot.

## ✨ Funcionalidades

- 🔍 **Consulta em tempo real** de condições meteorológicas
- 📱 **Interface responsiva** com Bootstrap
- 🌍 **Suporte global** para cidades worldwide
- 📊 **Múltiplos dados climáticos**: temperatura, umidade, vento, UV, precipitação
- 🌙 **Detecção automática** de dia/noite

## 🛠️ Tecnologias Utilizadas

### Backend
- ![Java 17](https://img.shields.io/badge/Java-17-blue?logo=java) **Java 17**
- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-green?logo=springboot) **Spring Boot 3.5.5**
- ![Spring MVC](https://img.shields.io/badge/Spring%20MVC-lightgreen?logo=spring) **Spring MVC** 
- ![REST Template](https://img.shields.io/badge/REST%20Template-orange?logo=java) **REST Template** 
- ![Maven](https://img.shields.io/badge/Maven-3.8.4-red?logo=apachemaven) **Maven** 

### Frontend
- ![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.0.12-blue?logo=thymeleaf) **Thymeleaf** 
- ![Bootstrap](https://img.shields.io/badge/Bootstrap-5.3.8-lightblue?logo=bootstrap) **Bootstrap 5.3.8** 
- ![HTML5](https://img.shields.io/badge/HTML5-5.0-orange?logo=html5) **HTML5**
- ![CSS3](https://img.shields.io/badge/CSS3-3.0-blue?logo=css3) **CSS3**


### API Externa
- **WeatherAPI.com** - Provedor de dados meteorológicos

## 🚀 Como Executar

### Pré-requisitos
- Java 17 ou superior
- Maven 3.6+
- Chave de API do [WeatherAPI.com](https://www.weatherapi.com/)

### Configuração e Execução

1. **Clone o repositório**
```bash
git clone https://github.com/Erixian/WeatherApp.git
cd WeatherApp
```

2. **Configure a chave da API**
Edite o arquivo `src/main/resources/application.properties`:
```properties
weatherapi.key=sua_chave_aqui
```

3. **Execute a aplicação**
```bash
./mvnw spring-boot:run
```

4. **Acesse a aplicação**
Abra seu navegador e visite:
```
http://localhost:8080/home
```

## 🎯 Objetivos de Estudo

Este projeto foi desenvolvido com foco educacional, visando o aprendizado prático de:

- **Consumo de APIs REST** externas
- **Integração frontend-backend** com Thymeleaf
- **Padrão MVC** na prática com Spring Boot
- **Tratamento de erros** e exceções
- **Desenvolvimento full-stack** de aplicações web
- **Boas práticas** de desenvolvimento Java
- **Configuração e deployment** de aplicações Spring Boot

## 🔮 Roadmap e Melhorias Futuras

### 🎨 Experiência do Usuário
- [ ] Previsão estendida (N dias)
- [ ] Ícones climáticos animados
- [ ] Tema escuro/claro
- [ ] Geolocalização automática
- [ ] Busca com autocomplete

### 🔒 Segurança e Performance
- [ ] Tratamento de erros
- [ ] Logs estruturados e monitoramento
- [ ] Testes unitários e de integração
- [ ] Configuração de profiles (dev/prod)

## 📊 Status do Projeto

**Versão Atual:** 1.0.0  
**Status:** ✅ Funcional e Estável  
**Próxima Versão:** 2.0.0 (Em Planejamento)

## 🤝 Contribuições

Contribuições são bem-vindas! Como projeto de estudo, valorizamos especialmente:

- Sugestões de boas práticas
- Melhorias de código e arquitetura
- Issues relatando bugs
- Ideias para novas funcionalidades
- Documentação e exemplos
- 
## 👨‍💻 Autor

**Erixian**  
[GitHub](https://github.com/Erixian)  
*Desenvolvedor em formação focado no ecossistema Java e Spring*

---

> **💡 Nota Educacional:** Este projeto foi desenvolvido primariamente para fins de estudo e aprendizado prático no consumo de APIs REST, desenvolvimento web full-stack e arquitetura de software com Spring Boot.
```
