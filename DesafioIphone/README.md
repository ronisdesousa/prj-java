## Desafio

Modelagem e Diagramação de um Componente iPhone.

classDiagram
    TocadorMusicas <|-- Iphone
    Telefone <|-- Iphone
    Navegador <|-- Iphone
    TocadorMusicas <|-- Ipod
    Navegador <|-- Chrome
    Navegador <|-- Internet Explorer
    TocadorMusicas <|-- Walkman
    Telefone <|-- Nokia5125
    Iphone: +bloquearTela()
    Iphone: +desbloquearTela()
    class TocadorMusicas {
      <<interface>>  
      +tocar()
      +pausar()
      +avancar()
      +retornar()
    }
    class Telefone {
      <<interface>>
      +chamar()
      +desligar()
      +atender()
    }
    class Navegador {
      <<interface>>  
      +acessarPagina()
      +abrirNovaAba()
      +atualizar()
    }
