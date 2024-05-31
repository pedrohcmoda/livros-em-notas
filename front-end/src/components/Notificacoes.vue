<template>
  <div class="notification">
    <p>{{ message }}</p>
  </div>
</template>

<script>
export default {
  props: {
    message: {
      type: String,
      required: true
    }
  },
};
</script>

<style scoped>
.notification {
  position: fixed;
  top: 100px;
  left: 20px;
  background-color: rgba(159, 150, 42, 0.47);
  padding: 10px;
  color: white;
  font-size: 14px;
  border-radius: 5px;
  z-index: 9999;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>
