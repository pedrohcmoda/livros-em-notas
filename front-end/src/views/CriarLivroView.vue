<template>
  <div class="livro-criar">
    <h2>Criar Livro</h2>

    <div class="livro-dados">
      <label for="titulo">Título:</label>
      <input type="text" id="titulo" v-model="novoLivro.titulo" />

      <label for="autor">Autor:</label>
      <input type="text" id="autor" v-model="novoLivro.autor" />

      <label for="editora">Editora:</label>
      <input type="text" id="editora" v-model="novoLivro.editora" />

      <label for="isbn">ISBN:</label>
      <input type="text" id="isbn" v-model="novoLivro.isbn" />

      <label for="ano">Ano:</label>
      <input type="number" id="ano" v-model="novoLivro.ano" />

      <label for="edicao">Edição:</label>
      <input type="text" id="edicao" v-model="novoLivro.edicao" />

      <label for="emprestado">Emprestado:</label>
      <input type="checkbox" id="emprestado" v-model="novoLivro.emprestado" />

      <label for="fimLeitura">Fim Leitura:</label>
      <input type="date" id="fimLeitura" v-model="novoLivro.fimLeitura" />

      <button @click="criarLivro">Criar Livro</button>
    </div>
  </div>
</template>


<script>
import axios from "axios";

export default {
  data() {
    return {
      novoLivro: {
        titulo: '',
        autor: '',
        editora: '',
        isbn: '',
        ano: 0,
        edicao: '',
        emprestado: false,
        fimLeitura: null
      }
    };
  },
  methods: {
    criarLivro() {
      var livroEnviado = {
        titulo: this.novoLivro.titulo,
        autor: this.novoLivro.autor,
        editora: this.novoLivro.editora,
        isbn: this.novoLivro.isbn,
        edicao: this.novoLivro.edicao,
        emprestado: this.novoLivro.emprestado,
        fimLeitura: this.novoLivro.fimLeitura? this.novoLivro.fimLeitura : null
      }
      axios.post('http://localhost:8080/livro', this.novoLivro).then(response => {
          this.$router.push('/');
        }).catch ((e) => {

        })
    }
  }
};
</script>


<style>
.livro-criar {
  margin: 20px auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  width: 60%;
  max-width: 800px;
  font-size: 16px;
  line-height: 1.5;
}

.livro-criar h2 {
  text-align: center;
  margin-bottom: 20px;
}

.livro-dados {
  display: grid;
  grid-template-columns: 1fr 3fr;
  gap: 15px;
}

.livro-dados label {
  display: flex;
  align-items: center;
  margin-bottom: 5px;
}

.livro-dados label span {
  margin-right: 10px;
}

.livro-dados input,
.livro-dados select,
.livro-dados textarea {
  color: #222222;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 5px
}

.livro-dados button {
  background-color: #4CAF50;
  color: #fff;
  border: none;
  cursor: pointer;
  font-size: 16px;
  padding: 10px 20px;
  border-radius: 5px;
  transition: background-color 0.3s ease;
}

.livro-dados button:hover {
  background-color: #45a049;
}

</style>