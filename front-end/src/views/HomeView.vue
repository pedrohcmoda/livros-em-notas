<template>
  <div class="home-view">
    <div class="barra-busca">
      <input type="text" placeholder="Pesquisar por título ou autor" v-model="searchQuery" @input="buscar(searchQuery)" />
    </div>

    <div class="book-list">
      <BookItem v-for="book in filteredBooks" :key="book.idLivro" :book="book" @bookDeleted="livroDeletado"/>
    </div>

  </div>
</template>

<script>

import  axios from 'axios';
import BookItem from "@/components/BookItem.vue";

export default {
  components: {
    BookItem
  },
  props: {
    book: {
      type: Object,
    }
  },
  data() {
    return {
      books: [],
      filteredBooks: [],
      searchQuery: '',
    };
  },
  mounted() {
    this.buscaLivro();
  },
  methods: {
    async buscaLivro() {
      const response = await axios.get('http://localhost:8080/livro');
      this.books = response.data;
      this.filteredBooks = this.books;
    },
    buscar(query) {
      this.filteredBooks = this.books.filter((book) => {
        return (
          book.titulo.toLowerCase().includes(query.toLowerCase()) ||
          book.autor.toLowerCase().includes(query.toLowerCase())
        );
      });
    },
    async livroDeletado(bookId) {
      const bookIndex = this.books.findIndex(book => book.idLivro === bookId);
      if (bookIndex !== -1) {
        this.books.splice(bookIndex, 1)
        this.filteredBooks = this.books.filter(book => book.idLivro !== bookId);
      }
    },
  },
};
</script>

<style scoped>
  template{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;

  }
  .home-view {
    display: flex;
    width: 80%;
    flex-direction: column;
    align-items: center;
    padding: 20px;
  }

  .barra-busca {
    margin-bottom: 20px;
    width: 50%;
  }

  input[type="text"] {
    color: #000;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    width: 100%;
  }

  .book-list {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    width: 80%;
    gap: 15px;
    height: 700px;
    overflow: auto;
  }
</style>
