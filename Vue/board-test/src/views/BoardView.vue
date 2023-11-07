<script setup>
import { RouterView } from "vue-router";
</script>
<template>
  <div>
    <h1>게시판 메인 화면 (BoardView)</h1>
    <h3>이 밑으로 서브 페이지(컴포넌트)가 존제합니다</h3>
    <hr />
    <RouterView></RouterView>
  </div>
</template>

<style scoped></style>
