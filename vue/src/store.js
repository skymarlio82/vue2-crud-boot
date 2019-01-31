
import Vue from 'vue';
import Vuex from 'vuex';
import Config from '@/config';

Vue.use(Vuex);

export default new Vuex.Store({
  state : {
    todos : [],
    newTodo : { id : 0, title : '', completed : false },
    todoDetail : { id : 0, title : '', completed : false }
  },
  mutations : {
    get_all_todos : function (state, todos) {
      state.todos = todos;
    },
    toggle_completed : function (state, todo) {
      todo.completed = !todo.completed;
    },
    remove_todo : function (state, index) {
      state.todos.splice(index, 1);
    },
    add_new_todo : function (state, todo) {
      state.todos.push(todo);
      state.newTodo.title = '';
    },
    fetch_todo_detail : function (state, todo) {
      state.todoDetail = todo;
    },
    update_todo_details : function (state, id) {
      if (id == state.todoDetail.id) {
        if (confirm("Updating completed!\r\nDo you want to go back?") == true) {
          window.location = "#/";
        }
      }
    }
  },
  actions : {
    getAllTodos : function (store) {
      Vue.axios.get(Config.API_ROOT + '/api/todo/todos').then(response => {
        store.commit('get_all_todos', response.data);
      });
    },
    toggleCompleted : function (store, todo) {
      Vue.axios.patch(Config.API_ROOT + '/api/todo/todos/' + todo.id + '/completed/' + (!todo.completed)).then(response => {
        store.commit('toggle_completed', todo);
      });
    },
    removeTodo : function (store, obj) {
      Vue.axios.delete(Config.API_ROOT + '/api/todo/todos/' + obj.id).then(response => {
        if (response.data == obj.id) {
          store.commit('remove_todo', obj.index);
        }
      });
    },
    addNewTodo : function (store) {
      Vue.axios.post(Config.API_ROOT + '/api/todo/todos', this.state.newTodo).then(response => {
        store.commit('add_new_todo', response.data);
      });
    },
    fetchTodoDetail : function (store, id) {
      Vue.axios.get(Config.API_ROOT + '/api/todo/todos/' + id).then(response => {
        store.commit('fetch_todo_detail', response.data);
      });
    },
    updateTodoDetails : function (store) {
      Vue.axios.put(Config.API_ROOT + '/api/todo/todos', this.state.todoDetail).then(response => {
        store.commit('update_todo_details', response.data.id);
      });
    }
  }
});
