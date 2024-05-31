  <template>
    <div class="livro-edit">
      <h2>Editar Livro</h2>

      <div class="livro-dados">
        <label for="titulo">Título:</label>
        <input type="text" id="titulo" v-model="livro.titulo" />

        <label for="autor">Autor:</label>
        <input type="text" id="autor" v-model="livro.autor" />

        <label for="editora">Editora:</label>
        <input type="text" id="editora" v-model="livro.editora" />

        <label for="isbn">ISBN:</label>
        <input type="text" id="isbn" v-model="livro.isbn" />

        <label for="ano">Ano:</label>
        <input type="number" id="ano" v-model="livro.ano" />

        <label for="edicao">Edição:</label>
        <input type="text" id="edicao" v-model="livro.edicao" />

        <button @click="salvarLivro">Salvar Livro</button>
      </div>
        <h3>Comentários</h3>
        <div class="comentarios">

          <comentario-form @comentario-criado="adicionarComentario" />

          <lista-comentarios :comentarios="livro.comentarios" @comentarioDeletado="deletarComentario"/>
        </div>
      <Notificacoes v-if="this.showNotification" :message="this.message" />
    </div>
  </template>

  <script>
  import ComentarioForm from '../components/Comentarios.vue';
  import ListaComentarios from '../components/ListaComentarios.vue';
  import axios from 'axios';
  import Notificacoes from '@/components/Notificacoes.vue';

  export default {
    components: {
      ComentarioForm,
      ListaComentarios,
      Notificacoes
    },
    data() {
      return {
        livro: {},
        novoComentario: '',
        showNotification: false,
        message: ''
      };
    },
    mounted() {
      const idLivro = this.$route.params.id;
      axios.get(`http://localhost:8080/livro/${idLivro}`)
          .then((response) => {
            this.livro = response.data;
          })
          .catch(() => {
            this.notificar('Livro não encontrado!')
          });
    },
    methods: {
      notificar(message) {
        this.showNotification = true;
        this.message = message;
        setTimeout(() => {
          this.showNotification = false;
          this.message = '';
        }, 3000)
      },

      salvarLivro() {
        axios.put(`http://localhost:8080/livro/${this.$route.params.id}`, this.livro)
            .then(() => {
              this.notificar('Livro salvo com sucesso!');
            })
            .catch(() => {
              this.notificar('Houve um erro, tente novamente em alguns segundos!');
            });
      },
      adicionarComentario(comentario) {
        axios.post(`http://localhost:8080/comentario/${this.$route.params.id}`, comentario)
            .then((response) => {
              this.livro.comentarios.push(response.data);
              this.notificar('Comentário publicado com sucesso!');
            })
            .catch(() => {
              this.notificar('Houve um erro, tente novamente em alguns segundos!');
            });
      },
      deletarComentario(comentarioId) {
        const commentIndex = this.livro.comentarios.findIndex(comment => comment.idComentario === comentarioId);
        if (commentIndex !== -1) {
          this.livro.comentarios.splice(commentIndex, 1);
          this.livro.comentarios = [...this.livro.comentarios];
          this.notificar('Comentário deletado com sucessos');
        }
      },
    },
  };
  </script>


  <style>

  .livro-edit{
    width: 50%;
    margin: 20px auto;
    padding: 20px;
    border-radius: 5px;
    font-size: 16px;
    line-height: 1.5;
  }

  .livro-edit h2 {
    text-align: center;
    margin-bottom: 20px;
  }
  .livro-dados{
    margin-bottom: 30px;
  }
  </style>