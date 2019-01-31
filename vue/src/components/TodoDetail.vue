
<template>
<div class="panel panel-default">
  <div class="panel-heading">Todo Detail Form</div>
  <div class="panel-body">
    <form>
      <div class="form-group">
        <label>Todo Id</label>
        <input v-model="todoDetail.id" type="text" class="form-control" placeholder="Todo Id" disabled>
      </div>
      <div class="form-group">
        <label>Todo Title</label>
        <input v-model="todoDetail.title" type="text" class="form-control" placeholder="Todo Title">
      </div>
      <div class="form-group">
        <label>Todo Completed Status</label>
        <div class="checkbox">
          <label><input v-model="todoDetail.completed" type="checkbox">Ticked true (not false)</label>
        </div>
      </div>
      <div class="form-group">
        <div class="row">
          <div class="col-md-6">
            <center><button v-on:click="updateTodoDetails()" type="button" class="btn btn-default" style="width:120px;">Commit</button></center>
          </div>
          <div class="col-md-6">
            <center><router-link tag="a" to="/" class="btn btn-default" style="width:120px;">Back</router-link></center>
          </div>
        </div>
      </div>
    </form>
  </div>
</div>
</template>

<script>
export default {
  name : 'TodoDetail',
  computed : {
    todoDetail : function () {
      return this.$store.state.todoDetail;
    }
  },
  created : function () {
    this.$store.dispatch('fetchTodoDetail', this.$route.params.id);
  },
  methods : {
    updateTodoDetails : function () {
      this.$store.dispatch('updateTodoDetails');
    }
  }
}
</script>

<style scoped>
</style>
