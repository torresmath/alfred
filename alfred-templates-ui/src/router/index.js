import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

function view(name) {
    return function(resolve) {
        require([`@/components/${name}.vue`], resolve);
    }
};

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: view('HelloWorld')
    }
  ]
})
