<template>
  <div class="comentario-form">
    <label for="comentario">Comentário:</label>
    <textarea id="comentario" v-model="novoComentario" rows="5" resize="none" />

    <div class="input-grupo">
      <label for="pagina">Página:</label>
      <input type="number" id="pagina" v-model="pagina" min="1" />
    </div>

    <button @click="enviarComentario">Enviar</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      novoComentario: '',
      pagina: 1
    };
  },
  methods: {
    enviarComentario() {
      this.$emit('comentario-criado', {
        comentario: this.novoComentario,
        pagina: this.pagina
      });
      this.novoComentario = '';
      this.pagina = 1;
    }
  }
};
</script>

<style scoped>
.comentario-form {
  display: flex;
  flex-direction: column;
  gap: 10px;
  padding: 15px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: rgba(255, 255, 255, 0);
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.comentario-form label {
  display: flex;
  align-items: center;
  margin-bottom: 5px;
}

.comentario-form label span {
  margin-right: 10px;
}

.comentario-form textarea {
  padding: 8px;
  color: #222222;
  border: 1px solid #ccc;
  border-radius: 5px;
  resize: none;
  font-size: 14px;
  line-height: 1.5;
}

.comentario-form input{
  color: #222222;
}

.comentario-form .input-grupo {
  display: flex;
  align-items: center;
}

.comentario-form .input-grupo input {
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 5px;
  width: 60px;
  text-align: center;
}

.comentario-form button {
  cursor: pointer;
  background-color: #4CAF50;
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  transition: background-color 0.3s ease;
  margin-top: 10px;
}

.comentario-form button:hover {
  background-color: #45a049;
}
</style>
