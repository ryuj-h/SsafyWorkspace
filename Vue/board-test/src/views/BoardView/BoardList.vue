<script setup>
import axios from "axios";
import { ref } from "vue";
import { RouterLink, useRouter } from "vue-router";

const router = useRouter();
const list = ref([]);
const getBoardList = async () => {
  const url = "http://localhost/vue/board";
  const response = await axios.get(url);
  list.value = response.data.articles;
};
getBoardList();

const moveDetail = (articleNo) => {
  router.push({
    name: "article-detail",
    params: { articleNo },
  });
};
</script>
<template>
  <div>
    <h1>boardlist</h1>
    <RouterLink :to="{ name: 'article-write' }">글쓰기</RouterLink>
    <table>
      <tr>
        <th>글 번호</th>
        <th>글 제목</th>
        <th>조회수</th>
        <th>작성일</th>
        <th>작성자</th>
      </tr>
      <tr
        v-for="article in list"
        @click="moveDetail(article.articleNo)"
        class="article-item"
      >
        <th>{{ article.articleNo }}</th>
        <th>{{ article.subject }}</th>
        <th>{{ article.hit }}</th>
        <th>{{ article.registerTime }}</th>
        <th>{{ article.userName }}</th>
      </tr>
    </table>
  </div>
</template>

<style scoped>
.article-item:hover {
  background-color: aqua;
}
</style>
