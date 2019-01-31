
import Vue from 'vue';
import Router from 'vue-router';
import HomePage from '@/components/HomePage';
import TodoDetail from '@/components/TodoDetail';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HomePage',
      component: HomePage
    },
    {
      path: '/todo/:id',
      name: 'TodoDetail',
      component: TodoDetail
    }
  ]
});
