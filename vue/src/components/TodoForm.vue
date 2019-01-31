
<template>
<form v-on:submit.prevent="addNewTodo()">
  <div class="form-group">
    <input v-model="newTodo.title" type="text" class="form-control" placeholder="Add a new todo">
  </div>
  <div class="form-group">
    <input class="btn btn-success" type="submit" value="Add Todo">
  </div>
</form>
</template>

<script>
export default {
  name : 'TodoForm',
  computed : {
    newTodo : function () {
      return this.$store.state.newTodo;
    }
  },
  methods : {
    addNewTodo : function () {
      this.$store.dispatch('addNewTodo');
    }
  }
}
</script>

<style scoped>
</style>
