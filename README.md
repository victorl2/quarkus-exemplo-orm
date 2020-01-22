# Quarkus - Mapeamento ORM
_Uma simples aplicação em quarkus para **confirmar** que a utilização de mapeamentos **orm** via xml **não é suportada**_

## Documentação quarkus
O [guia sobre orm](https://quarkus.io/guides/hibernate-orm#hibernate-orm-in-development-mode) do quarkus denota na seção de **limitações** que não há suporte para mapeamentos orm utilizando arquivos xml com o seguinte excerto:

_**XML mapping** - 
Hibernate ORM allows to map entities using XML files; this capability isn’t enabled in Quarkus: use annotations instead as Quarkus can handle them very efficiently. This limitation could be lifted in the future, if there’s a compelling need for it and if someone contributes it._

## Como reproduzir
A única configuração a ser alterada é a de acesso ao banco de dados no **persistence.xml**, modifique as propriedades:

```
<property name="hibernate.connection.url" value="jdbc:postgresql://localhost:5432/frutas />
<property name="hibernate.connection.username" value="admin"/>
<property name="hibernate.connection.password" value="123456789"/>
```

Feito isso basta executar o comando ``mvn compile quarkus:dev``


Note que a aplicação irá **falhar ao executar**, o projeto apresenta o seguinte erro

```
Caused by: java.lang.UnsupportedOperationException: Value found for #getMappingFileNames : not supported yet
	at io.quarkus.hibernate.orm.runtime.boot.LightPersistenceXmlDescriptor.verifyIgnoredFields(LightPersistenceXmlDescriptor.java:53)
```

Isto é devido a configuração _( dentro do persistence.xml )_ para arquivos orm _( atualmente não suportada pelo quarkus )_:

```
<mapping-file>META-INF/orm/GlobalConfig.orm.xml</mapping-file>
<mapping-file>META-INF/orm/Fruta.orm.xml</mapping-file>
```

Podemos concluir então que a informação fornecida pela documentação do quarkus é verdadeira, a utilização de arquivos **xml** para mapeamento orm **não é suportada**. Sendo recomendada a utilização de **anotações** pelo [guia orm quarkus](https://quarkus.io/guides/hibernate-orm#hibernate-orm-in-development-mode)
