<template>
<div id="app" class="container">
  <div class="row">
    <div class="col-md-8 col-md-offset-2">
      <div class="panel panel-default">
        <div class="panel-heading">Welcome to VUE.JS 2.0 Tutorial</div>
        <div class="panel-body">
          <router-view/>
        </div>
      </div>
    </div>
  </div>
</div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
</style>
