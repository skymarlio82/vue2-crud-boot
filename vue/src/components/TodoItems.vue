
<template>
<ul class="list-group">
  <li class="list-group-item"
    v-for="(todo, index) in todos"
    v-bind:key="todo.id"
    v-bind:class="{ 'completed' : todo.completed }">
    <router-link :to="'/todo/'+todo.id">{{ todo.title }}</router-link>&nbsp;
    <span class="fa fa-ban pull-right" v-on:click="toggleCompleted(todo)"></span>&nbsp;&nbsp;&nbsp;
    <span class="fa fa-times pull-right" v-on:click="removeTodo(index, todo)"></span>
  </li>
</ul>
</template>

<script>
export default {
  name : 'TodoItems',
  computed : {
    todos : function () {
      return this.$store.state.todos;
    }
  },
  methods : {
    removeTodo : function (index, todo) {
      this.$store.dispatch('removeTodo', { id : todo.id, index : index });
    },
    toggleCompleted : function (todo) {
      this.$store.dispatch('toggleCompleted', todo);
    }
  }
}
</script>

<style scoped>
.completed {
  color: red;
  text-decoration: line-through;
}
</style>
