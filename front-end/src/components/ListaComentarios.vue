<template>
  <div class="lista-comentarios" v-for="comentario in this.comentarios" :key="comentario.idComentario">
    <p>
      {{ comentario.comentario }}
    </p>
    (Página {{ comentario.pagina }})<button @click="excluirComentario(comentario.idComentario)">Excluir Comentario</button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  emits: ["comentarioDeletado"],
  props: {
    comentarios: {
      type: Object,
    },
  },
  methods: {
    async excluirComentario(comentarioId) {
      await axios.delete(`http://localhost:8080/comentario/${comentarioId}`).catch((e) => {
            //notificacao
      })
      this.$emit('comentarioDeletado', comentarioId)
    },
  },
};
</script>

<style scoped>

.lista-comentarios:hover {
  background-color: #222222;
}

.lista-comentarios {
  margin: 10px 0;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 16px;
  line-height: 1.5;
}

.lista-comentarios button {
  background-color: transparent;
  border: none;
  cursor: pointer;
  font-size: 14px;
  color: #f00;
  padding: 5px 10px;
  border-radius: 5px;
  margin: 0 5px 0px auto
}

.lista-comentarios button:hover {
  background-color: #eee;
}

</style>