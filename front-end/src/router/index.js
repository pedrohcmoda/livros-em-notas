import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import EditarLivroView from "@/views/EditarLivroView.vue";
import CriarLivroView from "@/views/CriarLivroView.vue";
import NotFound from "@/views/NotFound.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/editar-livro/:id',
      name: 'editar-livro',
      component: EditarLivroView,
      props: true
    },
    {
      path: '/adicionar-livro',
      name: 'adicionar-livro',
      component: CriarLivroView,
    },
    {
      path: '/:pathMatch(.*)*',
      name: 'NotFound',
      component: NotFound
    }
  ],
})

export default router
