<template>
    <header>
      <a @click="this.$router.push('/')">
        <img alt="Logo Minha Lista de Livros" src="../assets/icone 512.png" height="50">
        <p>Minha Lista de Livros</p>
      </a>

      <a @click="this.$router.push('/adicionar-livro')">
        Adicionar Livro
      </a>
    </header>
</template>


<style>
  header {
    height: auto;
    display: flex;
    justify-content: space-between;
    width: 100%;
  }
  a img {
    border-radius: 50%;
    width: 50px;
    height: 50px;
  }
  a{
    padding: 10px;
    display: flex;
    align-items: center;
    gap: 20px;
    font-size: 2em;
    text-decoration: none;
    color: #efefef
  }
  
  a:hover{
    cursor: pointer;
    background-color: #222 ;
    transition: background-color 0.2s ease;
  }
  
</style>
  