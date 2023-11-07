<script setup>
import { RouterView, RouterLink } from "vue-router";
</script>

<template>
  <header></header>
  <ul>
    <li>
      <RouterLink to="/">홈</RouterLink>
    </li>
    <li>
      <RouterLink to="/board">게시판</RouterLink>
    </li>
  </ul>

  <main><router-view></router-view></main>
</template>

<style scoped></style>
