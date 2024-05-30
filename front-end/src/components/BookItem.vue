<template>
  <div>
  <div class="book-item"  @click="navigateToEditBook">
    <h2>{{ book.titulo }}</h2>
    <p><strong>Editora:</strong> {{ book.editora }}</p>
    <p><strong>Autor:</strong> {{ book.autor }}</p>
    <p><strong>ISBN:</strong> {{ book.isbn }}</p>
    <p><strong>Ano:</strong> {{ book.ano }}</p>
    <p><strong>Edição:</strong> {{ book.edicao }}</p>
    <p v-if="book.emprestado"><strong>Emprestado:</strong> Sim</p>
    <p v-else><strong>Emprestado:</strong> Não</p>
    <p v-if="book.fimLeitura"><strong>Fim da Leitura:</strong> {{ new Date(book.fimLeitura).toLocaleDateString('pt-BR', {day: '2-digit', month: '2-digit', year: 'numeric' }) }}</p>
    <p v-else><strong>Fim da Leitura:</strong> - </p>
  </div>
  <button @click="excluirLivro">Excluir Livro</button>

  </div>

</template>

<script>
import axios from "axios";

export default {
  props: {
    book: {
      type: Object,
      required: true,
    },
  },
  methods: {
    navigateToEditBook() {
      this.$router.push(`/editar-livro/${this.book.idLivro}`);
    },
    excluirLivro(){
      try{
        axios.delete(`http://localhost:8080/livro/${this.book.idLivro}`).catch((e) =>{})
        this.$emit('bookDeleted', this.book.idLivro);
      }catch(e){
        console.error(e);
      }
    },
  },
};
</script>

<style scoped>
.book-item {
  cursor: pointer;
  border: 1px solid #ddd;
  border-radius: 5px;
  padding: 15px;
  margin-bottom: 10px;
  display: flex;
  flex-direction: column;
  width: 300px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  transition: transform 0.2s ease;
}

.book-item:hover {
  z-index: 999;
  transform: translateY(-2px);
}

.book-item h2 {
  margin-top: 0;
  font-size: 18px;
  margin-bottom: 10px;
}

.book-item p {
  margin-bottom: 5px;
  font-size: 14px;
  color: #333;
}

button {
  cursor: pointer;
  background-color: transparent;
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 5px 10px;
  margin-top: 10px;
  color: #f00;
  transition: background-color 0.2s ease;
}

button:hover {
  background-color: #eee;
}
</style>
