
<template>
<div>
  <h1>Todo List - {{ todoCount }}</h1>
  <todo-items></todo-items>
  <todo-form></todo-form>
</div>
</template>

<script>
import TodoItems from '@/components/TodoItems';
import TodoForm from '@/components/TodoForm';

export default {
  name : 'HomePage',
  computed : {
    todoCount : function () {
      return this.$store.state.todos.length;
    }
  },
  components : {
    TodoItems, TodoForm
  },
  mounted : function () {
    this.$store.dispatch('getAllTodos');
  }
}
</script>

<style scoped>
</style>
