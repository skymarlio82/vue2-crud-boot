
import Vue from 'vue';
import App from './App';
import router from './router';
import store from './store';
import axios from 'axios';
import VueAxios from 'vue-axios';
// import $ from 'jquery';
// import 'bootstrap/dist/css/bootstrap.min.css';
// import 'bootstrap/dist/js/bootstrap.min';
// import 'font-awesome/css/font-awesome.min.css';

Vue.config.productionTip = false;
Vue.config.devtools = true;

Vue.use(VueAxios, axios);

new Vue({
  el : '#app',
  store,
  router,
  components : { App },
  template : '<App/>'
});
