# my tasks api
## instalação
1. clone o repositorio usandosua IDE o no proprio terminal com o comando : git clone https://github.com/muriloorias/my-tasks-api.git
2. se sua ide/editor de codigo não configurar por padrao o gradle wrapper faça a configuração manual ou use seu gradle global
3. faça o reload usando o comando ./gradlew clean build ou usando a interface da IDE

## como usar testar
1. rode o arquivo principal MyTasksApplication.kt
2. abra seu cliente httpde poreferencia como por exemplo o postman ou insomnia 
3. teste get e post em /tasks, put em /tasks/edit/iddatarefa e delete em /tasks/delete/iddatarefa

## tecnologias usadas
- linguagem: kotlin
- framework: spring boot
- banco de dados: h2
